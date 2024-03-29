package mods.nazu.ncraft.tech.machines.parts;

import java.util.Set;

import mods.nazu.ncraft.api.item.EnumMultiItem;
import mods.nazu.ncraft.api.tech.machines.MachineComponent;
import mods.nazu.ncraft.tech.machines.MachineFace;

/**
 * @author nazuraki
 * @license CC BY 3.0
 * @since 2013.04.22
 */
public enum MachineBuffers implements MachineComponent, EnumMultiItem.Type
{
    Capacitor("capacitor", "Capacitor"),
    LiquidTank("liquidTank", "Liquid Tank"),
    Hopper("hopper", "Hopper"),
    CompressionCylinder("compressionCylinder", "Compression Cylinder"),
    ;

    private final String name;
    private final String displayName;

    private MachineBuffers(String name, String displayName)
    {
        this.name = name;
        this.displayName = displayName;
    }

    @Override public int getId() { return ordinal(); }
    @Override public String getName() { return name; }
    @Override public String getDisplayName() { return displayName; }

    @Override
    public boolean acceptsConnection()
    {
        return true;
    }

    @Override
    public Set<MachineFace> requiresFace()
    {
        return null;
    }

    private static final MachineBuffers[] byId;
    static
    {
        byId = new MachineBuffers[values().length];
        for (MachineBuffers buffer : values())
        {
            byId[buffer.ordinal()] = buffer;
        }
    }

    public static MachineBuffers get(int id)
    {
        return byId[id];
    }
}
