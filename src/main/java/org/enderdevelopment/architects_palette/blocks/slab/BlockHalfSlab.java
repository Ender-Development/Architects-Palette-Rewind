package org.enderdevelopment.architects_palette.blocks.slab;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.SoundType;
import net.minecraft.item.ItemSlab;
import org.enderdevelopment.architects_palette.APRegistry;
import org.enderdevelopment.architects_palette.blocks.BlockBase;

public class BlockHalfSlab extends BlockSlabBase {
    public BlockHalfSlab(String name, BlockBase parentBlock, BlockSlab half, BlockSlab doubleSlab) {
        super(name, parentBlock.getMaterial(), half);
        setHardness(parentBlock.getHardness());
        setResistance(parentBlock.getResistance());
        setSoundType(parentBlock.getSoundType());

        APRegistry.ITEMS.add(new ItemSlab(this, this, doubleSlab).setRegistryName(name));
    }

    @Override
    public boolean isDouble() {
        return false;
    }
}
