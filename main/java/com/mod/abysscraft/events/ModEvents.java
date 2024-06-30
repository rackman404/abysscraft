package com.mod.abysscraft.events;

import com.mod.abysscraft.AbyssCraft;
import com.mod.abysscraft.abyss.PlayerEffects;
import com.mod.abysscraft.abyss.PlayerEffectsProvider;
import com.mojang.authlib.minecraft.client.MinecraftClient;

import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.AirBlock;
import net.minecraft.world.level.block.AnvilBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.level.ChunkEvent;
import net.minecraftforge.event.level.LevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(modid = AbyssCraft.MODID)
public class ModEvents {
	
	//shader events
	
	
	
	@SubscribeEvent
	public static void onLevelLoadEventLoaded(LevelEvent.Load event) {
		LevelAccessor level = event.getLevel();
		
		
		//test set block
		level.setBlock(new BlockPos(0,60,0), Blocks.TNT.defaultBlockState() , 1);
		
		//test set boundaries
		if (level.dimensionType().minY() == -512) { //if layer one
			System.out.println("WORLD GEN TEST FOR Layer One");
			
			/*
			for (int x = 0; x < 1000; x++) {
				for (int y = 0; y < 1000; y++) {
					level.setBlock(new BlockPos(x,y,-500), Blocks.BARRIER.defaultBlockState() , 1);
					level.setBlock(new BlockPos(x,y,-501), Blocks.STONE.defaultBlockState() , 1);

					level.setBlock(new BlockPos(x,y,500), Blocks.BARRIER.defaultBlockState() , 1);
					level.setBlock(new BlockPos(x,y,501), Blocks.STONE.defaultBlockState() , 1);

					level.setBlock(new BlockPos(-500,y,x), Blocks.BARRIER.defaultBlockState() , 1);
					level.setBlock(new BlockPos(-501,y,x), Blocks.STONE.defaultBlockState() , 1);

					level.setBlock(new BlockPos(1000,y,x), Blocks.BARRIER.defaultBlockState() , 1);
					level.setBlock(new BlockPos(1001,y,x), Blocks.STONE.defaultBlockState() , 1);
				}
			}
			*/
			
			BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
			
			
			for (int x = -10; x < 10; x++) {
				for (int z = -10; z < 10; z++) {
						level.setBlock(pos.set(x,150,z), Blocks.STONE.defaultBlockState() , 1);
					}
				}
			
		}
		

	}
	
	@SubscribeEvent
	public static void onChunkDataEventLoaded(ChunkEvent.Load event) {
		LevelAccessor level = event.getLevel();
		//if the chunk was newly loaded for first time
		if (event.isNewChunk() == true) {
			//System.out.println(event.getChunk().getPos());
			
			//record the chunk
			ChunkAccess chunk = event.getChunk();
			
		}
	}
	
	@SubscribeEvent
	public static void onAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event) {
		if (event.getObject() instanceof Player) {
			if(!event.getObject().getCapability(PlayerEffectsProvider.PLAYER_EFFECTS).isPresent()){
				event.addCapability(new ResourceLocation(AbyssCraft.MODID), new PlayerEffectsProvider());
						
			}
		}
	}
	
	@SubscribeEvent
	public static void onPlayerCloned(PlayerEvent.Clone event) { //in case of player death
		if (event.isWasDeath()) {
			event.getOriginal().getCapability(PlayerEffectsProvider.PLAYER_EFFECTS).ifPresent(oldStore -> {
				event.getOriginal().getCapability(PlayerEffectsProvider.PLAYER_EFFECTS).ifPresent(newStore -> {
					newStore.copyFrom(oldStore);
				});
			});
		}
	}
	
	@SubscribeEvent
	public static void onRegisterCapabilities(RegisterCapabilitiesEvent event) {
		event.register(PlayerEffects.class);
	}
	
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.side == LogicalSide.SERVER) {
			event.player.getCapability(PlayerEffectsProvider.PLAYER_EFFECTS).ifPresent(playereffects -> {
				//code for manipulating test variable
				//event.player.sendSystemMessage(Component.literal(String.valueOf(event.player.getSpeed())));
				
				Level world = event.player.level();
				
				playereffects.setCurrentHeight(world, event.player);
				
				//System.out.println();
				//event.player.sendSystemMessage(Component.literal(String.valueOf(temp)));
				//event.player.getSpeed();
			});
			
		}
	}

}
