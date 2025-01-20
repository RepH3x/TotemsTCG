package com.reph3x.totemstcg;

import com.reph3x.totemstcg.block.ModBlocks;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TotemsTCG implements ModInitializer {
	public static final String MOD_ID = "totemstcg";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModBlocks.initialize();

		Registry.register(Registries.ITEM_GROUP, ModBlocks.TOTEMS_ITEM_GROUP_KEY, ModBlocks.TOTEMS_ITEM_GROUP);
		ItemGroupEvents.modifyEntriesEvent(ModBlocks.TOTEMS_ITEM_GROUP_KEY).register(itemGroup -> {
			itemGroup.add(ModBlocks.TOTEMS_TABLE);
		});
	}
}