package com.reph3x.totemstcg.block;

import com.reph3x.totemstcg.TotemsTCG;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final RegistryKey<Block> TOTEMS_TABLE_KEY = RegistryKey.of(
            RegistryKeys.BLOCK,
            Identifier.of(TotemsTCG.MOD_ID, "totems_table")
    );

    public static final Block TOTEMS_TABLE = register(
            new Block(AbstractBlock.Settings.create().registryKey(TOTEMS_TABLE_KEY).sounds(BlockSoundGroup.WOOD).hardness(1)),
            TOTEMS_TABLE_KEY,
            true
    );

    public static final RegistryKey<ItemGroup> TOTEMS_ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(TotemsTCG.MOD_ID, "totems_item_group"));
    public static final ItemGroup TOTEMS_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(TOTEMS_TABLE.asItem()))
            .displayName(Text.translatable("itemGroup.totemstcg"))
            .build();

    public static void initialize(){
    };

    public static Block register(Block block, RegistryKey<Block> blockKey, boolean shouldRegisterItem) {
        if(shouldRegisterItem) {
            RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, blockKey.getValue());
            BlockItem blockItem = new BlockItem(block, new Item.Settings().registryKey(itemKey));
            Registry.register(Registries.ITEM, itemKey, blockItem);
        }
        return Registry.register(Registries.BLOCK, blockKey, block);
    }
}
