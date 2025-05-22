package org.enderdevelopment.architects_palette;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.enderdevelopment.architects_palette.blocks.*;
import org.enderdevelopment.architects_palette.blocks.slab.BlockDoubleSlab;
import org.enderdevelopment.architects_palette.blocks.slab.BlockHalfSlab;
import org.enderdevelopment.architects_palette.blocks.slab.BlockVerticalSlab;
import org.enderdevelopment.architects_palette.items.ItemBase;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Mod.EventBusSubscriber(modid = Tags.MOD_ID)
public class APRegistry {
    public static final List<Block> BLOCKS = new ArrayList<>();
    public static final List<Item> ITEMS = new ArrayList<>();

    public static final CreativeTabs AP_CREATIVETAB = new CreativeTabs(Tags.MOD_ID) {
        @Nonnull
        @Override
        public ItemStack createIcon() {
            return new ItemStack(APRegistry.ALGAL_BLEND);
        }
    };

    // Algal
    public static final Item ALGAL_BLEND = new ItemBase("algal_blend");
    public static final Item ALGAL_BRICK = new ItemBase("algal_brick");
    public static final Block ALGAL_BRICKS = new BlockBase("algal_bricks", Material.ROCK, 2.0, 6.0, SoundType.STONE);
    public static final Block ALGAL_LAMP = new BlockLightBase("algal_lamp", Material.ROCK, 2.0, 6.0, SoundType.STONE, 1.0);
    public static final Block ALGAL_WALL = new BlockWallBase("algal_brick_wall", ALGAL_BRICKS);
    public static final Block ALGAL_VERTICAL_SLAB = new BlockVerticalSlab("algal_brick_vertical_slab", (BlockBase) ALGAL_BRICKS);
    public static final Block ALGAL_STAIRS = new BlockStairBase("algal_brick_stairs", ALGAL_BRICKS.getDefaultState());
    public static final BlockSlab ALGAL_BRICK_DOUBLE = new BlockDoubleSlab("algal_brick_double", (BlockBase) ALGAL_BRICKS, APRegistry.ALGAL_BRICK_SLAB);
    public static final BlockSlab ALGAL_BRICK_SLAB = new BlockHalfSlab("algal_brick_slab", (BlockBase) ALGAL_BRICKS, APRegistry.ALGAL_BRICK_SLAB, APRegistry.ALGAL_BRICK_DOUBLE);

    // Basalt
    public static final Block BASALT_TILES = new BlockBase("basalt_tiles", Material.ROCK, 1.25, 4.2, SoundType.STONE);
    public static final Block BASALT_TILE_STAIRS = new BlockStairBase("basalt_tile_stairs", BASALT_TILES.getDefaultState());
    public static final Block BASALT_TILE_WALL = new BlockWallBase("basalt_tile_wall", BASALT_TILES);
    public static final Block BASALT_TILE_VERTICAL_SLAB = new BlockVerticalSlab("basalt_tile_vertical_slab", (BlockBase) BASALT_TILES);
    public static final BlockSlab BASALT_TILE_DOUBLE = new BlockDoubleSlab("basalt_tile_double", (BlockBase) BASALT_TILES, APRegistry.BASALT_TILE_SLAB);
    public static final BlockSlab BASALT_TILE_SLAB = new BlockHalfSlab("basalt_tile_slab", (BlockBase) BASALT_TILES, APRegistry.BASALT_TILE_SLAB, APRegistry.BASALT_TILE_DOUBLE);

    // Entrails
    public static final Block ENTRAILS = new BlockBase("entrails", Material.ROCK, 1.25, 4.2, SoundType.STONE);
    public static final Block ENTRAILS_STAIRS = new BlockStairBase("entrails_stairs", ENTRAILS.getDefaultState());
    public static final Block ENTRAILS_VERTICAL_SLAB = new BlockVerticalSlab("entrails_vertical_slab", (BlockBase) ENTRAILS);
    public static final BlockSlab ENTRAILS_DOUBLE = new BlockDoubleSlab("entrails_double", (BlockBase) ENTRAILS, APRegistry.ENTRAILS_SLAB);
    public static final BlockSlab ENTRAILS_SLAB = new BlockHalfSlab("entrails_slab", (BlockBase) ENTRAILS, APRegistry.ENTRAILS_SLAB, APRegistry.ENTRAILS_DOUBLE);

    // Entwine
    public static final Item ENTWINE_ROD = new ItemBase("entwine_rod");
    public static final Block ENTWINE_BLOCK = new BlockBase("entwine_block", Material.ROCK, 3.0, 6.0, SoundType.STONE);
    public static final Block ENTWINE_PILLAR = new BlockPillarBase("entwine_pillar", (BlockBase) ENTWINE_BLOCK);
    public static final Block ENTWINE_STAIRS = new BlockStairBase("entwine_stairs", ENTWINE_BLOCK.getDefaultState());
    public static final Block ENTWINE_VERTICAL_SLAB = new BlockVerticalSlab("entwine_vertical_slab", (BlockBase) ENTWINE_BLOCK);
    public static final Block ENTWINE_BARS = new BlockBarBase("entwine_bars", (BlockBase) ENTWINE_BLOCK);
    public static final BlockSlab ENTWINE_DOUBLE = new BlockDoubleSlab("entwine_double", (BlockBase) ENTWINE_BLOCK, APRegistry.ENTWINE_SLAB);
    public static final BlockSlab ENTWINE_SLAB = new BlockHalfSlab("entwine_slab", (BlockBase) ENTWINE_BLOCK, APRegistry.ENTWINE_SLAB, APRegistry.ENTWINE_DOUBLE);

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        ArchitectsPalette.LOGGER.debug("Register Blocks!");
        event.getRegistry().registerAll(BLOCKS.toArray(new Block[0]));
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        ArchitectsPalette.LOGGER.debug("Register Items!");
        event.getRegistry().registerAll(ITEMS.toArray(new Item[0]));
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        ITEMS.forEach(item -> ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(Objects.requireNonNull(item.getRegistryName()), "inventory")));
    }
}
