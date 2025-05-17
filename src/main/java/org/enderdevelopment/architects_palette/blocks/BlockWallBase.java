package org.enderdevelopment.architects_palette.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockWall;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import org.enderdevelopment.architects_palette.APRegistry;
import org.enderdevelopment.architects_palette.Tags;

import javax.annotation.Nonnull;
import java.util.Objects;

public class BlockWallBase extends BlockWall {
    public BlockWallBase(String name, Block modelBlock) {
        super(modelBlock);
        setTranslationKey(String.format("%s.%s", Tags.MOD_ID, name));
        setRegistryName(new ResourceLocation(Tags.MOD_ID, name));
        setCreativeTab(APRegistry.AP_CREATIVETAB);

        APRegistry.BLOCKS.add(this);
        APRegistry.ITEMS.add(new ItemBlock(this).setRegistryName(Objects.requireNonNull(getRegistryName())));
    }

    @Override
	public void getSubBlocks(@Nonnull CreativeTabs tab, @Nonnull NonNullList<ItemStack> list){
		if (tab == this.getCreativeTab()){
			list.add(new ItemStack(this,1));
		}
	}
}
