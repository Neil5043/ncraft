package mods.nazu.ncraft.world;

import mods.nazu.ncraft.config.Config;
import mods.nazu.ncraft.config.OreConfig;
import net.minecraft.block.Block;
import net.minecraftforge.common.Configuration;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author nazuraki
 * @since 2013.04.19
 */
public enum Ores
{
    Placeholder("orePlaceholder", 501, PlaceholderOre.class, "Placeholder Ore", "pickaxe", 3, 20, 45, 10, 8),
    Green("oreGreen", 502, GreenOre.class, "Green Ore", "pickaxe", 3, 20, 45, 10, 6),
    RedDiamond("oreRedDiamond", 503, RedDiamondOre.class, "Red Diamond Ore", "pickaxe", 5, 5, 10, 1, 5),
    ;

    private final String unlocalizedName;
    private final int defaultId;
    private final Class<? extends Block> klass;
    private final String displayName;
    private final String harvestTool;
    private final int harvestLevel;
    private final int height;
    private final int range;
    private final int density;
    private final int veinSize;

    private Ores(String unlocalizedName, int defaultId, Class<? extends Block> klass, String displayName,
                 String harvestTool, int harvestLevel, int height, int range, int density, int veinSize)
    {
        this.unlocalizedName = unlocalizedName;
        this.defaultId = defaultId;
        this.klass = klass;
        this.displayName = displayName;
        this.harvestTool = harvestTool;
        this.harvestLevel = harvestLevel;
        this.height = height;
        this.range = range;
        this.density = density;
        this.veinSize = veinSize;
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

    public OreConfig createConfig(Configuration config)
    {
        return new OreConfig(unlocalizedName, Config.getId(this), config, height, range, density, veinSize);
    }
}
