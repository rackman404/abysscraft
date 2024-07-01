package com.mod.abysscraft.Capabilities;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.mod.abysscraft.abyss.PlayerEffects;

import net.minecraft.core.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;



public class TickProvider implements ICapabilityProvider{
	public static Capability<TickCapability> TICKCAPABILITY = CapabilityManager.get(new CapabilityToken<TickCapability>() { }); 
	
	private TickCapability ticker = null;
	private final LazyOptional<TickCapability> optional = LazyOptional.of(this::createPlayerEffects);  //where this:: is a method reference
	
	private TickCapability createPlayerEffects() {
		if (this.ticker == null) {
			this.ticker = new TickCapability();
		}
		
		return this.ticker;
	}
	
	@Override
	public <T> @NotNull LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
		if (cap == TICKCAPABILITY) {
			return optional.cast();
		}

	return LazyOptional.empty();
	}
}
