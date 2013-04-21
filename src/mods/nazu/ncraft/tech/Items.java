package mods.nazu.ncraft.tech;

import net.minecraft.item.Item;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author nazuraki
 * @since 2013.04.19
 */
public enum Items
{
    // parts
    MachinePart("machinePart", 540, MachinePart.class, "Machine Part"),

    // machine types
    MachineTool("machineTool", 541, MachineTool.class, "Machine Tool"),

    // engine types
    MachineEngine("machineEngine", 541, MachineEngine.class, "Machine Engine"),
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
