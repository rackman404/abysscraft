package com.mod.abysscraft.events;

import com.mod.abysscraft.AbyssCraft;
import com.mod.abysscraft.abyss.PlayerEffects;
import com.mod.abysscraft.abyss.PlayerEffectsProvider;
import com.mojang.authlib.minecraft.client.MinecraftClient;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(modid = AbyssCraft.MODID)
public class ModEvents {
	
	@SubscribeEvent
	public static void onAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event) {
		if (event.getObject() instanceof Player) {
			if(!event.getObject().getCapability(PlayerEffectsProvider.PLAYER_EFFECTS).isPresent()){
				event.addCapability(new ResourceLocation(AbyssCraft.MODID), new PlayerEffectsProvider());
						
			}
		}
	}
	
	@SubscribeEvent
	public static void onPlayerCloned(PlayerEvent.Clone event) { //in case of player death
		if (event.isWasDeath()) {
			event.getOriginal().getCapability(PlayerEffectsProvider.PLAYER_EFFECTS).ifPresent(oldStore -> {
				event.getOriginal().getCapability(PlayerEffectsProvider.PLAYER_EFFECTS).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
		}
	}
	
	@SubscribeEvent
	public static void onRegisterCapabilities(RegisterCapabilitiesEvent event) {
		event.register(PlayerEffects.class);
	}
	
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.side == LogicalSide.SERVER) {
			event.player.getCapability(PlayerEffectsProvider.PLAYER_EFFECTS).ifPresent(playereffects -> {
				//code for manipulating test variable
				//event.player.sendSystemMessage(Component.literal(String.valueOf(event.player.getSpeed())));
				
				Level world = event.player.level();
				
				playereffects.setCurrentHeight(world, event.player);
				
				//System.out.println();
				//event.player.sendSystemMessage(Component.literal(String.valueOf(temp)));
				//event.player.getSpeed();
			});
			
		}
	}

}
