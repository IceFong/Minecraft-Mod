package com.simplelife.league_of_minecraft.custom_player;

import com.simplelife.league_of_minecraft.MainMod;

import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MainMod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PlayerConstruct {
    
    @SubscribeEvent
    public static void playerConstruct(EntityConstructing event) {
        if (event.getEntity() instanceof Player) {
            System.out.println("player created");
        }
    }

}
