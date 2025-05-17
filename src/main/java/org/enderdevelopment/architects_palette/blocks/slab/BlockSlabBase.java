package org.enderdevelopment.architects_palette.blocks.slab;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.enderdevelopment.architects_palette.APRegistry;
import org.enderdevelopment.architects_palette.Tags;

import javax.annotation.Nonnull;
import java.util.Random;

public abstract class BlockSlabBase extends BlockSlab {
    Block half;
    public static final PropertyEnum<Variant> VARIANT = PropertyEnum.create("variant", Variant.class);

    public BlockSlabBase(String name, Material materialIn, BlockSlab half) {
        super(materialIn);
        this.useNeighborBrightness = !this.isDouble();
        this.setLightOpacity(255);
        IBlockState state = this.blockState.getBaseState().withProperty(VARIANT, Variant.DEFAULT);
        if (!this.isDouble()) state = state.withProperty(HALF, EnumBlockHalf.BOTTOM);

        this.half = half;

        setTranslationKey(String.format("%s.%s", Tags.MOD_ID, name));
        setRegistryName(new ResourceLocation(Tags.MOD_ID, name));
        setCreativeTab(APRegistry.AP_CREATIVETAB);

        APRegistry.BLOCKS.add(this);
    }

    @Nonnull
    @Override
    public Item getItemDropped(IBlockState state, Random Rand, int fortune) {
        return Item.getItemFromBlock(half);
    }

    @Nonnull
    @Override
    public ItemStack getItem(World world, BlockPos pos, IBlockState state) {
        return new ItemStack(half);
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        IBlockState state = this.blockState.getBaseState().withProperty(VARIANT, Variant.DEFAULT);
        if (!this.isDouble()) state = state.withProperty(HALF, ((meta & 8) != 0) ? EnumBlockHalf.TOP : EnumBlockHalf.BOTTOM);
        return state;
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        int meta = 0;
        if (!this.isDouble() && state.getValue(HALF) == EnumBlockHalf.TOP) meta |= 8;
        return meta;
    }

    @Nonnull
    @Override
    protected BlockStateContainer createBlockState() {
        if (!this.isDouble()) return new BlockStateContainer(this, VARIANT, HALF);
        else return new BlockStateContainer(this, VARIANT);
    }

    @Nonnull
    @Override
    public String getTranslationKey(int meta) {
        return super.getTranslationKey();
    }

    @Nonnull
    @Override
    public IProperty<?> getVariantProperty() {
        return VARIANT;
    }

    @Nonnull
    @Override
    public Comparable<?> getTypeForItem(ItemStack itemStack) {
        return Variant.DEFAULT;
    }

    public enum Variant implements IStringSerializable {
        DEFAULT;

        @Nonnull
        @Override
        public String getName() {
            return "default";
        }
    }
}
