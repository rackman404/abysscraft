package com.mod.abysscraft.events;

import com.mod.abysscraft.AbyssCraft;
import com.mod.abysscraft.GUI.InfoScreen;
import com.mod.abysscraft.GUI.MainOverlay;
import com.mod.abysscraft.world.dimensions.CustomDimension;
import com.mod.abysscraft.world.dimensionspecialeffects.LayerOneDimEffects;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterDimensionSpecialEffectsEvent;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@EventBusSubscriber(modid = AbyssCraft.MODID, bus = Bus.MOD ,value = Dist.CLIENT)
public class OnClientSetupEvent {
	
	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event) {
		//event.enqueueWork(
			//() -> MenuScreens.register()
		//);
		
		
	}
	
	@SubscribeEvent
	public static void registerOverlays(RegisterGuiOverlaysEvent event) {	
	IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
	MainOverlay overlay = new MainOverlay();
	MinecraftForge.EVENT_BUS.register(overlay); //REGSITER THE EVENT HANDLER WITHIN

	event.registerBelowAll("main_overlay", overlay);
	
    System.out.println("Registered custom overlays");
	}
	
	@SubscribeEvent 
	public static void registerSpecialDimEffects(RegisterDimensionSpecialEffectsEvent event) {
		event.register(CustomDimension.LAYERONE_SPECIAL_EFFECTS, LayerOneDimEffects.LAYERONE);
		System.out.println("DIMENSION SPECIAL EFFECTS REGISTERED");
	}
	
}
