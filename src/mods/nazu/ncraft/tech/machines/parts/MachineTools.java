package mods.nazu.ncraft.tech.machines.parts;

import java.util.Set;

import mods.nazu.ncraft.tech.machines.MachineFace;

/**
 * @author nazuraki
 * @since 2013.04.21
 */
public enum MachineTools implements MachineComponent
{
    Hammer("hammer", "Hammer"), // pulverize into dust
    Drill("drill", "Drill"), // extract chunks
    Saw("saw", "Saw"), // cut into planks
    Cast("cast", "Cast"), // cast into ingots
    Oven("oven", "Oven"), // create cobble/stone/obsidian/brick
    Boiler("boiler", "Boiler"), // produce steam
    IndustrialBoiler("industrialBoiler", "Industrial Boiler"),
    Sifter("sifter", "Sifter"),
    ;

    private final String name;
    private final String displayName;

    private MachineTools(String name, String displayName)
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

    private static final MachineTools[] byId;
    static
    {
        byId = new MachineTools[values().length];
        for (MachineTools type : values())
        {
            byId[type.ordinal()] = type;
        }
    }

    public static MachineTools get(int id)
    {
        return byId[id];
    }
}
