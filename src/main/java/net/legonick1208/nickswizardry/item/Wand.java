package net.legonick1208.nickswizardry.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class Wand extends Item {
    public Wand(Settings settings) {
        super(settings);
    }

    @Override
    public void onCraft(ItemStack stack, World world, PlayerEntity player) {
        super.onCraft(stack, world, player);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        if(!world.isClient & hand.equals(Hand.MAIN_HAND)) {
            // server client and mainhand
            if(stack.hasNbt()) {
                if(stack.getNbt().getBoolean("Test")){
                    stack.getNbt().putBoolean("Test",false);
                } else {
                    stack.getNbt().putBoolean("Test",true);
                    world.createExplosion(user,user.getX(),user.getY(),user.getZ(),50f, World.ExplosionSourceType.TNT);
                }
                // has nbt data already, and has exploded, set it to false and return so every other rightclick goes kaboom
            } else {
                // has no nbt data, or has not exploded, so we should go boom and set its data.
                stack.getOrCreateNbt();
                stack.getNbt().putBoolean("Test",true);
                world.createExplosion(user,user.getX(),user.getY(),user.getZ(),50f, World.ExplosionSourceType.TNT);
            }
        }
        return super.use(world, user, hand);
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return stack.hasNbt();
    }
}
