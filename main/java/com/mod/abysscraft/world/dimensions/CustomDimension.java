package com.mod.abysscraft.world.dimensions;

import java.util.List;
import java.util.OptionalLong;

import com.mod.abysscraft.AbyssCraft;
import com.mod.abysscraft.world.biomes.CustomBiomes;
import com.mod.abysscraft.world.dimensionspecialeffects.LayerOneDimEffects;
import com.mojang.datafixers.util.Pair;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.SurfaceRuleData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.FixedBiomeSource;
import net.minecraft.world.level.biome.MultiNoiseBiomeSource;
import net.minecraft.world.level.biome.OverworldBiomeBuilder;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.DensityFunction;
import net.minecraft.world.level.levelgen.DensityFunctions;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.NoiseRouter;
import net.minecraft.world.level.levelgen.NoiseRouterData;
import net.minecraft.world.level.levelgen.NoiseSettings;

public class CustomDimension {
	public static final ResourceKey<LevelStem> LAYER_ONE_KEY = ResourceKey.create(Registries.LEVEL_STEM,
            new ResourceLocation(AbyssCraft.MODID, "layer_one"));
    public static final ResourceKey<Level> LAYERONE_LEVEL_KEY = ResourceKey.create(Registries.DIMENSION,
            new ResourceLocation(AbyssCraft.MODID, "layer_one_level"));
    public static final ResourceKey<DimensionType> LAYERONE_DIM_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE,
            new ResourceLocation(AbyssCraft.MODID, "layeronedim_type"));
    public static final ResourceLocation LAYERONE_SPECIAL_EFFECTS = new ResourceLocation("layer_one_special_effects");
    
    //PLACEHOLDER, NEEDED AS A PLACEHOLDER FOR DATA GENERATOR
    public static final ResourceKey<NoiseGeneratorSettings> LAYERONE_GEN_SETTINGS = ResourceKey.create(Registries.NOISE_SETTINGS,
            new ResourceLocation(AbyssCraft.MODID, "layer1_gensettings"));


    public static void bootstrapType(BootstapContext<DimensionType> context) {
        context.register(LAYERONE_DIM_TYPE, new DimensionType(
                OptionalLong.of(6000), // fixedTime
                true, // hasSkylight
                false, // hasCeiling
                false, // ultraWarm
                true, // natural
                1.0, // coordinateScale
                true, // bedWorks
                false, // respawnAnchorWorks
                -512, // minY
                1072, // height
                1072, // logicalHeight
                BlockTags.INFINIBURN_OVERWORLD, // infiniburn
                LAYERONE_SPECIAL_EFFECTS, // effectsLocation
                1.0f, // ambientLight
                new DimensionType.MonsterSettings(false, false, ConstantInt.of(0), 0)));
    }
    
    

    public static void bootstrapStem(BootstapContext<LevelStem> context) {
        HolderGetter<Biome> biomeRegistry = context.lookup(Registries.BIOME);
        HolderGetter<DimensionType> dimTypes = context.lookup(Registries.DIMENSION_TYPE);
        HolderGetter<NoiseGeneratorSettings> noiseGenSettings = context.lookup(Registries.NOISE_SETTINGS);
        		
        NoiseBasedChunkGenerator wrappedChunkGenerator = new NoiseBasedChunkGenerator(
                new FixedBiomeSource(biomeRegistry.getOrThrow(CustomBiomes.TEST_BIOME)),
                noiseGenSettings.getOrThrow(NoiseGeneratorSettings.AMPLIFIED));

        NoiseBasedChunkGenerator noiseBasedChunkGenerator = new NoiseBasedChunkGenerator(
        		MultiNoiseBiomeSource.createFromList(
                        new Climate.ParameterList<>(List.of(Pair.of(
                                        Climate.parameters(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), biomeRegistry.getOrThrow(CustomBiomes.TEST_BIOME))
                        ))),
                noiseGenSettings.getOrThrow(NoiseGeneratorSettings.FLOATING_ISLANDS));

        LevelStem stem = new LevelStem(dimTypes.getOrThrow(CustomDimension.LAYERONE_DIM_TYPE), noiseBasedChunkGenerator);

        context.register(LAYER_ONE_KEY, stem);
    }
	
}
