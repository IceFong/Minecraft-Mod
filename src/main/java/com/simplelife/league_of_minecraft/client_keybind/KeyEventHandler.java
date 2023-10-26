package com.simplelife.league_of_minecraft.client_keybind;

import javax.swing.text.JTextComponent.KeyBinding;

import org.lwjgl.glfw.GLFW;

import com.mojang.blaze3d.platform.InputConstants;
import com.simplelife.league_of_minecraft.MainMod;

import net.minecraft.client.InputType;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.KeyboardHandler;
import net.minecraft.world.ticks.TickPriority;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.client.settings.KeyModifier;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.TickEvent.ClientTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MainMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class KeyEventHandler {

    public static final Lazy<KeyMapping> EXAMPLE_MAPPING = Lazy.of(() -> {
        System.out.println("KeyMapping");
        return new KeyMapping(
            MainMod.MODID + ".key.x",
            KeyConflictContext.IN_GAME,
            // ChampionKeyConflict.CHMAP,
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_X,
            MainMod.MODID + ".key.categories.test"
        );
    });
    // public static final KeyMapping TestKey = 

    @SubscribeEvent
    public static void registerBindings(RegisterKeyMappingsEvent event) {
        event.register(EXAMPLE_MAPPING.get());
    }
    

}
