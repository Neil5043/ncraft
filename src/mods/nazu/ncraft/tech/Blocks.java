package mods.nazu.ncraft.tech;

import net.minecraft.block.Block;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author nazuraki
 * @since 2013.04.19
 */
public enum Blocks
{
    EngineeringTable("engineeringTable", 520, mods.nazu.ncraft.tech.EngineeringTable.class, "Engineering Table", "axe", 1)
    ;

    private final String unlocalizedName;
    private final int defaultId;
    private final Class<? extends Block> klass;
    private final String displayName;
    private final String harvestTool;
    private final int harvestLevel;

    private Blocks(String unlocalizedName, int defaultId, Class<? extends Block> klass, String displayName, String harvestTool, int harvestLevel)
    {
        this.unlocalizedName = unlocalizedName;
        this.defaultId = defaultId;
        this.klass = klass;
        this.displayName = displayName;
        this.harvestTool = harvestTool;
        this.harvestLevel = harvestLevel;
    }

    public String getUnlocalizedName() { return unlocalizedName; }
    public String getDisplayName() { return displayName; }
    public int getDefaultId() { return defaultId; }
    public String getHarvestTool() { return harvestTool; }
    public int getHarvestLevel() { return harvestLevel; }

    public Block create(int id)
    {
        try
        {
            Constructor ctor = klass.getConstructor(int.class);
            return (Block) ctor.newInstance(id);
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
