package net.legonick1208.nickswizardry.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.legonick1208.nickswizardry.block.ModBlocks;
import net.legonick1208.nickswizardry.item.ModItems;

public class ModLootTableGenerator extends FabricBlockLootTableProvider {
    public ModLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
//        addDrop(block,oreDrops(silkDrop, unsilkedDrop));
    }
}
