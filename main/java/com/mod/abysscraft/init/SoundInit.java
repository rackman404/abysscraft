package com.mod.abysscraft.init;
import com.mod.abysscraft.AbyssCraft;

import net.minecraft.resources.ResourceLocation;
//maybe correct import?
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.util.ForgeSoundType;
//import net.minecraftforge.client.event.sound.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


@Mod(AbyssCraft.MODID)
public class SoundInit {
	
	
	
	public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, AbyssCraft.MODID);
	
    public static final RegistryObject<SoundEvent> TELEPORT_TO_FIRST_LAYER = SOUND_EVENTS.register("teleport_to_first_layer", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(AbyssCraft.MODID, "teleport_to_first_layer")));

	
	
	/*
	 private static RegistryObject<SoundEvent> registerSoundEvents(String name){
		return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(AbyssCraft.MODID, name)));
	}
		public static final RegistryObject<SoundEvent> teleport_to_first_layer = registerSoundEvents("teleport_to_first_layer");

	// Sound Initialization

	//public static final ForgeSoundType MUSIC_SOUNDS = new ForgeSoundType(1f,1f, SoundInit.teleport_to_first_layer, null, null, null, null);
	
	public static void register (IEventBus eventBus) {
		SOUND_EVENTS.register(eventBus);
	}
		*/
	
	

}
