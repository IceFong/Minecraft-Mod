package com.simplelife.league_of_minecraft.client_keybind;

import net.minecraftforge.client.settings.IKeyConflictContext;

public enum ChampionKeyConflict implements IKeyConflictContext {

    CHMAP {
        @Override
        public boolean isActive() {
            return false;
        }

        @Override
        public boolean conflicts(IKeyConflictContext other) {
            return false;
        }
    }
    
    
}
