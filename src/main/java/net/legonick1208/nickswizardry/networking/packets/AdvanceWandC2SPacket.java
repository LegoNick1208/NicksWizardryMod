package net.legonick1208.nickswizardry.networking.packets;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

public class AdvanceWandC2SPacket {
    public static void receive(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler, PacketByteBuf but, PacketSender responseSender){
        // Everything here happens on server
        //Make sure it has nbt data, and is not an uninitilized master wand.
        // set its selected spell value to whatever it is +1, reset to 0 if its at 4 to loop.
        ItemStack stack = player.getMainHandStack();
        NbtCompound nbt = stack.getNbt();
        int selectedSpell = nbt.getInt("selectedSpell");
        if(selectedSpell == 4){
            nbt.putInt("selectedSpell", 0);
        } else {
            nbt.putInt("selectedSpell", selectedSpell + 1);
        }
    }
}
