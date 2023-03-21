package net.legonick1208.nickswizardry.item;

import net.minecraft.entity.TntEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
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
        initWand(stack,world,player);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        NbtCompound nbt = stack.getNbt();
        if(nbt == null){
            // was not initilized, means its a master wand. Want to init it, but with master wand qualities so we dont have to again.
            initWand(stack);
            nbt = stack.getNbt();
            castSpell(stack,world,user,nbt);
        } else if(!world.isClient & hand.equals(Hand.MAIN_HAND) & (nbt.getString("creator").equals(user.getDisplayName().getString()) | nbt.getBoolean("isMaster"))) {
            // casts a spell when:
            // server side
            // main hand
            // Same user that created the wand or master wand.
            castSpell(stack,world,user,nbt);
        }
        return super.use(world, user, hand);
    }

    private void castSpell(ItemStack stack, World world, PlayerEntity user,NbtCompound nbt){
        // Casts the currently bound spell, does nothing if there is none
        // each wand has an int from 0-4 of the selected spell, and that corrolates to the index of an int arr
        // which contains the ids of each spell bound to the wand, 0 being no spell.
        switch(nbt.getIntArray("spells")[nbt.getInt("selectedSpell")]){
            case 0:
                user.sendMessage(Text.of("No spell bound to this slot!"));
                break;
            case 1:
                SpellLibrary.castSimpleExplosion(stack,world,user,nbt);
                break;
        }

    }

    private void initWand(ItemStack stack, World world, PlayerEntity user){
        NbtCompound nbt = stack.getOrCreateNbt();
        stack.setCustomName(Text.of(user.getDisplayName().getString() + "'s Wand"));
        nbt.putString("creator",user.getDisplayName().getString());
        nbt.putBoolean("isMaster",false);
        nbt.putIntArray("spells",new int[] {0,0,0,0,0});
        nbt.putInt("selectedSpell",0);
    }

    private void initWand(ItemStack stack){
        // initing as a master wand, anyone can use
        NbtCompound nbt = stack.getOrCreateNbt();
        stack.setCustomName(Text.of("Master Wand"));
        nbt.putString("creator","God");
        nbt.putBoolean("isMaster",true);
        nbt.putIntArray("spells",new int[] {0,1,0,0,0});
        nbt.putInt("selectedSpell",0);
    }
    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }
}
