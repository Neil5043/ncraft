package mods.nazu.ncraft.tech.machines.parts;

import java.util.Set;

import mods.nazu.ncraft.tech.machines.MachineFace;

/**
 * @author wasche
 * @copyright Wil Asche (wil@asche.us)
 * @license CC BY SA 3.0
 * @since 2013.04.22
 */
public enum MachineIOs implements MachineComponent
{
    PowerIntake("powerIntake", "Power Intake"),
    PowerOutlet("powerOutlet", "Power Outlet"),
    LiquidIntake("liquidIntake", "Liquid Intake"),
    LiquidOutlet("liquidOutlet", "Liquid Outlet"),
    Valve("valve", "Valve"),
    ItemInput("itemInput", "Item Input"),
    ItemOutput("itemOutput", "Item Output"),
    Hatch("hatch", "Hatch"),
    ;

    private final String name;
    private final String displayName;

    private MachineIOs(String name, String displayName)
    {
        this.name = name;
        this.displayName = displayName;
    }

    @Override public String getName() { return name; }
    @Override public String getDisplayName() { return displayName; }

    @Override
    public boolean acceptsConnection()
    {
        return false;
    }

    @Override
    public Set<MachineFace> requiresFace()
    {
        return null;
    }

    private static final MachineIOs[] byId;
    static
    {
        byId = new MachineIOs[values().length];
        for (MachineIOs io : values())
        {
            byId[io.ordinal()] = io;
        }
    }

    public static MachineIOs get(int id)
    {
        return byId[id];
    }
}