package org.enderdevelopment.architects_palette.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.enderdevelopment.architects_palette.ArchitectsPalette;

public class CommonProxy implements IProxy{
    @Override
    public void preInit(FMLPreInitializationEvent event) {
        ArchitectsPalette.LOGGER.debug("Entering PreInit!");
    }

    @Override
    public void init(FMLInitializationEvent event) {
        ArchitectsPalette.LOGGER.debug("Entering Init!");
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        ArchitectsPalette.LOGGER.debug("Entering PostInit!");
    }
}
