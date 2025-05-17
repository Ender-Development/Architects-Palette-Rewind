package org.enderdevelopment.architects_palette.items;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import org.enderdevelopment.architects_palette.APRegistry;
import org.enderdevelopment.architects_palette.Tags;

public class ItemBase extends Item {
    public ItemBase(String name){
		super();
		setTranslationKey(String.format("%s.%s", Tags.MOD_ID, name));
        setRegistryName(new ResourceLocation(Tags.MOD_ID, name));
        setCreativeTab(APRegistry.AP_CREATIVETAB);

        APRegistry.ITEMS.add(this);
	}
}
