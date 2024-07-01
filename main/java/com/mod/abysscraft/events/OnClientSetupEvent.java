package com.mod.abysscraft.events;

import com.mod.abysscraft.AbyssCraft;
import com.mod.abysscraft.world.dimensions.CustomDimension;
import com.mod.abysscraft.world.dimensionspecialeffects.LayerOneDimEffects;

import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterDimensionSpecialEffectsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(modid = AbyssCraft.MODID, bus = Bus.MOD ,value = Dist.CLIENT)
public class OnClientSetupEvent {
	
	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event) {

	}
	
	@SubscribeEvent 
	public static void registerSpecialDimEffects(RegisterDimensionSpecialEffectsEvent event) {
		event.register(CustomDimension.LAYERONE_SPECIAL_EFFECTS, LayerOneDimEffects.LAYERONE);
		System.out.println("DIMENSION SPECIAL EFFECTS REGISTERED");
	}
	
}
