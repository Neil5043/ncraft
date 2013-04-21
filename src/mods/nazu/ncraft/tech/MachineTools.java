package mods.nazu.ncraft.tech;

/**
 * @author nazuraki
 * @since 2013.04.21
 */
public enum MachineTools
{
    Hammer("hammer", "Hammer"), // pulverize into dust
    Drill("drill", "Drill"), // extract chunks
    Saw("saw", "Saw"), // cut into planks
    Cast("cast", "Cast"), // cast into ingots
    Centrifuge("centrifuge", "Centrifuge"), // separate dusts
    Oven("oven", "Oven"), // create cobble/stone/obsidian/brick
    Boiler("boiler", "Boiler"), // produce steam
    IndustrialBoiler("industrialBoiler", "Industrial Boiler"),
    ;

    private static final MachineTools[] byId;
    static
    {
        byId = new MachineTools[values().length];
        for (MachineTools type : values())
        {
            byId[type.ordinal()] = type;
        }
    }

    private final String name;
    private final String displayName;

    private MachineTools(String name, String displayName)
    {
        this.name = name;
        this.displayName = displayName;
    }

    public String getName() { return name; }
    public String getDisplayName() { return displayName; }

    public static MachineTools get(int id)
    {
        return byId[id];
    }
}
