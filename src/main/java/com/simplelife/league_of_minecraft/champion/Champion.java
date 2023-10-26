package com.simplelife.league_of_minecraft.champion;

import javax.annotation.Nullable;

import org.jetbrains.annotations.NotNull;

import net.minecraft.nbt.CompoundTag;

public abstract class Champion {

    String henshinName;

    HenshinTimer timer;
    
    GeneralAbility _P;
    GeneralAbility _Q;
    GeneralAbility _W;
    GeneralAbility _E;
    GeneralAbility _R;

    CHAMP_STATE state;

    public Champion() {
        this.timer = new HenshinTimer(3);
    }
    public Champion(@Nullable GeneralAbility _P, @Nullable GeneralAbility _Q, @Nullable GeneralAbility _W, @Nullable GeneralAbility _E, @Nullable GeneralAbility _R) {
        this();
        this._P = _P;
        this._Q = _Q;
        this._W = _W;
        this._E = _E;
        this._R = _R;
        state = CHAMP_STATE.OFF;
    }

    public void P_Ability() {
        if (_P == null) return;
        if (!_P.isCast)
            _P.castAbility();
        else 
            _P.cancelAbility();
    }

    public AbilityCastResult Q_Ability(Long time) {
        if (_Q == null) return AbilityCastResult.NULL_FAIL;
        if (!_Q.isCast) {
            _Q.castAbility();
            _Q.putTime(time);
            return AbilityCastResult.SUCCESS;
        }
        else {
            // _Q.cancelAbility();
            return  AbilityCastResult.FAIL;
        }
    }

    public void W_Ability() {
        if (_W == null) return;
        if (!_W.isCast)
            _W.castAbility();
        else 
            _W.cancelAbility();
    }

    public void E_Ability() {
        if (_E == null) return;
        if (!_E.isCast)
            _E.castAbility();
        else 
            _E.cancelAbility();
    }

    public void R_Ability() {
        if (_R == null) return;
        if (!_R.isCast)
            _R.castAbility();
        else 
            _R.cancelAbility();
    }

    public boolean canCast_P() {
        return !_P.isCast;
    }
    public boolean canCast_Q() {
        return !_Q.isCast;
    }
    public boolean canCast_W() {
        return !_W.isCast;
    }
    public boolean canCast_E() {
        return !_E.isCast;
    }
    public boolean canCast_R() {
        return !_R.isCast;
    }
    

    public CompoundTag save() {
        CompoundTag nbt = new CompoundTag();
        nbt = _P.saveNBT("league_of_minecraft.ability.p",nbt);
        nbt = _Q.saveNBT("league_of_minecraft.ability.q",nbt);
        nbt = _W.saveNBT("league_of_minecraft.ability.w",nbt);
        nbt = _E.saveNBT("league_of_minecraft.ability.e",nbt);
        nbt = _R.saveNBT("league_of_minecraft.ability.r",nbt);
    
        nbt.putString("league_of_minecraft.champion.henshinname", henshinName);
        nbt = timer.saveNBT("league_of_minecraft.champion", nbt);

        return nbt;
    }

    public static Champion load(@NotNull CompoundTag nbt) {
        Champion champion = new Champion(){};

        champion._P.loadNBT("league_of_minecraft.ability.p", nbt);
        champion._Q.loadNBT("league_of_minecraft.ability.q", nbt);
        champion._W.loadNBT("league_of_minecraft.ability.w", nbt);
        champion._E.loadNBT("league_of_minecraft.ability.e", nbt);
        champion._R.loadNBT("league_of_minecraft.ability.r", nbt);

        champion.henshinName = nbt.getString("league_of_minecraft.champion.henshinname");
        champion.timer.loadNBT("league_of_minecraft.champion", nbt);

        return champion;
    }

    public void cooldownWait(Long time) {
        _P.refresh(time);
        _Q.refresh(time);
        _W.refresh(time);
        _E.refresh(time);
        _R.refresh(time);
    }

    public GeneralAbility get_P() {
        return _P;
    }
    public GeneralAbility get_Q() {
        return _Q;
    }
    public GeneralAbility get_W() {
        return _W;
    }
    public GeneralAbility get_E() {
        return _E;
    }
    public GeneralAbility get_R() {
        return _R;
    }
    public void set_P(GeneralAbility ga) {
        this._P = ga;
    }
    public void set_Q(GeneralAbility ga) {
        this._Q = ga;
    }
    public void set_W(GeneralAbility ga) {
        this._W = ga;
    }
    public void set_E(GeneralAbility ga) {
        this._E = ga;
    }
    public void set_R(GeneralAbility ga) {
        this._R = ga;
    }

    public String getName() {
        return henshinName;
    }

    public HenshinTimer getTimer() {
        return timer;
    }

}
