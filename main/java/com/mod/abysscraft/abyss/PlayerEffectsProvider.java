package com.mod.abysscraft.abyss;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

//import com.mod.expandedtowns.abyss.PlayerEffects;

public class PlayerEffectsProvider implements ICapabilityProvider, INBTSerializable<CompoundTag>{
	public static Capability<PlayerEffects> PLAYER_EFFECTS = CapabilityManager.get(new CapabilityToken<PlayerEffects>() { }); 
	
	private PlayerEffects effects = null;
	private final LazyOptional<PlayerEffects> optional = LazyOptional.of(this::createPlayerEffects);  //where this:: is a method reference
	
	private PlayerEffects createPlayerEffects() {
		if (this.effects == null) {
			this.effects = new PlayerEffects();
		}
		
		return this.effects;
	}

	@Override
	public CompoundTag serializeNBT() {
		CompoundTag nbt = new CompoundTag();
		createPlayerEffects().saveNBTData(nbt);
		return nbt;
	}

	@Override
	public void deserializeNBT(CompoundTag nbt) {
		createPlayerEffects().loadNBTData(nbt);
		
	}

	@Override
	public <T> @NotNull LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
		if (cap == PLAYER_EFFECTS) {
			return optional.cast();
		}

	return LazyOptional.empty();
	}
	

	
	
}
