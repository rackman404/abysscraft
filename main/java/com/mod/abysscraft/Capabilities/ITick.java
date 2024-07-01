package com.mod.abysscraft.Capabilities;

import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public interface ITick {
	public void setTicks(int amt);
	public int getTicks();
	public void resetTicks();
	public void addTicks();
	public void subtractTicks();
	public void addEntity(LivingEntity ent);
}
