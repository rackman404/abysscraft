package com.mod.abysscraft.init;

import com.mod.abysscraft.AbyssCraft;
import com.mod.abysscraft.entities.mobs.TestMobEntity;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.DensityFunction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod(AbyssCraft.MODID)
public class WorldGenInit {
	
	public static final ResourceKey<Level> DEBUG = ResourceKey.create(Registries.DIMENSION, new ResourceLocation(AbyssCraft.MODID, "mysterious"));
	
	//public static final ResourceKey<DimensionSpecialEffects> LAYER_ONE_SPECIAL_EFFECTS = ResourceKey.create(Registries.DIMENSION, new ResourceLocation(AbyssCraft.MODID, "mysterious"));

	
	 
	 
	 public static void register(IEventBus eventBus) {

	 }
	 
}