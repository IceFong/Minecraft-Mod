package com.simplelife.league_of_minecraft.advance_items;

import com.simplelife.league_of_minecraft.MainMod;
import com.simplelife.league_of_minecraft.champion.Garen;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AdvanceItemRegistry {
    
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MainMod.MODID);

    public static final RegistryObject<Item> TEST_ITEM = ITEMS.register("test_item", () -> 
        new TestItem( new Item.Properties().stacksTo(1), 10 )
    );

    public static final RegistryObject<Item> GAREN_ITEM = ITEMS.register("garen_item", () -> 
        new GarenItem( new Item.Properties().stacksTo(1) ) 
    );

    public static final RegistryObject<Item> GAREN_HENSHIN_ITEM = ITEMS.register("garen_henshin_item", () -> 
        new HenshinItem( new Item.Properties().stacksTo(1), new Garen() )
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
