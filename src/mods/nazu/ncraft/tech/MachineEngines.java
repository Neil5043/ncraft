package mods.nazu.ncraft.tech;

/**
 * @author nazuraki
 * @since 2013.04.21
 */
public enum MachineEngines
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

    private static final MachineEngines[] byId;
    static
    {
        byId = new MachineEngines[values().length];
        for (MachineEngines engine : values())
        {
            byId[engine.ordinal()] = engine;
        }
    }

    private final String name;
    private final String displayName;

    private MachineEngines(String name, String displayName)
    {
        this.name = name;
        this.displayName = displayName;
    }

    public String getName() { return name; }
    public String getDisplayName() { return displayName; }

    public static MachineEngines get(int id)
    {
        return byId[id];
    }
}
