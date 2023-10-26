// package com.simplelife.league_of_minecraft.custom_player;

// import com.simplelife.league_of_minecraft.MainMod;

// import net.minecraft.client.Minecraft;
// import net.minecraft.network.chat.Component;
// import net.minecraftforge.event.TickEvent;
// import net.minecraftforge.eventbus.api.SubscribeEvent;
// import net.minecraftforge.fml.common.Mod;

// @Mod.EventBusSubscriber(modid = MainMod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
// public class PlayerTick {
//     @SubscribeEvent
//     public static void Tick(TickEvent event) {
//         if (event.phase == TickEvent.Phase.END) {
//             AdvancePlayer player = (AdvancePlayer) Minecraft.getInstance().player;
//             if (player == null) return;
//             player.sendSystemMessage(Component.literal(player.readAdditionalSaveData(player) + "t"));
//             player.setPlayerTime((int) player.getLevel().getGameTime());
//         }
//     }
// }
