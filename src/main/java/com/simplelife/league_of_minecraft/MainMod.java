package com.simplelife.league_of_minecraft;

import com.mojang.logging.LogUtils;
import com.simplelife.league_of_minecraft.advance_items.AdvanceItemRegistry;
import com.simplelife.league_of_minecraft.basic_items.ItemRegistry;
import com.simplelife.league_of_minecraft.client_keybind.ClientClickHandler;
import com.simplelife.league_of_minecraft.client_keybind.KeyEventHandler;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.TickEvent.ClientTickEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.GenericEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MainMod.MODID)
public class MainMod
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "league_of_minecraft";
    
    // Directly reference a slf4j logger
    // private static final Logger LOGGER = LogUtils.getLogger();

    // // Create a Deferred Register to hold Blocks which will all be registered under the "examplemod" namespace
    // public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    // // Create a Deferred Register to hold Items which will all be registered under the "examplemod" namespace
    // public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    // // Creates a new Block with the id "examplemod:example_block", combining the namespace and path
    // public static final RegistryObject<Block> EXAMPLE_BLOCK = BLOCKS.register("example_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE)));
    // // Creates a new BlockItem with the id "examplemod:example_block", combining the namespace and path
    // public static final RegistryObject<Item> EXAMPLE_BLOCK_ITEM = ITEMS.register("example_block", () -> new BlockItem(EXAMPLE_BLOCK.get(), new Item.Properties()));

    public MainMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        //Manual
        ItemRegistry.register(modEventBus);
        AdvanceItemRegistry.register(modEventBus);
   
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        // Some common setup code
        // LOGGER.info("HELLO FROM COMMON SETUP");
        // LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));
    }

    private void addCreative(CreativeModeTabEvent.BuildContents event)
    {
        // if (event.getTab() == CreativeModeTabs.BUILDING_BLOCKS)
        //     event.accept(EXAMPLE_BLOCK_ITEM);

        // if (event.getTab() == CreativeTab.LEAGUE_OF_MINECRAFT_TAB) {
        //     event.accept(ItemRegistry.GAREN_ITEM);
        // }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        // LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            
        }
        
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    // @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
    // public static class ClientModEvents2
    // {
    //     @SubscribeEvent
    //     public static void onClientTick(ClientTickEvent event) {
    //         if (event.phase == TickEvent.Phase.END) {
    //             while (KeyEventHandler.EXAMPLE_MAPPING.get().consumeClick()) {
    //                 //Execute logic perform on click
    //                 System.out.println("xxxx");
    //             }
    //         }
    //     }
        
    // }

    
}
