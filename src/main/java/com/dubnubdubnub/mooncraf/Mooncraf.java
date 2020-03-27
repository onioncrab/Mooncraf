package com.dubnubdubnub.mooncraf;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.dubnubdubnub.mooncraf.init.iteminit;

import java.util.stream.Collectors;

@Mod("mooncraf")
public class Mooncraf
{
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "mooncraf";
    public static Mooncraf instance;

    public Mooncraf() 
    {
    	final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
    	modEventBus.addListener(this::setup);
    	modEventBus.addListener(this::doClientStuff);
        
        instance = this;
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
    	
    }

    private void doClientStuff(final FMLClientSetupEvent event) 
    {

    }

    
    
    
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }
    
    
    public static class MooncrafItemGroup extends ItemGroup
    {

		public static final MooncrafItemGroup instance = new MooncrafItemGroup(ItemGroup.GROUPS.length, "Mooncraf items");
    	
    	public MooncrafItemGroup(int index, String label) {
			super(index, label);
		}
    	
    	@Override
    	public ItemStack createIcon() {
    		return new ItemStack(iteminit.cheese);
    	}	
    }
    
    
    
    
    
    
}
