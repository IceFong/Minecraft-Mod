package com.simplelife.league_of_minecraft.champion;

import java.util.function.Consumer;
import java.util.function.Supplier;

import net.minecraft.nbt.CompoundTag;

public class GeneralAbility implements IAbility {

    private static final long COOLDOWN_MULTIPLYER_TO_SECOND = 20;
    boolean isCast = false;
    long cooldown = 0;
    long gameTick = 0;
    ABILITY_TYPE type;

    public GeneralAbility() {}
    public GeneralAbility(long cool, ABILITY_TYPE tp) {
        cooldown = cool * COOLDOWN_MULTIPLYER_TO_SECOND;
        type = tp;
    }
    

    @Override
    public void castAbility() {
        System.out.println("isCast = true");
        isCast = true;
    }

    @Override
    public void cancelAbility() {
        isCast = false;
    }
    
    public CompoundTag saveNBT(String mapName, CompoundTag nbt) {
        // nbt.putFloat(mapName + ".cd", cooldown);
        // nbt.putString(mapName + ".ability_type", type.toString());
        nbt.putLong(mapName + ".gametick", gameTick);
        nbt.putBoolean(mapName + ".iscast", isCast);
        
        return nbt;
    }

    public void loadNBT(String mapName, CompoundTag nbt) {
        // cooldown = nbt.getFloat(mapName + ".cd");
        // type = ABILITY_TYPE.get(nbt.getString(mapName + ".ability_type"));
        gameTick = nbt.getLong(mapName + ".gametick");
        isCast = nbt.getBoolean(mapName + ".iscast");
    }

    public void putTime(Long time) {
        gameTick = time;
    }

    public boolean canCast(Long time) {
        if (cooldown < 0) return true;
        return (gameTick + cooldown < time) ? false : true;
    }

    public long getCooldown(long time) {
        return (cooldown + gameTick - time);
    }

    public float getCooldownSecond(long time) {
        return (float) (cooldown + gameTick - time) / (float) COOLDOWN_MULTIPLYER_TO_SECOND;
    }

    public void refresh(Long time) {
        if (cooldown + gameTick < time) {
            isCast = false;
        }
    }
    // public void save() {

    // }

    // public void load() {

    // }

}
