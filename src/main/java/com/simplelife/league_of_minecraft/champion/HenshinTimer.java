package com.simplelife.league_of_minecraft.champion;

import com.simplelife.league_of_minecraft.util.Variables;

import net.minecraft.nbt.CompoundTag;

public class HenshinTimer {
    
    long gameTick;
    long cooldown;
    boolean isUsed;

    public HenshinTimer() {
        gameTick = 0;
        cooldown = 180 * Variables.COOLDOWN_MULTIPLYER_TO_SECOND;
        isUsed = false;
    }

    public HenshinTimer(long cooldown) {
        this();
        this.cooldown = cooldown * Variables.COOLDOWN_MULTIPLYER_TO_SECOND;
    }

    public void setTime( long time ) {
        gameTick = time;
        isUsed = true;
    }

    public float getTimerInSecond(long time) {
        return (float) (cooldown + gameTick - time) / (float) Variables.COOLDOWN_MULTIPLYER_TO_SECOND;
    }
    
    public long getTimerInTick(long time) {
        return cooldown + gameTick - time;
    }

    public CompoundTag saveNBT(String mapName, CompoundTag nbt) {
        nbt.putLong(mapName + ".henshintimer", gameTick);
        nbt.putBoolean(mapName + ".isused", isUsed);

        return nbt;
    }

    public void loadNBT(String mapName, CompoundTag nbt) {
        gameTick = nbt.getLong(mapName + ".henshintimer");
        isUsed = nbt.getBoolean(mapName + ".isused");
    }

    public boolean canHenshin(long time) {
        return getTimerInTick(time) < 0 ? true : false;
    }

    public boolean doDestory(long time) {
        return canHenshin(time) && isUsed;
    }

}
