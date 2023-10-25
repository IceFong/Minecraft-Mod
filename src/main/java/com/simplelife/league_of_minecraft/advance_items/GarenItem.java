package com.simplelife.league_of_minecraft.advance_items;

import java.util.List;

import javax.annotation.Nullable;

import com.simplelife.league_of_minecraft.champion.AbilityCastResult;
import com.simplelife.league_of_minecraft.champion.Garen;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

public class GarenItem extends Item {

    public GarenItem(Properties prop) {
        super(prop);
    }
    
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemInHand = player.getItemInHand(hand);

        if (!level.isClientSide) {
            if (!itemInHand.hasTag()) {
                CompoundTag nbt = new CompoundTag();
                itemInHand.setTag(nbt);
            }
            
            CompoundTag nbt =  itemInHand.getTag();
            Garen champ = new Garen();
            champ.load(nbt);
            AbilityCastResult result = champ.Q_Ability(level.getGameTime());
            player.sendSystemMessage(Component.literal("Cast Result:" + result.toString()));
            
            CompoundTag newNbt = champ.save();
            itemInHand.setTag(newNbt);

            return InteractionResultHolder.success(itemInHand);
        }
        else
            return InteractionResultHolder.pass(itemInHand);
    }

    @Override
    public void inventoryTick(ItemStack itemStack, Level level, Entity entity, int p_41407_, boolean p_41408_) {
        if (level.isClientSide) return;
        if (!itemStack.hasTag()) return;

        CompoundTag nbt = itemStack.getTag();
        Garen champion = new Garen();
        champion.load(nbt);

        champion.cooldownWait(level.getGameTime());
        CompoundTag newNbt = champion.save();
        itemStack.setTag(newNbt);
    }

    @Override
    public boolean isFoil(ItemStack itemStack) {
        if (!itemStack.hasTag()) return false;

        Garen g = new Garen();
        g.load(itemStack.getTag());  

        return g.canCast_Q() ? true : false;
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> listComponent,
            TooltipFlag p_41424_) {
        
        if (level == null) return;
        if (!itemStack.hasTag()) return;

        Garen g = new Garen();
        g.load(itemStack.getTag());
        
        float time = g.get_Q().getCooldownSecond(level.getGameTime());
        if (!(time < 0)) {
            MutableComponent hoverText = Component.translatable(time+"s");   
            listComponent.add(hoverText);
        }
        
        super.appendHoverText(itemStack, level, listComponent, p_41424_);
    }

    @Override
    public @org.jetbrains.annotations.Nullable ICapabilityProvider initCapabilities(ItemStack stack,
            @org.jetbrains.annotations.Nullable CompoundTag nbt) {
        // TODO Auto-generated method stub
        return super.initCapabilities(stack, nbt);
    }
    
    
    

}
