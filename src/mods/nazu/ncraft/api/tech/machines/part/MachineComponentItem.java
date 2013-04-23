package mods.nazu.ncraft.api.tech.machines.part;

import mods.nazu.ncraft.api.tech.machines.MachineComponent;

/**
 * @author wasche
 * @copyright Wil Asche (wil@asche.us)
 * @license CC BY 3.0
 * @since 2013.04.23
 */
public interface MachineComponentItem
{
    public MachineComponent getComponentForMeta(int meta);
}
