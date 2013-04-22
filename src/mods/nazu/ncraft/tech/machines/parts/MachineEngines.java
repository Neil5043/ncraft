package mods.nazu.ncraft.tech.machines.parts;

import java.util.Set;

import mods.nazu.ncraft.tech.machines.MachineFace;

/**
 * @author nazuraki
 * @since 2013.04.21
 */
public enum MachineEngines implements MachineComponent
{
    Hydro("hydro", "Hydro Engine"),
    Solar("solar", "Solar Engine"),
    Thermal("thermal", "Thermal Engine"),
    Wind("wind", "Wind Engine"),
    SolidFueledEngine("solidFueledEngine", "Solid Fueled Engine"),
    LiquidFueledEngine("liquidFueledEngine", "Liquid Fueled Engine"),
    Steam("steam", "Steam Engine"),
    IndustrialSteamEngine("industrialSteam", "Industrial Steam Engine"),
    ;

    private final String name;
    private final String displayName;

    private MachineEngines(String name, String displayName)
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

    private static final MachineEngines[] byId;
    static
    {
        byId = new MachineEngines[values().length];
        for (MachineEngines engine : values())
        {
            byId[engine.ordinal()] = engine;
        }
    }

    public static MachineEngines get(int id)
    {
        return byId[id];
    }
}
