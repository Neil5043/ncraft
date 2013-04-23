package mods.nazu.ncraft.api.tech.machines.part;

import mods.nazu.ncraft.api.item.EnumMultiItem;
import mods.nazu.ncraft.api.tech.machines.MachineComponent;

/**
 * @author wasche
 * @copyright Wil Asche (wil@asche.us)
 * @license CC BY 3.0
 * @since 2013.04.23
 */
public class MachineComponentMultiItem extends EnumMultiItem implements MachineComponentItem
{
    public MachineComponentMultiItem(int id, Type[] types)
    {
        super(id, types);
    }

    @Override
    public MachineComponent getComponentForMeta(int meta)
    {
        return (MachineComponent) getTypes()[meta];
    }
}
