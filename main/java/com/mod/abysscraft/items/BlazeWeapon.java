package com.mod.abysscraft.items;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item.Properties;

public class BlazeWeapon extends Item{
	public BlazeWeapon(Properties properties) {
		super(properties);
	}
	
	@Override
	public boolean hurtEnemy(ItemStack thisitem, LivingEntity enemyEntity, LivingEntity PlayerEntity) { 
		
		enemyEntity.addEffect((new MobEffectInstance(MobEffects.GLOWING, 200, 0, false, true, true)), enemyEntity);
		//enemyEntity.addEffect((new MobEffectInstance(MobEffects.HARM, 1, 1, false, true, true)), enemyEntity);
		
		DamageSource source = DamageSources.generic();
		
		enemyEntity.hurt(DamageSources.generic(), 1);
		
	    return true;
	}
}

