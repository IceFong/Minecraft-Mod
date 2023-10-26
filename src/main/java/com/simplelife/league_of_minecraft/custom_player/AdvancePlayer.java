package com.simplelife.league_of_minecraft.custom_player;

import com.mojang.authlib.GameProfile;

import net.minecraft.client.ClientRecipeBook;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.stats.StatsCounter;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class AdvancePlayer extends LocalPlayer {

    public AdvancePlayer(Minecraft p_108621_, ClientLevel p_108622_, ClientPacketListener p_108623_,
            StatsCounter p_108624_, ClientRecipeBook p_108625_, boolean p_108626_, boolean p_108627_) {
        super(p_108621_, p_108622_, p_108623_, p_108624_, p_108625_, p_108626_, p_108627_);
                
    }

    int time;

    public int getPlayerTime() {
        return time;
    }

    public void setPlayerTime(int time) {
        this.time = time;
    }

    @Override
    public boolean isSpectator() {
        return false;
    }

    @Override
    public boolean isCreative() {
        return true;
    }
    
}
