package com.simplelife.league_of_minecraft.champion;

public class Garen extends Champion {
    
    public Garen() {
        
        _P = new GeneralAbility(0, ABILITY_TYPE.PASSIVE) {

            @Override
            public void castAbility() {
                System.out.println("Heal~~~");
                super.castAbility();
            }
            
        };

        _Q = new GeneralAbility(5, ABILITY_TYPE.ACTIVE) {

            @Override
            public void castAbility() {
                super.castAbility();
                System.out.println("Forward!!!");
            }
            
        };

        _W = new GeneralAbility(10, ABILITY_TYPE.ACTIVE) {

            @Override
            public void castAbility() {
                System.out.println("Urggg!!!");
                super.castAbility();
            }
            
        };

        _E = new GeneralAbility(10, ABILITY_TYPE.ACTIVE) {

            @Override
            public void castAbility() {
                System.out.println("I will not hold her!!!");
                super.castAbility();
            }
            
        };

        _R = new GeneralAbility(20, ABILITY_TYPE.ACTIVE) {

            @Override
            public void castAbility() {
                System.out.println("For the Demacia!!!");
                super.castAbility();
            }
            
        };


    }
    
    public Garen (Champion champion) {
        _P = champion._P;
        _Q = champion._Q;
        _W = champion._W;
        _E = champion._E;
        _R = champion._R;
    }

}
