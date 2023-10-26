// package com.simplelife.league_of_minecraft.custom_player;

// import com.simplelife.league_of_minecraft.MainMod;

// import net.minecraft.client.Minecraft;
// import net.minecraft.nbt.CompoundTag;
// import net.minecraft.network.chat.Component;
// import net.minecraft.server.MinecraftServer;
// import net.minecraft.world.entity.Entity;
// import net.minecraft.world.entity.player.Player;
// import net.minecraft.world.entity.vehicle.Minecart;
// import net.minecraftforge.event.TickEvent;
// import net.minecraftforge.event.TickEvent.ClientTickEvent;
// import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
// import net.minecraftforge.eventbus.api.SubscribeEvent;
// import net.minecraftforge.fml.common.Mod;

// @Mod.EventBusSubscriber(modid = MainMod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
// public class PlayerConstruct {

//     @SubscribeEvent
//     public static void playerConstruct(EntityConstructing event) {
//         Entity entity = event.getEntity();
//         if (entity instanceof Player) {
//             System.out.println("player created");
//             Player player = (Player) entity;
//             CompoundTag nbt = new CompoundTag();
//             nbt.putLong("player", player.level.getGameTime());
//             player.addAdditionalSaveData(nbt);
//             // player.setPlayerTime((int) player.level.getGameTime());
//             // AdvancePlayer adPlayer =
//             // player.setNoGravity(true);
//         }
//     }

// }
