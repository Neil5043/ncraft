package mods.nazu.ncraft.tech.machines.parts;

import java.util.Set;

import mods.nazu.ncraft.api.item.EnumMultiItem;
import mods.nazu.ncraft.api.tech.machines.MachineComponent;
import mods.nazu.ncraft.tech.machines.MachineFace;

/**
 * @author nazuraki
 * @since 2013.04.21
 */
public enum MachineParts implements MachineComponent, EnumMultiItem.Type
{
    Vent("vent", "Vent"),
    HeatingElement("heatingElement", "Heating Element"),
    Furnace("furnace", "Furnace"),
    Generator("generator", "Generator"),
    IndustrialGenerator("industrialGenerator", "Industrial Generator"),
    Turbine("turbine", "Turbine"),
    IndustrialTurbine("industrialTurbine", "Industrial Turbine"),
    LED("led", "LED"),
    Wiring("wiring", "Wiring"),
    Controller("controller", "Controller"),
    ;

    private final String name;
    private final String displayName;

    private MachineParts(String name, String displayName)
    {
        this.name = name;
        this.displayName = displayName;
    }

    @Override public int getId() { return ordinal(); }
    @Override public String getName() { return name; }
    @Override public String getDisplayName() { return displayName; }
    @Override public boolean acceptsConnection() { return false; }
    @Override public Set<MachineFace> requiresFace() { return null; }

    private static final MachineParts[] byId;
    static
    {
        byId = new MachineParts[values().length];
        for (MachineParts part : values())
        {
            byId[part.ordinal()] = part;
        }
    }

    public static MachineParts get(int id)
    {
        return byId[id];
    }
}
