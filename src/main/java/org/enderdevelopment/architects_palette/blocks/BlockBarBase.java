package org.enderdevelopment.architects_palette.blocks;

import net.minecraft.block.BlockPane;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import org.enderdevelopment.architects_palette.APRegistry;
import org.enderdevelopment.architects_palette.Tags;

import java.util.Objects;

public class BlockBarBase extends BlockPane {
    protected BlockBarBase(String name, Material materialIn) {
        super(materialIn, !materialIn.equals(Material.GLASS));

        setTranslationKey(String.format("%s.%s", Tags.MOD_ID, name));
        setRegistryName(new ResourceLocation(Tags.MOD_ID, name));
        setCreativeTab(APRegistry.AP_CREATIVETAB);

        APRegistry.BLOCKS.add(this);
        APRegistry.ITEMS.add(new ItemBlock(this).setRegistryName(Objects.requireNonNull(getRegistryName())));
    }

    public BlockBarBase(String name, Material material, double hardness, double resistance, SoundType soundType) {
        this(name, material);
        setHardness((float) hardness);
        setResistance((float) resistance);
        setSoundType(soundType);
    }

    public BlockBarBase(String name, BlockBase parentBlock) {
        this(name, parentBlock.getMaterial(), parentBlock.getHardness(), parentBlock.getResistance(), parentBlock.getSoundType());
    }
}
