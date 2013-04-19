package mods.nazu.ncraft.world;

import net.minecraft.item.Item;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author nazuraki
 * @since 2013.04.19
 */
public enum Items
{
    Placeholder("itemPlaceholder", 5200, ItemPlaceholder.class, "Placeholder")
    ;

    private final String unlocalizedName;
    private final int defaultId;
    private final Class<? extends Item> klass;
    private final String displayName;

    private Items(String unlocalizedName, int defaultId, Class<? extends Item> klass, String displayName)
    {
        this.unlocalizedName = unlocalizedName;
        this.defaultId = defaultId;
        this.klass = klass;
        this.displayName = displayName;
    }

    public String getUnlocalizedName() { return unlocalizedName; }
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
