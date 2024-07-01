package com.mod.abysscraft.events;

import javax.annotation.Nullable;

import com.mod.abysscraft.AbyssCraft;
import com.mod.abysscraft.Capabilities.ITick;
import com.mod.abysscraft.Capabilities.TickCapability;
import com.mod.abysscraft.Capabilities.TickProvider;
import com.mod.abysscraft.init.ItemInit;
import com.mod.abysscraft.items.BlazeWeapon;

import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.level.LevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AbyssCraft.MODID)
public class CapabilitiesEvents {

	
	@SubscribeEvent
	public static void onItemStack(AttachCapabilitiesEvent<ItemStack> event) {
		if (event.getObject().getItem() == ItemInit.blazeWeapon.get()) {
			//System.out.println("Blaze reap itemstack attach event fired");
			
			
			TickCapability ticker = new TickCapability();
			LazyOptional<ITick> optionalTicker = LazyOptional.of(() -> ticker);
			
			//first create a ICapabilityProvider
			TickProvider provider =  new TickProvider() {};
			
			
			event.addCapability(new ResourceLocation(AbyssCraft.MODID, "blaze_tick_capability"), provider);
			
			
			/*
			if(!event.getObject().getCapability(TickProvider.TICKCAPABILITY).isPresent()){
				event.addCapability(new ResourceLocation(AbyssCraft.MODID, "provider"), new TickProvider());
						
			}
			*/
		}

	}
	
	//to register capabilities from the capabilities package
	@SubscribeEvent
	public void registerCapability(RegisterCapabilitiesEvent event) {
		event.register(ITick.class);
	}
}
