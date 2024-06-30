package com.mod.abysscraft.init;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;


import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

//import main class
import com.mod.abysscraft.AbyssCraft;
import com.mod.abysscraft.items.LayerOneTeleportationRod;
import com.mod.abysscraft.items.PanFriedDemonFish;
import com.mod.abysscraft.items.BlazeWeapon;

@Mod(AbyssCraft.MODID)
public class ItemInit {
    // Create a Deferred Register to hold Items which will all be registered under the "examplemod" namespace
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, AbyssCraft.MODID);
    
    // Item Initialization
    public static final RegistryObject<Item> layerOneTeleportationRod = ITEMS.register("layer_one_teleportation_rod", () -> new LayerOneTeleportationRod(new Item.Properties().durability(20)));
    
    // Item Initialization
    public static final RegistryObject<Item> blazeWeapon = ITEMS.register("blaze_weapon", () -> new BlazeWeapon(new Item.Properties()
    		.durability(20)
    		.fireResistant()
    		.setNoRepair()));
    
    public static final RegistryObject<Item> panFriedDemonFish = ITEMS.register("pan_fried_demon_fish" , () -> new PanFriedDemonFish(new Item.Properties()
    		.food(new FoodProperties.Builder()
    				.nutrition(4)
    				.saturationMod(2)
    				.build()
    				)));
    
    // Creates a creative tab for the example item, that is placed after the combat tab
    public static final RegistryObject<CreativeModeTab> abyss_artifact_tab = AbyssCraft.CREATIVE_MODE_TABS.register("abyss_artifact_tab", () -> CreativeModeTab.builder()
    		.withTabsBefore(CreativeModeTabs.COMBAT)
    		.icon(() -> layerOneTeleportationRod.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(layerOneTeleportationRod.get());
                output.accept(blazeWeapon.get());
                output.accept(panFriedDemonFish.get());
            }).build());
    

    
}
