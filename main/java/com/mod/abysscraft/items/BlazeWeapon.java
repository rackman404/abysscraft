package com.mod.abysscraft.items;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.mod.abysscraft.AbyssCraft;
import com.mod.abysscraft.Capabilities.TickProvider;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class BlazeWeapon extends Item{
	 private final Multimap<Attribute, AttributeModifier> defaultModifiers;
	 private int currentTicks = 0;
	
	public BlazeWeapon(Properties properties) {
		super(properties);
		
		ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
		builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", -4, AttributeModifier.Operation.ADDITION));
		this.defaultModifiers = builder.build();
	}
	
	
	@Override
	public boolean mineBlock(ItemStack p_41416_, Level currentLevel, BlockState p_41418_, BlockPos blockPos, LivingEntity fuckIfIKnow) {
		currentLevel.explode(null, blockPos.getX(), blockPos.getY(), blockPos.getZ(), 2.0F, Level.ExplosionInteraction.TNT);
		return true;
		
	}
	
	@Override
	public boolean hurtEnemy(ItemStack thisitem, LivingEntity enemyEntity, LivingEntity PlayerEntity) { 
		
		enemyEntity.addEffect((new MobEffectInstance(MobEffects.GLOWING, 200, 0, false, true, true)), enemyEntity);
		
		PlayerEntity.level().explode(null, enemyEntity.getX(), enemyEntity.getY()- 0.15f, enemyEntity.getZ(), 1.0F, Level.ExplosionInteraction.TNT);
		

			
		thisitem.hurtAndBreak(1, PlayerEntity, e -> {
         e.broadcastBreakEvent(EquipmentSlot.MAINHAND);
		});
		
		
		//Capability class to be used as a timer. Tick event this capability is used with is done with player tick, therefore nothing happens if weapon is dropped
		thisitem.getCapability(TickProvider.TICKCAPABILITY).ifPresent(ticker -> {
			ticker.addEntity(enemyEntity);
			
		});
			
	    return true;
	}

}

