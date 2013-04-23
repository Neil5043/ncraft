package mods.nazu.ncraft.tech.machines.parts;

import mods.nazu.ncraft.api.item.EnumMultiItem;
import mods.nazu.ncraft.tech.TabTech;
import mods.nazu.ncraft.tech.TechItems;

/**
 * @author nazuraki
 * @since 2013.04.21
 */
public class MachineTool extends EnumMultiItem
{
    public MachineTool(int id)
    {
        super(id, TechItems.MachineTool.getName(), MachineTools.values());

        setCreativeTab(TabTech.INSTANCE);
    }
}
