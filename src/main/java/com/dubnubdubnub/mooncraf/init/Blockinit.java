package com.dubnubdubnub.mooncraf.init;

import com.dubnubdubnub.mooncraf.Mooncraf;
import com.dubnubdubnub.mooncraf.Mooncraf.MooncrafItemGroup;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = Mooncraf.MOD_ID, bus = Bus.MOD)
@ObjectHolder(Mooncraf.MOD_ID)
public class Blockinit 
{
	public static final Block cheese_block = null;
	
	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event)
	{
		event.getRegistry().register(new Block(Block.Properties.create(Material.ORGANIC).hardnessAndResistance(1.0f, 1.0f).sound(SoundType.SLIME)).setRegistryName("cheese_block"));
		
	}
	@SubscribeEvent
	public static void registerBlockItems(final RegistryEvent.Register<Item> event)
	{
		event.getRegistry().register(new BlockItem(cheese_block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS).group(MooncrafItemGroup.instance)).setRegistryName("cheese_block"));
		
	}

}
