package com.simplelife.league_of_minecraft.advance_items;

import net.minecraft.nbt.CompoundTag;

public class ItemEnergy {

    int MAX_ENERGY;
    int energy = 0;

    public ItemEnergy() {
        MAX_ENERGY = 10;

    }
    public ItemEnergy(int maxEnergy) {
        MAX_ENERGY = maxEnergy;
    }

    public ItemEnergy(int energy, int maxEnergy) {
        this.energy = energy;
        this.MAX_ENERGY = maxEnergy;
    }

    // public int getEnergy()  {
    //     return this.energy;
    // }

    public void addEnergy() {
        this.energy++;
    }

    public void addEnergy(int amount) {
        this.energy += amount;
    }

    public boolean isFull() {
        if (this.energy >= MAX_ENERGY) {
            return true;
        }
        return false;
    }

    public void resetEnergy() {
        this.energy = 0;
    }

    public void resetEnergy(int amount) {
        this.energy = amount;
    }

    public CompoundTag saveNBT() {
        CompoundTag nbt = new CompoundTag();
        nbt.putInt("league_of_minecraft.item_energy", this.energy);
        nbt.putInt("league_of_minecraft.max_item_energy", this.MAX_ENERGY);

        return nbt;
    }

    public void loadNBT(CompoundTag nbt) {
        this.energy = nbt.getInt("league_of_minecraft.item_energy");
        this.MAX_ENERGY = nbt.getInt("league_of_minecraft.max_item_energy");
    }

    public static int getEnergy(CompoundTag nbt) {
        return nbt.getInt("league_of_minecraft.item_energy");
    }

    public static int getMaxEnergy(CompoundTag nbt) {
        return nbt.getInt("league_of_minecraft.max_item_energy");
    }

}
