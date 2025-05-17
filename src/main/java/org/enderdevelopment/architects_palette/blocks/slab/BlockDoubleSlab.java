package org.enderdevelopment.architects_palette.blocks.slab;

import net.minecraft.block.BlockSlab;
import org.enderdevelopment.architects_palette.blocks.BlockBase;

public class BlockDoubleSlab extends BlockSlabBase {
    public BlockDoubleSlab(String name, BlockBase parentBlock, BlockSlab half) {
        super(name, parentBlock.getMaterial(), half);
        setResistance(parentBlock.getResistance());
        setSoundType(parentBlock.getSoundType());
        setHardness(parentBlock.getHardness());
    }

    @Override
    public boolean isDouble() {
        return true;
    }
}
