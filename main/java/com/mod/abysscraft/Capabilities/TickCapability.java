package com.mod.abysscraft.Capabilities;

import org.jetbrains.annotations.NotNull;

import com.mod.abysscraft.AbyssCraft;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.items.IItemHandler;


public class TickCapability implements ITick{
	
	private int ticks = 0;
	private LivingEntity enemy;

	@Override
	public void setTicks(int amt) {
		ticks = amt;
		
	}

	@Override
	public int getTicks() {
		return this.ticks;
	}
	
	@Override
	public void addEntity(LivingEntity ent){
		enemy = ent;
	}
	

	@Override
	public void resetTicks() {
		if (enemy != null) {
			if (enemy.isAlive() == true) {
				enemy.level().explode(null, enemy.getX(), enemy.getY()-0.25f, enemy.getZ(), 1.0F, Level.ExplosionInteraction.TNT);
			}
		}

		
		System.out.println("tick reset, called from tick capability class");
		ticks = 0;
		
	}

	@Override
	public void addTicks() {
		this.ticks += 1;
		if (ticks == 40) {
			resetTicks();
		}
	}

	@Override
	public void subtractTicks() {
		this.ticks -= 1;
		
	}


}
