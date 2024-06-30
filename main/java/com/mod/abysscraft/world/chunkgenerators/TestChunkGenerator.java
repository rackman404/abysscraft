package com.mod.abysscraft.world.chunkgenerators;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.Function;
import java.util.function.Supplier;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.NoiseColumn;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeManager;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.biome.FeatureSorter;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.GenerationStep.Carving;
import net.minecraft.world.level.levelgen.Heightmap.Types;
import net.minecraft.world.level.levelgen.RandomState;
import net.minecraft.world.level.levelgen.blending.Blender;
import net.minecraft.world.level.levelgen.structure.Structure.StructureSettings;

public class TestChunkGenerator extends ChunkGenerator {
	   //public static final Codec<ChunkGenerator> CODEC = BuiltInRegistries.CHUNK_GENERATOR.byNameCodec().dispatchStable(ChunkGenerator::codec, Function.identity());
	   protected final BiomeSource biomeSource;
	   private final Supplier<List<FeatureSorter.StepFeatureData>> featuresPerStep;
	   private final Function<Holder<Biome>, BiomeGenerationSettings> generationSettingsGetter;

	   
	public TestChunkGenerator(BiomeSource biomeSource, Supplier<List<FeatureSorter.StepFeatureData>> featuresPerStep) {
		super(biomeSource);
		this.biomeSource = null;
		this.featuresPerStep = featuresPerStep;
		this.generationSettingsGetter = null;
	}

	@Override
	protected Codec<? extends ChunkGenerator> codec() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void applyCarvers(WorldGenRegion p_223043_, long p_223044_, RandomState p_223045_, BiomeManager p_223046_,
			StructureManager p_223047_, ChunkAccess p_223048_, Carving p_223049_) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buildSurface(WorldGenRegion p_223050_, StructureManager p_223051_, RandomState p_223052_,
			ChunkAccess p_223053_) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void spawnOriginalMobs(WorldGenRegion p_62167_) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getGenDepth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public CompletableFuture<ChunkAccess> fillFromNoise(Executor p_223209_, Blender p_223210_, RandomState p_223211_,
			StructureManager p_223212_, ChunkAccess p_223213_) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSeaLevel() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMinY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getBaseHeight(int p_223032_, int p_223033_, Types p_223034_, LevelHeightAccessor p_223035_,
			RandomState p_223036_) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public NoiseColumn getBaseColumn(int p_223028_, int p_223029_, LevelHeightAccessor p_223030_,
			RandomState p_223031_) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addDebugScreenInfo(List<String> p_223175_, RandomState p_223176_, BlockPos p_223177_) {
		// TODO Auto-generated method stub
		
	} 
    
}