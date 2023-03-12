package net.legonick1208.nickswizardry;

import net.fabricmc.api.ModInitializer;

import net.legonick1208.nickswizardry.block.FlammableBlockRegistries;
import net.legonick1208.nickswizardry.block.ModBlocks;
import net.legonick1208.nickswizardry.block.StrippableBlockRegistries;
import net.legonick1208.nickswizardry.item.ModItemGroups;
import net.legonick1208.nickswizardry.item.ModItems;
import net.legonick1208.nickswizardry.world.gen.ModWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NicksWizardryMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "nickswizardry";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModWorldGeneration.generateModWorldGen();

		StrippableBlockRegistries.registerStrippedBlocks();
		FlammableBlockRegistries.registerFlammableBlocks();
	}
}