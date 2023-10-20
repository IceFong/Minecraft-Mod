package com.simplelife.league_of_minecraft.advance_items.item_functions;

public class GeneralAbility implements IAbility {

    boolean isCast = false;
    float cooldown;
    ABILITY_TYPE type;

    public GeneralAbility() {}
    public GeneralAbility(float cool, ABILITY_TYPE tp) {
        cooldown = cool;
        type = tp;
    }

    

    @Override
    public void castAbility() {
        isCast = true;
    }

    @Override
    public void cancelAbility() {
        isCast = false;
    }

}
