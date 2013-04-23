package mods.nazu.ncraft.tech.machines.parts;

import mods.nazu.ncraft.api.item.EnumMultiItem;
import mods.nazu.ncraft.tech.TabTech;
import mods.nazu.ncraft.tech.TechItems;

/**
 * @author nazuraki
 * @since 2013.04.21
 */
public class MachinePart extends EnumMultiItem
{
    public MachinePart(int id)
    {
        super(id, TechItems.MachinePart.getName(), MachineParts.values());

        setCreativeTab(TabTech.INSTANCE);
    }
}
