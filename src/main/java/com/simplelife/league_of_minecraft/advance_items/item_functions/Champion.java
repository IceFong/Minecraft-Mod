package com.simplelife.league_of_minecraft.advance_items.item_functions;

import javax.annotation.Nullable;

public abstract class Champion {
    
    GeneralAbility _P;
    GeneralAbility _Q;
    GeneralAbility _W;
    GeneralAbility _E;
    GeneralAbility _R;

    public Champion() {}
    public Champion(@Nullable GeneralAbility _P, @Nullable GeneralAbility _Q, @Nullable GeneralAbility _W, @Nullable GeneralAbility _E, @Nullable GeneralAbility _R) {
        this._P = _P;
        this._Q = _Q;
        this._W = _W;
        this._E = _E;
        this._R = _R;
    }

    public void P_Ability() {
        if (_P == null) return;
        if (!_P.isCast)
            _P.castAbility();
        else 
            _P.cancelAbility();
    }

    public void Q_Ability() {
        if (!_Q.isCast)
            _Q.castAbility();
        else 
            _Q.cancelAbility();
    }

    public void W_Ability() {
        if (!_W.isCast)
            _W.castAbility();
        else 
            _W.cancelAbility();
    }

    public void E_Ability() {
        if (!_E.isCast)
            _E.castAbility();
        else 
            _E.cancelAbility();
    }

    public void R_Ability() {
        if (!_R.isCast)
            _R.castAbility();
        else 
            _R.cancelAbility();
    }


}
