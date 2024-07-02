package com.mod.abysscraft.GUI;

import net.minecraft.client.gui.components.EditBox;

import org.jetbrains.annotations.NotNull;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.*;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;


//elements taken from darealturtywurty github 
public class InfoScreen extends Screen {
	private static final Component TITLE = Component.literal("Bruh");
	
	private int leftPos, topPos;
	private int imgWidth, imgHeight;
	private Font clientFont;
	
	private EditBox editBox = new EditBox(Minecraft.getInstance().font, 10, 10, 10, 10, TITLE);
	
	@SuppressWarnings("resource")
	public InfoScreen(Component p_96550_, Font font) {
		  super(TITLE);
	} 
	 
	@Override
	protected void init() {
		super.init();
		
		this.addRenderableOnly(editBox);
	}
	
	@Override
	public void tick() {
		super.tick();
		this.editBox.tick();
	}

	

	@Override
	public void render(GuiGraphics graphics, int temp1, int temp2, float temp3) {
		this.renderBackground(graphics);
		
		super.render(graphics, temp1, temp2, temp3);
		
		
	}
	
	@Override
	public void onClose() {
	    // Stop any handlers here

	    // Call last in case it interferes with the override
	    super.onClose();
	}

	
	@Override
	public void removed() {
	    // Reset initial states here

	    // Call last in case it interferes with the override
	    super.removed();
	}
	
}
