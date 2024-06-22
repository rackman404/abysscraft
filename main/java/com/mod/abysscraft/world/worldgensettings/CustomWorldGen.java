package com.mod.abysscraft.world.worldgensettings;

import java.util.List;

import com.mod.abysscraft.AbyssCraft;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.SurfaceRuleData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.DensityFunctions;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.NoiseRouter;
import net.minecraft.world.level.levelgen.NoiseRouterData;
import net.minecraft.world.level.levelgen.NoiseSettings;

public class CustomWorldGen {
	
    
    public static final ResourceKey<NoiseGeneratorSettings> LAYERONE_GEN_SETTINGS = ResourceKey.create(Registries.NOISE_SETTINGS, 
    		new ResourceLocation(AbyssCraft.MODID, "layerone_gen_settings"));
    
    public static void bootstrap(BootstapContext<NoiseGeneratorSettings> context) {
        context.register(LAYERONE_GEN_SETTINGS, layerOneSettings(context));
    }
    
    
    
    public static NoiseGeneratorSettings layerOneSettings(BootstapContext<NoiseGeneratorSettings> context) {
    	   NoiseRouter customNoiseRouter = new NoiseRouter(
    	    		DensityFunctions.endIslands(1l) ,
    	    		DensityFunctions.endIslands(1l), 
    	    		DensityFunctions.endIslands(1l), 
    	    		DensityFunctions.endIslands(1l), 
    	    		DensityFunctions.endIslands(1l), 
    	    		DensityFunctions.endIslands(1l), 
    	    		DensityFunctions.endIslands(1l), 
    	    		DensityFunctions.endIslands(1l), 
    	    		DensityFunctions.endIslands(1l), 
    	    		DensityFunctions.endIslands(1l), 
    	    		DensityFunctions.endIslands(1l), 
    	    		DensityFunctions.endIslands(1l), 
    	    		DensityFunctions.endIslands(1l), 
    	    		DensityFunctions.endIslands(1l), 
    	    		DensityFunctions.endIslands(1l)     	
    	    		);
    	   
    	   
    	   return new NoiseGeneratorSettings(NoiseSettings.OVERWORLD_NOISE_SETTINGS, Blocks.STONE.defaultBlockState(), Blocks.AIR.defaultBlockState(), NoiseRouterData.none(), SurfaceRuleData.air(), List.of(), 63, true, false, false, false);
    	
    	
  	
    }
    
    
 
}
