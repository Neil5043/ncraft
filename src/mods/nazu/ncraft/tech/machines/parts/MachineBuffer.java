package mods.nazu.ncraft.tech.machines.parts;

import mods.nazu.ncraft.api.item.EnumMultiItem;
import mods.nazu.ncraft.tech.TabTech;
import mods.nazu.ncraft.tech.TechItems;

/**
 * @author nazuraki
 * @since 2013.04.21
 */
public class MachineBuffer extends EnumMultiItem
{
    public MachineBuffer(int id)
    {
        super(id, MachineBuffers.values());

        setCreativeTab(TabTech.INSTANCE);
        setUnlocalizedName(TechItems.MachineBuffer.getName());
    }
}
