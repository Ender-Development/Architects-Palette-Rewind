package org.enderdevelopment.architects_palette.blocks;

import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import org.enderdevelopment.architects_palette.APRegistry;
import org.enderdevelopment.architects_palette.Tags;

import java.util.Objects;

public class BlockPillarBase extends BlockRotatedPillar {

    public BlockPillarBase(String name, Material material) {
        super(material);
        this.setDefaultState(this.blockState.getBaseState().withProperty(AXIS, EnumFacing.Axis.Y));

        setTranslationKey(String.format("%s.%s", Tags.MOD_ID, name));
        setRegistryName(new ResourceLocation(Tags.MOD_ID, name));
        setCreativeTab(APRegistry.AP_CREATIVETAB);

        APRegistry.BLOCKS.add(this);
        APRegistry.ITEMS.add(new ItemBlock(this).setRegistryName(Objects.requireNonNull(getRegistryName())));
    }

    public BlockPillarBase(String name, Material material, double hardness, double resistance, SoundType soundType) {
        this(name, material);
        setHardness((float) hardness);
        setResistance((float) resistance);
        setSoundType(soundType);
    }

    public BlockPillarBase(String name, BlockBase parentBlock) {
        this(name, parentBlock.getMaterial(), parentBlock.getHardness(), parentBlock.getResistance(), parentBlock.getSoundType());
    }
}
