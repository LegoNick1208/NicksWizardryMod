package net.legonick1208.nickswizardry.networking;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.legonick1208.nickswizardry.NicksWizardryMod;
import net.legonick1208.nickswizardry.networking.packets.AdvanceWandC2SPacket;
import net.legonick1208.nickswizardry.networking.packets.DecreaseWandC2SPacket;
import net.minecraft.util.Identifier;

public class ModMessages {

    public static final Identifier advanceWand = new Identifier(NicksWizardryMod.MOD_ID, "advance");
    public static final Identifier decreaseWand = new Identifier(NicksWizardryMod.MOD_ID, "decrease");

    public static void registerC2SPackets() {
        ServerPlayNetworking.registerGlobalReceiver(advanceWand, AdvanceWandC2SPacket::receive);
        ServerPlayNetworking.registerGlobalReceiver(decreaseWand, DecreaseWandC2SPacket::receive);
    }

    public static  void registerS2CPackets(){

    }

}
