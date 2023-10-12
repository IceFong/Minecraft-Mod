package com.simplelife.league_of_minecraft;

import com.simplelife.league_of_minecraft.advance_items.AdvanceItemRegistry;
import com.simplelife.league_of_minecraft.basic_items.ItemRegistry;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MainMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CreativeTab {

    public static CreativeModeTab LEAGUE_OF_MINECRAFT_TAB;
    
    @SubscribeEvent
    public static void buildCreativeTab( CreativeModeTabEvent.Register event ) {
    
        LEAGUE_OF_MINECRAFT_TAB = event.registerCreativeModeTab(
            new ResourceLocation(MainMod.MODID, "tab"), 
            builder -> {
                builder.title(Component.translatable("creativemodetab.league_of_minecraft_tab"))
                .icon(() -> new ItemStack(ItemRegistry.GAREN_ITEM.get()))
                .displayItems((params, output) -> {
                    output.accept(ItemRegistry.GAREN_ITEM.get());
                    output.accept(AdvanceItemRegistry.TEST_ITEM.get());
                    // output.accept(ItemRegistry.NASUS_ITEM.get());
                });
            }
        );

    }

}
