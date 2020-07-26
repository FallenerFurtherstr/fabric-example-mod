package com.fallener.tutorial;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ExampleMod implements ModInitializer {
	public static final String MODID = "tutorial";
	public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
		new Identifier("tutorial", "general"), 
		()->new ItemStack(Blocks.COBBLESTONE));
	public static final ItemGroup OTHER_GROUP = FabricItemGroupBuilder.create(
		new Identifier("tutorial", "other"))
		.icon(()->new ItemStack(Items.BOWL))
		.build();
	public static final Item FABRIC_ITEM = new FabricItem(
		new Item.Settings()
		.group(ExampleMod.ITEM_GROUP)
		.maxCount(64));
	public static final FabricBlock FABRICA_BLOCK = new FabricBlock(FabricBlockSettings.of(Material.METAL).hardness(4.0f));
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		//System.out.println("Hello Fabric world!");
		Registry.register(Registry.ITEM, new Identifier(MODID,"fabric_item"),FABRIC_ITEM);
		Registry.register(Registry.BLOCK, new Identifier(MODID, "fabric_block"), FABRICA_BLOCK);
		Registry.register(Registry.ITEM, new Identifier(MODID, "fabric_block"), new BlockItem(FABRICA_BLOCK, new Item.Settings().group(ExampleMod.OTHER_GROUP)));
	}
}
