package org.enderdevelopment.architects_palette.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockLightBase extends BlockBase {
    public BlockLightBase(String name, Material material, double hardness, double resistance, SoundType soundType, double lightLevel) {
        super(name, material, hardness, resistance, soundType);
        setLightLevel((float) lightLevel);
    }
}
