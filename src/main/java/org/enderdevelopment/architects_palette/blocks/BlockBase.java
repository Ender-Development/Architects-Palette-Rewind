package org.enderdevelopment.architects_palette.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import org.enderdevelopment.architects_palette.APRegistry;
import org.enderdevelopment.architects_palette.Tags;

import java.util.Objects;

public class BlockBase extends Block {
    public BlockBase(String name, Material materialIn) {
        super(materialIn);

        setTranslationKey(String.format("%s.%s", Tags.MOD_ID, name));
        setRegistryName(new ResourceLocation(Tags.MOD_ID, name));
        setCreativeTab(APRegistry.AP_CREATIVETAB);

        APRegistry.BLOCKS.add(this);
        APRegistry.ITEMS.add(new ItemBlock(this).setRegistryName(Objects.requireNonNull(getRegistryName())));
    }

    public BlockBase(String name, Material material, double hardness, double resistance, SoundType soundType) {
        this(name, material);
        setHardness((float) hardness);
        setResistance((float) resistance);
        setSoundType(soundType);
    }

    public float getHardness() {
        return this.blockHardness;
    }

    public float getResistance() {
        return this.blockResistance;
    }

    public Material getMaterial() {
        return this.material;
    }
}
