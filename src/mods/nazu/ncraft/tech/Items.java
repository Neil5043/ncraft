package mods.nazu.ncraft.tech;

import net.minecraft.item.Item;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import mods.nazu.ncraft.tech.machines.parts.MachineBuffer;
import mods.nazu.ncraft.tech.machines.parts.MachineIO;

/**
 * @author nazuraki
 * @since 2013.04.19
 */
public enum Items
{
    MachinePart("machinePart", 540, mods.nazu.ncraft.tech.machines.parts.MachinePart.class, "Machine Part"),
    MachineTool("machineTool", 541, mods.nazu.ncraft.tech.machines.parts.MachineTool.class, "Machine Tool"),
    MachineEngine("machineEngine", 542, mods.nazu.ncraft.tech.machines.parts.MachineEngine.class, "Machine Engine"),
    MachineBuffer("machineBuffers", 543, MachineBuffer.class, "Machine Buffer"),
    MachineIO("machineIO", 544, MachineIO.class, "Machine I/O"),
    ;

    private final String name;
    private final int defaultId;
    private final Class<? extends Item> klass;
    private final String displayName;

    private Items(String name, int defaultId, Class<? extends Item> klass, String displayName)
    {
        this.name = name;
        this.defaultId = defaultId;
        this.klass = klass;
        this.displayName = displayName;
    }

    public String getName() { return name; }
    public String getDisplayName() { return displayName; }
    public int getDefaultId() { return defaultId; }

    public Item create(int id)
    {
        try
        {
            Constructor ctor = klass.getConstructor(int.class);
            return (Item) ctor.newInstance(id);
        }
        catch (NoSuchMethodException e)
        {
            e.printStackTrace();
        }
        catch (InvocationTargetException e)
        {
            e.printStackTrace();
        }
        catch (InstantiationException e)
        {
            e.printStackTrace();
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
