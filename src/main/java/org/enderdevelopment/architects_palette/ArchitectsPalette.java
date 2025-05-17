package org.enderdevelopment.architects_palette;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.enderdevelopment.architects_palette.proxy.IProxy;

@Mod(modid = Tags.MOD_ID, name = Tags.MOD_NAME, version = Tags.VERSION, dependencies = ArchitectsPalette.DEPENDENCIES)
public class ArchitectsPalette {
    public static final String DEPENDENCIES = "required-after:mixinbooter;";

    @Mod.Instance(value = Tags.MOD_ID)
    public static ArchitectsPalette instance;

    public static final Logger LOGGER = LogManager.getLogger(Tags.MOD_NAME);

    private static final String COMMON_PROXY = "org.enderdevelopment.architects_palette.proxy.CommonProxy";
    private static final String CLIENT_PROXY = "org.enderdevelopment.architects_palette.proxy.ClientProxy";

    @SidedProxy(modId = Tags.MOD_ID, clientSide = CLIENT_PROXY, serverSide = COMMON_PROXY)
    public static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}
