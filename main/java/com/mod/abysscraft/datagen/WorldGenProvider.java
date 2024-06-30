package com.mod.abysscraft.datagen;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

import com.mod.abysscraft.AbyssCraft;
import com.mod.abysscraft.world.biomes.CustomBiomes;
import com.mod.abysscraft.world.dimensions.CustomDimension;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;

public class WorldGenProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.DIMENSION_TYPE, CustomDimension::bootstrapType)
            .add(Registries.BIOME, CustomBiomes::boostrap)
            .add(Registries.LEVEL_STEM, CustomDimension::bootstrapStem);
    

    public WorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(AbyssCraft.MODID));
    }
}