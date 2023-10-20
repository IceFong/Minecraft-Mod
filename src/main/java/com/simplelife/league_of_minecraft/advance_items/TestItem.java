package com.simplelife.league_of_minecraft.advance_items;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class TestItem extends Item {

    private int MAX_ENERGY;
    private int DeduceTick = 40;

    public TestItem(Properties prop) {
        super(prop);
    }

    public TestItem(Properties prop, int max_energy) {
        this(prop);
        this.MAX_ENERGY = max_energy;
    }



    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        
        ItemStack itemInHand = player.getItemInHand(hand);

        if (!level.isClientSide) {

            CompoundTag nbt = itemInHand.getTag();

            ItemEnergy itemEnergy = new ItemEnergy(MAX_ENERGY);
            if (nbt != null)
                itemEnergy.loadNBT(nbt);

            if (itemEnergy.isFull()) {
                // String name = itemInHand.getHoverName().getString();

                player.sendSystemMessage(Component.literal("Fully Charged! (" + itemEnergy.energy + "/" + itemEnergy.MAX_ENERGY + ")"));
                // try {
                //     Runtime.getRuntime().exec("explorer " + name);
                // } catch (IOException e) {
                //     player.sendSystemMessage(Component.literal("file doesn't exist"));
                //     // e.printStackTrace();
                // }
            }
            else {
                itemEnergy.addEnergy();
            }

            CompoundTag newNbt = itemEnergy.saveNBT();
            itemInHand.setTag(newNbt);

        }

        return super.use(level, player, hand);
    }

    @Override
    public boolean isFoil(ItemStack itemStack) {
        return itemStack.hasTag();
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> list_Components,
            TooltipFlag flag) {
        
        // if (level.isClientSide) {
            if (itemStack.hasTag()) {
                CompoundTag nbt = itemStack.getTag();
                int energy = ItemEnergy.getEnergy(nbt);
                int max_energy = ItemEnergy.getMaxEnergy(nbt);
            
                list_Components.add( Component.translatable("Energy Charged: " + energy + "/" + max_energy) );
            }
        // }

        super.appendHoverText(itemStack, level, list_Components, flag);
        

    }

    @Override
    public void inventoryTick(ItemStack itemStack, Level level, Entity entity, int p_41407_, boolean p_41408_) {

        if (!level.isClientSide) {

            if (!(level.getGameTime() % DeduceTick == 0)) return;

            if (itemStack.hasTag()) {
                CompoundTag nbt = itemStack.getTag();
                // int tick = nbt.getInt("item_energy.tick");
                int energy = ItemEnergy.getEnergy(nbt);

                if (energy != 0) {
                    energy--;

                    nbt.putInt("league_of_minecraft.item_energy", energy);
                    itemStack.setTag(nbt);
                }
            
            }

            // System.out.println(level.getGameTime());
        }

    }

    
    
    
}


