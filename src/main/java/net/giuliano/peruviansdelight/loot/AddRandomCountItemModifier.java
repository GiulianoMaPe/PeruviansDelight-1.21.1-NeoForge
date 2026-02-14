package net.giuliano.peruviansdelight.loot;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;

public class AddRandomCountItemModifier extends LootModifier {
    // Necesita un item, un min_count, un max_count y un boolean (looting).
    public static final MapCodec<AddRandomCountItemModifier> CODEC = RecordCodecBuilder.mapCodec(inst ->
            LootModifier.codecStart(inst).and(
                    BuiltInRegistries.ITEM.byNameCodec().fieldOf("item").forGetter(e -> e.item)
            ).and(
                    Codec.INT.fieldOf("minCount").forGetter(e -> e.minCount)
            ).and(
                    Codec.INT.fieldOf("maxCount").forGetter(e -> e.maxCount)
            ).and(
                    Codec.BOOL.fieldOf("useLooting").forGetter(e -> e.useLooting)
            ).apply(inst, AddRandomCountItemModifier::new));

    private final Item item;
    private final int minCount;
    private final int maxCount;
    private final boolean useLooting;

    public AddRandomCountItemModifier(LootItemCondition[] conditionsIn, Item item, int minCount, int maxCount, boolean useLooting) {
        super(conditionsIn);
        this.item = item;
        this.minCount = minCount;
        this.maxCount = maxCount;
        this.useLooting = useLooting;
    }

    @Override
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext lootContext) {
        for (LootItemCondition condition : this.conditions) {
            if (!condition.test(lootContext)) {
                return generatedLoot;
            }
        }

        int amount = this.minCount + lootContext.getRandom().nextInt(this.maxCount - this.minCount + 1);

        if (this.useLooting) {
            Entity attacker = lootContext.getParamOrNull(LootContextParams.ATTACKING_ENTITY);

            if (attacker instanceof LivingEntity livingAttacker) {
                Holder<Enchantment> lootingEnch = lootContext.getLevel().registryAccess()
                        .lookupOrThrow(Registries.ENCHANTMENT)
                        .getOrThrow(Enchantments.LOOTING);

                int lootingLevel = EnchantmentHelper.getEnchantmentLevel(lootingEnch, livingAttacker);

                if (lootingLevel > 0) {
                    amount += lootContext.getRandom().nextInt(lootingLevel + 1);
                }
            }
        }

        generatedLoot.add(new ItemStack(this.item, amount));
        return generatedLoot;
    }

    @Override
    public MapCodec<? extends IGlobalLootModifier> codec() {
        return CODEC;
    }
}
