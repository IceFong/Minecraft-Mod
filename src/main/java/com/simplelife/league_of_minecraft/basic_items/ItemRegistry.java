package com.simplelife.league_of_minecraft.basic_items;

import com.simplelife.league_of_minecraft.MainMod;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.RegistryObject;

public class ItemRegistry {
    
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MainMod.MODID);

    public static final RegistryObject<Item> GAREN_ITEM = ITEMS.register("garen_item", () -> 
        new Item( new Item.Properties() )
    );

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    // public static final RegistryObject<Item> NASUS_ITEM = null;

    // public static RegistryObject<Item> ALL_MODE_ITEMS;

    // @SubscribeEvent
    // public void register(RegisterEvent event) {
    //     event.register(ForgeRegistries.Keys.ITEMS, 
    //         helper -> {
    //             helper.register(new ResourceLocation(MainMod.MODID, "nasus_item"), Items.TOTEM_OF_UNDYING);
    //         }
    //     );
    // } 
}
