package com.mod.abysscraft.abyss;


import com.mod.abysscraft.init.SoundInit;
import com.mod.abysscraft.world.dimensions.CustomDimension;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.ChatComponent;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.ChatType;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.OutgoingChatMessage;
import net.minecraft.network.chat.PlayerChatMessage;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;





public class PlayerEffects {
	private int test = 1;
	
	private int previousHeight;
	private int currentHeight;
	private int deltaHeight = 0;
	private final int threshold = -10;
	
	//private boolean reachedThreshold = false;
	
	
	public void setCurrentHeight(Level World, Player player) {
		
		this.previousHeight = this.currentHeight;
		this.currentHeight = player.getBlockY();
		
		if (this.currentHeight > 0) { //if above "surface level", no point in calculating change in height
			this.deltaHeight = 0;
			this.previousHeight = 0;
			this.currentHeight = 0;
			return;
		}
		
		if(CustomDimension.LAYERONE_DIM_TYPE == player.level().dimensionTypeId()){ //for if i switch to checking dimensions instead of height

		}
		
		
		if (this.deltaHeight <= this.threshold && (this.previousHeight - this.currentHeight < 0)) { //if player is trying to go up and threshold was reached
			this.deltaHeight = 0;
			
			if (this.currentHeight < 0 && this.currentHeight >= -100) {
				
				player.displayClientMessage(Component.literal("Curse of the Abyss first layer effects triggered"), true);
				
				//debug music
				Minecraft.getInstance().getSoundManager().stop(); //stop all previous music from playing
				player.level().playSound(null, player.getX(), player.getY(), player.getZ(), SoundInit.TELEPORT_TO_FIRST_LAYER.get() , SoundSource.PLAYERS, 100.0f, 1.0f);
				
				player.addEffect((new MobEffectInstance(MobEffects.WEAKNESS, 200, 0, false, true, true)), player); //layer 0 effect

			}
			else if (this.currentHeight < -100) {
				player.displayClientMessage(Component.literal("Curse of the Abyss second layer effects triggered"), true);
				
				player.addEffect((new MobEffectInstance(MobEffects.CONFUSION, 200, 0, false, true, true)), player); //layer 1 effect
			}
			
		}
		else {
			this.deltaHeight += this.previousHeight - this.currentHeight;
			
			if (this.deltaHeight > 0) { //to prevent change in height while going down (only matters when going up)
				this.deltaHeight = 0;
			}
		}
		
		
		
		System.out.println(deltaHeight);
		
	}
	
	public void saveNBTData(CompoundTag nbt) {
		nbt.putInt("bruh", 1);
	}
	
	public void loadNBTData(CompoundTag nbt) {
		nbt.getInt("bruh");
	}
	
	public void copyFrom(PlayerEffects source) {
		this.test = source.test;
	}
}
