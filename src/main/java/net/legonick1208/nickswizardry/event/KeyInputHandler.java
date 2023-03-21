package net.legonick1208.nickswizardry.event;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.legonick1208.nickswizardry.item.Wand;
import net.legonick1208.nickswizardry.networking.ModMessages;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import org.lwjgl.glfw.GLFW;

public class KeyInputHandler {

    public static final String NicksWizardryKeyCatagory = "key.catagory.nickswizardry.key_catagory";
    public static final String AdvanceWandKey = "key.nickswizardry.advance_wand";
    public static final String DecrementWandKey = "key.nickswizardry.decrement_wand";

    public static KeyBinding advanceWandKey;
    public static KeyBinding decrementWandKey;

    public static void registerKeyInputs(){
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
           if(advanceWandKey.wasPressed()) {
               ItemStack stack = client.player.getStackInHand(Hand.MAIN_HAND);
               if(stack.getItem().getClass().equals(Wand.class)){
                   NbtCompound nbt = stack.getNbt();
                   if(nbt != null){
                       // send the packet here
                       ClientPlayNetworking.send(ModMessages.advanceWand, PacketByteBufs.create());
                   }
               }
           } else if(decrementWandKey.wasPressed()){
               // Only decrements if we didnt increment, so it cant do both on the same tick.
               ItemStack stack = client.player.getStackInHand(Hand.MAIN_HAND);
               if(stack.getItem().getClass().equals(Wand.class)){
                   NbtCompound nbt = stack.getNbt();
                   if(nbt != null){
                       // send the packet here
                       ClientPlayNetworking.send(ModMessages.decreaseWand, PacketByteBufs.create());
                   }
               }
           }
        });
    }

    public static void register(){
        advanceWandKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                AdvanceWandKey,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_T,
                NicksWizardryKeyCatagory
        ));
        decrementWandKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                DecrementWandKey,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_Y,
                NicksWizardryKeyCatagory
        ));
        registerKeyInputs();
    }

}
