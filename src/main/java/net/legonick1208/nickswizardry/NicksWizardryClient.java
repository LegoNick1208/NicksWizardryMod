package net.legonick1208.nickswizardry;

import net.fabricmc.api.ClientModInitializer;
import net.legonick1208.nickswizardry.event.KeyInputHandler;
import net.legonick1208.nickswizardry.networking.ModMessages;

public class NicksWizardryClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
//      BlockRenderLayerMap.INSTANCE.putBlock(blockWithTransparentParts, RenderLayer.getCutout());
        KeyInputHandler.register();
        ModMessages.registerS2CPackets();
    }
}
