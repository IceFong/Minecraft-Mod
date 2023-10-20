package com.simplelife.league_of_minecraft.advance_items.item_functions;

public class Garen extends Champion {
    
    public Garen() {
        
        _P = new GeneralAbility(0.0f, ABILITY_TYPE.PASSIVE) {

            @Override
            public void castAbility() {
                System.out.println("Heal~~~");
                super.castAbility();
            }
            
        };

        _Q = new GeneralAbility(5.0f, ABILITY_TYPE.ACTIVE) {

            @Override
            public void castAbility() {
                System.out.println("Forward!!!");
                super.castAbility();
            }
            
        };

        _W = new GeneralAbility(10.0f, ABILITY_TYPE.ACTIVE) {

            @Override
            public void castAbility() {
                System.out.println("Urggg!!!");
                super.castAbility();
            }
            
        };

        _E = new GeneralAbility(10.0f, ABILITY_TYPE.ACTIVE) {

            @Override
            public void castAbility() {
                System.out.println("I will not hold her!!!");
                super.castAbility();
            }
            
        };

        _R = new GeneralAbility(10.0f, ABILITY_TYPE.ACTIVE) {

            @Override
            public void castAbility() {
                System.out.println("For the Demacia!!!");
                super.castAbility();
            }
            
        };


    }
    
    

}
