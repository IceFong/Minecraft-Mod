package com.simplelife.league_of_minecraft.champion;

public enum ABILITY_TYPE {
    ACTIVE,
    ACTIVE_WITH_DURATION,
    PASSIVE;

    public static ABILITY_TYPE get(String str) {
        if (str == "ACTIVE") return ACTIVE;
        else return PASSIVE;
    }
}