package net.legonick1208.nickswizardry.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.World;

public class SpellLibrary {
    //public static boolean castSPELL_NAME
    // false for failure to cast, true for success.
    public static boolean castSimpleExplosion(ItemStack stack, World world, PlayerEntity user, NbtCompound nbt){
        //Make this a packet later!
        // Simple tnt explosion centered on the player, that does not damage the user. Might cause fire damage to the user though!
        world.createExplosion(user,user.getX(),user.getY(),user.getZ(),3f,true, World.ExplosionSourceType.TNT);
        user.getItemCooldownManager().set(stack.getItem(), 20);
        return true;
    }
}
