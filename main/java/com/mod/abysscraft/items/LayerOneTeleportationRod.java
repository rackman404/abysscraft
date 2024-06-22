package com.mod.abysscraft.items;


import java.util.List;

import javax.annotation.Nullable;

import com.mod.abysscraft.world.CustomTeleporter;
import com.mod.abysscraft.world.dimensions.CustomDimension;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;

public class LayerOneTeleportationRod extends Item{
		public LayerOneTeleportationRod(Properties properties) {
			super(properties);
		}
		
	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand){
		
		if (player.level() instanceof ServerLevel serverlevel) {
			MinecraftServer minecraftserver = serverlevel.getServer();
			
			//YO wtf is this syntax?????
			ResourceKey<Level> resourcekey = player.level().dimension() == CustomDimension.LAYERONE_LEVEL_KEY?
					Level.OVERWORLD: CustomDimension.LAYERONE_LEVEL_KEY;
			
			
			ServerLevel newDimension = minecraftserver.getLevel(resourcekey);
			
			player.teleportTo(newDimension, 0, 100, 0, null, 0, 0);

			
			if (newDimension != null && !player.isPassenger()) {
                if(resourcekey == CustomDimension.LAYERONE_LEVEL_KEY) {
                   // player.changeDimension(newDimension, new CustomTeleporter(player.blockPosition(), true));
                	player.teleportTo(newDimension, 0, 100, 0, null, 0, 0);

                } else {
                	player.teleportTo(newDimension, 0, 100, 0, null, 0, 0);
                    //player.changeDimension(newDimension, new CustomTeleporter(player.blockPosition(), false));
                }
            }
			
		}
		


		
		
		world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.ENDERMAN_TELEPORT, SoundSource.PLAYERS, 1.0F, 1.0F); //last 2 floats are volume and pitch
		
		player.getCooldowns().addCooldown(this, 60);

		
		ItemStack stack = player.getItemInHand(hand);

		return super.use(world, player, hand);
	}
	
	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
		tooltip.add(Component.literal("teleports you a few blocks from where you are looking at, 20 uses"));
		
		super.appendHoverText(stack, worldIn, tooltip, flagIn);
	}
	
	
	
}
