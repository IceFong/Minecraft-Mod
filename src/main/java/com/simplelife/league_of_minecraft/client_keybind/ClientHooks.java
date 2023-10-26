package com.simplelife.league_of_minecraft.client_keybind;

import com.simplelife.league_of_minecraft.menus.garen_menu.GarenScreen;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;

public class ClientHooks {
    public static void openScreen() {
        Minecraft.getInstance().setScreen(new GarenScreen(Component.literal("GAREN")));
    }
}
