package net.legonick1208.nickswizardry.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.legonick1208.nickswizardry.NicksWizardryMod;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static ItemGroup NicksWizardryGroup;

    public static void registerItemGroups(){
        NicksWizardryGroup = FabricItemGroup.builder(new Identifier(NicksWizardryMod.MOD_ID, "nicks-wizardry-group"))
                .displayName(Text.literal("Nick's Wizardry"))
                .icon(() -> new ItemStack(ModItems.Wand)).build();
    }
}
