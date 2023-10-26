package com.simplelife.league_of_minecraft.advance_items;

import java.util.List;

import javax.annotation.Nullable;

import com.simplelife.league_of_minecraft.champion.AbilityCastResult;
import com.simplelife.league_of_minecraft.champion.Garen;
import com.simplelife.league_of_minecraft.champion.HenshinTimer;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.event.level.NoteBlockEvent.Play;

public class GarenItem extends Item {

    public GarenItem(Properties prop) {
        super(prop);
    }

    
    
    @Override
    public InteractionResult useOn(UseOnContext context) {
        ItemStack itemInHand = context.getItemInHand();
        Level level = context.getLevel();
        Player player = context.getPlayer();

        if (!level.isClientSide) {
            if (!itemInHand.hasTag()) {
                CompoundTag nbt = new CompoundTag();
                nbt.putString("league_of_minecraft.champion.name", "Garen");
                itemInHand.setTag(nbt);
            }
            
            CompoundTag nbt =  itemInHand.getTag();
            Garen champ = new Garen();
            champ.load(nbt);

            // player.sendSystemMessage(Component.literal(champ.getName()));

            // AbilityCastResult result = champ.Q_Ability(level.getGameTime());
            // player.sendSystemMessage(Component.literal("Cast Result:" + result.toString()));
            


            CompoundTag newNbt = champ.save();
            itemInHand.setTag(newNbt);

            return InteractionResult.SUCCESS;
        }
        else
            return InteractionResult.PASS;
    }



    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemInHand = player.getItemInHand(hand);

        if (!level.isClientSide) {
            if (!itemInHand.hasTag()) {
                CompoundTag nbt = new CompoundTag();
                nbt.putString("league_of_minecraft.champion.henshinname", "Garen");
                itemInHand.setTag(nbt);
            }
            
            CompoundTag nbt =  itemInHand.getTag();
            Garen champ = new Garen();
            champ.load(nbt);

            long gameTick = level.getGameTime();
            // HenshinTimer h = champ.getTimer();
            if (champ.getTimer().canHenshin(gameTick)) {
                champ.getTimer().setTime(gameTick);
                // System.out.println("Henshin!!! My heart and sword always for the demacia.");
                player.sendSystemMessage(Component.literal("Henshin!!! My heart and sword always for the demacia."));
            }

            // player.sendSystemMessage(Component.literal(champ.getName()));

            

            // AbilityCastResult result = champ.Q_Ability(level.getGameTime());
            // player.sendSystemMessage(Component.literal("Cast Result:" + result.toString()));
            
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
        if (champion.getTimer().doDestory(level.getGameTime())) {
            Player player = (Player) entity;
            player.getInventory().removeItem(itemStack);
        }
        else {
            CompoundTag newNbt = champion.save();
            itemStack.setTag(newNbt);
        }

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

        Garen champ = new Garen();
        champ.load(itemStack.getTag());
        
        float time = champ.getTimer().getTimerInSecond(level.getGameTime());
        if (!(time < 0)) {
            MutableComponent hoverText = Component.translatable( "Henshin time remains - " + time +"s");   
            listComponent.add(hoverText);
        }
        
        super.appendHoverText(itemStack, level, listComponent, p_41424_);
    }



    @Override
    public void onDestroyed(ItemEntity p_150887_) {
        // TODO Auto-generated method stub
        super.onDestroyed(p_150887_);
    }
    
    
    

}
