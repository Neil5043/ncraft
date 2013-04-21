package mods.nazu.ncraft.world;

import net.minecraft.creativetab.CreativeTabs;

/**
 * @author nazuraki
 * @since 2013.04.21
 */
public class TabWorld extends CreativeTabs
{
    public static final TabWorld INSTANCE = new TabWorld();

    private TabWorld()
    {
        super("nCraft");
    }
}
