package mods.nazu.ncraft.tech;

/**
 * @author nazuraki
 * @since 2013.04.21
 */
public enum MachineParts
{
    PowerIntake("powerIntake", "Power Intake"),
    PowerOutlet("powerOutlet", "Power Outlet"),
    Capacitor("capacitor", "Capacitor"),
    FuelTank("fuelTank", "Fuel Tank"),
    FuelIntake("fuelIntake", "Fuel Intake"),
    FuelOutlet("fuelOutlet", "Fuel Outlet"),
    FuelValve("fuelValve", "Fuel Valve"),
    Vent("vent", "Vent"),
    ItemInput("itemInput", "Item Input"),
    ItemOutput("itemOutput", "Item Output"),
    Hatch("hatch", "Hatch"),
    HeatingElement("heatingElement", "Heating Element"),
    Furnace("furnace", "Furnace"),
    Generator("generator", "Generator"),
    IndustrialGenerator("industrialGenerator", "Industrial Generator"),
    Turbine("turbine", "Turbine"),
    IndustrialTurbine("industrialTurbine", "Industrial Turbine"),
    ;

    private static final MachineParts[] byId;
    static
    {
        byId = new MachineParts[values().length];
        for (MachineParts part : values())
        {
            byId[part.ordinal()] = part;
        }
    }

    private final String name;
    private final String displayName;

    private MachineParts(String name, String displayName)
    {
        this.name = name;
        this.displayName = displayName;
    }

    public String getName() { return name; }
    public String getDisplayName() { return displayName; }

    public static MachineParts get(int id)
    {
        return byId[id];
    }
}
