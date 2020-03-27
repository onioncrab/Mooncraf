package com.dubnubdubnub.mooncraf.init;

import java.util.function.Supplier;

import com.dubnubdubnub.mooncraf.Mooncraf;
import com.dubnubdubnub.mooncraf.Mooncraf.MooncrafItemGroup;

import net.minecraft.item.AxeItem;
import net.minecraft.item.Food;
import net.minecraft.item.HoeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.LazyValue;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = Mooncraf.MOD_ID, bus = Bus.MOD)
@ObjectHolder(Mooncraf.MOD_ID)
public class iteminit 
{

	//Items
	public static final Item cheese = null;
	
	//Tools
	public static final Item bone_sword = null; 
	public static final Item bone_pickaxe = null; 
	public static final Item bone_axe = null; 
	public static final Item bone_shovel = null; 
	public static final Item bone_hoe = null; 
	
	
	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event)
	{
		//Items
		event.getRegistry().register(new Item(new Item.Properties().group(MooncrafItemGroup.instance).food(new Food.Builder().hunger(10).saturation(1.2f).setAlwaysEdible().effect(new EffectInstance(Effects.ABSORPTION, 2400, 1), 0.5f).effect(new EffectInstance(Effects.SPEED, 2400, 1), 1).build())).setRegistryName("cheese"));
		
		//Tools
		event.getRegistry().register(new SwordItem(ModItemTier.BONE_TIER, 6, 5.0f, new Item.Properties().group(MooncrafItemGroup.instance)).setRegistryName("bone_sword"));
		event.getRegistry().register(new PickaxeItem(ModItemTier.BONE_TIER, 3, 5.0f, new Item.Properties().group(MooncrafItemGroup.instance)).setRegistryName("bone_pickaxe"));
		event.getRegistry().register(new AxeItem(ModItemTier.BONE_TIER, 5, 5.0f, new Item.Properties().group(MooncrafItemGroup.instance)).setRegistryName("bone_axe"));
		event.getRegistry().register(new ShovelItem(ModItemTier.BONE_TIER, 3, 5.0f, new Item.Properties().group(MooncrafItemGroup.instance)).setRegistryName("bone_shovel"));
		event.getRegistry().register(new HoeItem(ModItemTier.BONE_TIER, 5.0f, new Item.Properties().group(MooncrafItemGroup.instance)).setRegistryName("bone_hoe"));
		
	}
	
	public enum ModItemTier implements IItemTier{
		
		// harvestLevel,  maxUses,  efficiency,  attackDamage,  enchantability, Supplier<Ingredient> repairMaterial
		BONE_TIER(3, 210, 5, 6, 20, () -> {
			return Ingredient.fromItems(Items.BONE);
		});
		
		private final int harvestLevel; 
		private final int maxUses; 
		private final float efficiency;
		private final float attackDamage;
		private final int enchantability;
		private final LazyValue<Ingredient> repairMaterial;
		
		private ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial) 
		{
			this.harvestLevel = harvestLevel;
			this.maxUses = maxUses;
			this.efficiency = efficiency;
			this.attackDamage = attackDamage;
			this.enchantability = enchantability;
			this.repairMaterial = new LazyValue<>(repairMaterial);
		}

		@Override
		public int getMaxUses() {
			return this.maxUses;
		}

		@Override
		public float getEfficiency() {
			return this.efficiency;
		}

		@Override
		public float getAttackDamage() {
			return this.attackDamage;
		}

		@Override
		public int getHarvestLevel() {
			return this.harvestLevel;
		}

		@Override
		public int getEnchantability() {
			return this.enchantability;
		}

		@Override
		public Ingredient getRepairMaterial() {
			return this.repairMaterial.getValue();
		}
		
	}

		
	 
}
