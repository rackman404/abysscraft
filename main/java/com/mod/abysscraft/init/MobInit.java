package com.mod.abysscraft.init;

import com.mod.abysscraft.AbyssCraft;
import com.mod.abysscraft.entities.mobs.TestMobEntity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MobInit {
	 public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, AbyssCraft.MODID);
	 
	 public static final RegistryObject<EntityType<TestMobEntity>> TESTMOB = ENTITY_TYPES.register("test_mob", () -> EntityType.Builder.of(TestMobEntity::new, MobCategory.CREATURE)
			 .sized(2.5f,2.5f).build("test_mob"));
	 
	 
	 public static void register(IEventBus eventBus) {
		 ENTITY_TYPES.register(eventBus);
	 }
	 
}
