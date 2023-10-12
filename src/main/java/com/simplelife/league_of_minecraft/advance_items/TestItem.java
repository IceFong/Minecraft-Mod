package com.simplelife.league_of_minecraft.advance_items;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class TestItem extends Item {

    private int MAX_ENERGY;

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

            // TestItemSavedData savedData = level.getServer().overworld().getDataStorage().computeIfAbsent(
            //     TestItemSavedData::load,
            //     () -> new TestItemSavedData(this.itemEnergy),
            //     "item_energy");

            // this.itemEnergy = savedData.getItem  Energy();

            // player.sendSystemMessage(Component.literal("use"));
            itemEnergy.addEnergy();
            // player.sendSystemMessage(Component.literal(Integer.toString(itemEnergy.energy)));

            CompoundTag newNbt = itemEnergy.saveNBT();
            itemInHand.setTag(newNbt);

            // savedData.setItemEnergy(this.itemEnergy);

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

    
    
    
}


