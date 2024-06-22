package com.mod.abysscraft.GUI;

import net.minecraft.client.gui.components.EditBox;

import org.jetbrains.annotations.NotNull;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.*;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;


//elements taken from darealturtywurty github 
public class InfoScreen extends Screen {
	private static final Component TITLE = Component.literal("gui.abysscraft.datascreen");
	
	private int leftPos, topPos;
	private int imageWidth, imageHeight;
	
	private BlockPos position;
	
	public InfoScreen(BlockPos position) {
		super(TITLE);
		
		this.position=position;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}
	
	@Override
	protected void init() {
		super.init();
		
		this.leftPos = (this.width - this.imageWidth) / 2;
	}
	


	/*

	@Override
	public void render (GuiGraphics graphics) {
		this.renderBackground(graphics);
		
		super.render(graphics, 100, 100, DOUBLE_CLICK_THRESHOLD_MS);
		
		
	}
	*/
}
