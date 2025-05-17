package org.enderdevelopment.architects_palette.blocks;

import net.minecraft.block.BlockStairs;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import org.enderdevelopment.architects_palette.APRegistry;
import org.enderdevelopment.architects_palette.Tags;

import java.util.Objects;

public class BlockStairBase extends BlockStairs {
    public BlockStairBase(String name, IBlockState modelState) {
        super(modelState);
        this.setLightOpacity(255);
        this.useNeighborBrightness = true;

        setTranslationKey(String.format("%s.%s", Tags.MOD_ID, name));
        setRegistryName(new ResourceLocation(Tags.MOD_ID, name));
        setCreativeTab(APRegistry.AP_CREATIVETAB);

        APRegistry.BLOCKS.add(this);
        APRegistry.ITEMS.add(new ItemBlock(this).setRegistryName(Objects.requireNonNull(getRegistryName())));
    }

    public BlockStairBase(String name, IBlockState modelState, float hardness, float resistance, SoundType soundType) {
        this(name, modelState);
        setHardness(hardness);
        setResistance(resistance);
        setSoundType(soundType);
    }
}
