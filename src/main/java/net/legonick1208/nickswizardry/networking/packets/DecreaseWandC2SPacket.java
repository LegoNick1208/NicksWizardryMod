package net.legonick1208.nickswizardry.networking.packets;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;

public class DecreaseWandC2SPacket {
    public static void receive(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler, PacketByteBuf but, PacketSender responseSender){
        // Everything here happens on server
        ItemStack stack = player.getMainHandStack();
        NbtCompound nbt = stack.getNbt();
        int selectedSpell = nbt.getInt("selectedSpell");
        if(selectedSpell == 0){
            nbt.putInt("selectedSpell", 4);
        } else {
            nbt.putInt("selectedSpell", selectedSpell - 1);
        }
    }
}
