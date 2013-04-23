package mods.nazu.ncraft.tech.machines.parts;

import java.util.EnumSet;
import java.util.Set;

import mods.nazu.ncraft.api.item.EnumMultiItem;
import mods.nazu.ncraft.api.tech.machines.MachineComponent;
import mods.nazu.ncraft.tech.machines.MachineFace;

import static mods.nazu.ncraft.tech.machines.MachineFace.*;

/**
 * @author nazuraki
 * @since 2013.04.21
 */
public enum MachineEngines implements MachineComponent, EnumMultiItem.Type
{
    Hydro                   ("hydro",               "Hydro Engine",             true, EnumSet.allOf(MachineFace.class)),
    Solar                   ("solar",               "Solar Engine",             true, EnumSet.of(Top, Left, Right, Front, Back)),
    Thermal                 ("thermal",             "Thermal Engine",           true, EnumSet.allOf(MachineFace.class)),
    Wind                    ("wind",                "Wind Engine",              true, EnumSet.of(Front, Back, Left, Right)),
    SolidFueledEngine       ("solidFueledEngine",   "Solid Fueled Engine",      true, null),
    LiquidFueledEngine      ("liquidFueledEngine",  "Liquid Fueled Engine",     true, null),
    Steam                   ("steam",               "Steam Engine",             true, null),
    IndustrialSteamEngine   ("industrialSteam",     "Industrial Steam Engine",  true, null),
    ;

    private final String name;
    private final String displayName;
    private final boolean acceptsConnection;
    private final Set<MachineFace> requiredFaces;

    private MachineEngines(String name, String displayName, boolean acceptsConnection, Set<MachineFace> requiredFaces)
    {
        this.name = name;
        this.displayName = displayName;
        this.acceptsConnection = acceptsConnection;
        this.requiredFaces = requiredFaces;
    }

    @Override public int getId() { return ordinal(); }
    @Override public String getName() { return name; }
    @Override public String getDisplayName() { return displayName; }
    @Override public boolean acceptsConnection() { return acceptsConnection; }
    @Override public Set<MachineFace> requiresFace() { return requiredFaces; }

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
