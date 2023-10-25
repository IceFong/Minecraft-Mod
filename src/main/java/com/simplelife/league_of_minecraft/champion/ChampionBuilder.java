package com.simplelife.league_of_minecraft.champion;

import java.util.function.Supplier;

public class ChampionBuilder {

    GeneralAbility _P = null;
    GeneralAbility _Q = null;
    GeneralAbility _W = null;
    GeneralAbility _E = null;
    GeneralAbility _R = null;

    // public ChampionBuilder() {
    // }

    public Champion buildChampion() {
        return new Champion(_P, _Q, _W, _E, _R) {};
    }

    public ChampionBuilder createP(long cd, ABILITY_TYPE type) {
        _P = new GeneralAbility(cd, type);
        return this;
    }

    public ChampionBuilder createP(long cd, ABILITY_TYPE type, Supplier<?> sup) {
        _P = new GeneralAbility(cd, type) {
            @Override
            public void castAbility() {
                super.castAbility();
                sup.get();
            }
        };
        return this;
    }

    public ChampionBuilder createQ(long cd, ABILITY_TYPE type) {
        _Q = new GeneralAbility(cd, type);
        return this;
    }

    public ChampionBuilder createQ(long cd, ABILITY_TYPE type, Supplier<?> sup) {
        _Q = new GeneralAbility(cd, type) {
            @Override
            public void castAbility() {
                super.castAbility();
                sup.get();
            }            
        };
        return this;
    }

    public ChampionBuilder createW(long cd, ABILITY_TYPE type) {
        _W = new GeneralAbility(cd, type);
        return this;
    }

    public ChampionBuilder createW(long cd, ABILITY_TYPE type, Supplier<?> sup) {
        _W = new GeneralAbility(cd, type) {
            @Override
            public void castAbility() {
                super.castAbility();
                sup.get();
            }            
        };
        return this;
    }

    public ChampionBuilder createE(long cd, ABILITY_TYPE type) {
        _E = new GeneralAbility(cd, type);
        return this;
    }

    public ChampionBuilder createE(long cd, ABILITY_TYPE type, Supplier<?> sup) {
        _E = new GeneralAbility(cd, type) {
            @Override
            public void castAbility() {
                super.castAbility();
                sup.get();
            }            
        };
        return this;
    }

    public ChampionBuilder createR(long cd, ABILITY_TYPE type) {
        _R = new GeneralAbility(cd, type);
        return this;
    }

    public ChampionBuilder createR(long cd, ABILITY_TYPE type, Supplier<?> sup) {
        _R = new GeneralAbility(cd, type) {
            @Override
            public void castAbility() {
                super.castAbility();
                sup.get();
            }            
        };
        return this;
    }

}
