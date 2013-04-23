package mods.nazu.ncraft.tech.machines.parts;

import mods.nazu.ncraft.api.item.EnumMultiItem;
import mods.nazu.ncraft.tech.TabTech;
import mods.nazu.ncraft.tech.TechItems;

/**
 * @author nazuraki
 * @since 2013.04.21
 */
public class MachineEngine extends EnumMultiItem
{
    public MachineEngine(int id)
    {
        super(id, TechItems.MachineEngine.getName(), MachineEngines.values());

        setCreativeTab(TabTech.INSTANCE);
    }
}
