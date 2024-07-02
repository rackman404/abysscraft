package com.mod.abysscraft.GUI;

import com.mod.abysscraft.AbyssCraft;
import com.mod.abysscraft.abyss.PlayerEffects;
import com.mod.abysscraft.abyss.PlayerEffectsProvider;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.blaze3d.vertex.Tesselator;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.gui.overlay.ForgeGui;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AbyssCraft.MODID)
public class MainOverlay implements IGuiOverlay {
	//public static final ResourceLocation MAIN_OVERLAY = new ResourceLocation(AbyssCraft.MODID, "main_overlay");
	private String str = "";
	private Player currentPlayer;
	private PlayerEffects playerEffects;
	
	@SubscribeEvent
	public void onGUIPlayerGet(TickEvent.PlayerTickEvent event) {
		
		if (currentPlayer == null) { //get the instance of the server player (capability is attached to this and not local player)
			if (event.side == LogicalSide.SERVER) {
				currentPlayer = event.player;
			}
		}
		
	}

	@SuppressWarnings("resource")
	@Override
	public void render(ForgeGui gui, GuiGraphics guiGraphics, float partialTick, int screenWidth, int screenHeight) {
		if (currentPlayer == null) { //if player has somehow not been registered
			return;
		}
		else {
			if (playerEffects == null) { //get player effects
				currentPlayer.getCapability(PlayerEffectsProvider.PLAYER_EFFECTS).ifPresent(playereffects -> {
					this.playerEffects = playereffects;
				});
			}
		}
		
		//parameters are, font, string to display, distance from left side of screen, distance from top of screen, hex color (use misode.io)
		guiGraphics.drawString(Minecraft.getInstance().font, "Layer One", screenWidth/2 - 15, 1, 16777215);
		guiGraphics.drawString(Minecraft.getInstance().font, "Edge of the Abyss", screenWidth/2 - 30, 11, 16777215);
		
		guiGraphics.drawString(Minecraft.getInstance().font, "Abyss Information:", 1, screenHeight-40, 16777215);
		guiGraphics.drawString(Minecraft.getInstance().font, "Current Depth:" + String.valueOf(playerEffects.getActualHeight()) + "m" , 1, screenHeight-30, 16777215);
		guiGraphics.drawString(Minecraft.getInstance().font, "Curse Effect Threshold:" + String.valueOf(-playerEffects.getDeltaHeight()) + "m" , 01, screenHeight-20, 16777215);
		guiGraphics.drawString(Minecraft.getInstance().font, "Curse Effect" + "Weakness" , 01, screenHeight-10, 16777215);


		/*
		RenderSystem.disableDepthTest();
        RenderSystem.depthMask(false);
        RenderSystem.defaultBlendFunc();
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 0.7f);
        //RenderSystem.setShaderTexture(0, VITA_SLIME_LOCATION);
        Tesselator tesselator = Tesselator.getInstance();
        BufferBuilder bufferbuilder = tesselator.getBuilder();
        bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
        bufferbuilder.vertex(0.0D, (double) screenHeight, -90.0D).uv(0.0F, 1.0F).endVertex();
        bufferbuilder.vertex((double) screenWidth, (double) screenHeight, -90.0D).uv(1.0F, 1.0F).endVertex();
        bufferbuilder.vertex((double) screenWidth, 0.0D, -90.0D).uv(1.0F, 0.0F).endVertex();
        bufferbuilder.vertex(0.0D, 0.0D, -90.0D).uv(0.0F, 0.0F).endVertex();
        tesselator.end();
        RenderSystem.depthMask(true);
        RenderSystem.enableDepthTest();
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        */
        
	}


	
}
