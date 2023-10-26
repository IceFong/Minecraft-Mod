package com.simplelife.league_of_minecraft.advance_items;

import com.simplelife.league_of_minecraft.MainMod;
import com.simplelife.league_of_minecraft.champion.Champion;

import net.minecraft.client.Minecraft;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.TickEvent.ServerTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;
import oshi.hardware.CentralProcessor.TickType;

public class HenshinItem extends Item {

    Champion champ;

    public HenshinItem(Properties prop, Champion champion) {
        super(prop);
        this.champ = champion;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemInhand = player.getItemInHand(hand);

        if (level.isClientSide) return InteractionResultHolder.pass(null);
        
        if (!itemInhand.hasTag()) {
            CompoundTag nbt = champ.save();
            itemInhand.setTag(nbt);
        }
        
        long gameTime = level.getGameTime();
        Champion champion = Champion.load(itemInhand.getTag()); // load champion form nbt tag

        champion.getTimer().setTime(gameTime); // set henshin timer's used time

        CompoundTag newNBT = champion.save(); // save champion to nbt tag
        itemInhand.setTag(newNBT);

        return InteractionResultHolder.success(itemInhand);
    }
    
    @Mod.EventBusSubscriber(modid = MainMod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
    private static class Tick {

        @SubscribeEvent
        public static void TickEvent(ServerTickEvent event) {
            if (event.side == LogicalSide.CLIENT) return;
            if (event.phase == TickEvent.Phase.END) {
                Player player = Minecraft.getInstance().player;
                
            }
        }
    }

}
