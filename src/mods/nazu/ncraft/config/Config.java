package mods.nazu.ncraft.config;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import mods.nazu.ncraft.world.Blocks;
import mods.nazu.ncraft.world.Items;
import mods.nazu.ncraft.world.Ores;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;

import java.io.File;
import java.util.EnumMap;
import java.util.Map;

/**
 * @author nazuraki
 * @since 2013.04.19
 */
public class Config
{
    public static final String WORLDGEN = "WORLDGEN";

    private static final Map<Items, Item> ITEMS = new EnumMap<Items, Item>(Items.class);
    private static final Map<Blocks, Block> BLOCKS = new EnumMap<Blocks, Block>(Blocks.class);
    private static final Map<Ores, Block> ORES = new EnumMap<Ores, Block>(Ores.class);
    private static final Map<Ores, OreConfig> ORES_CONFIGS = new EnumMap<Ores, OreConfig>(Ores.class);

    public Config(FMLPreInitializationEvent event)
    {
        Configuration cfg = new Configuration(new File(event.getModConfigurationDirectory(), "ncraft.cfg"));
        cfg.load();

        createItems(cfg);
        createBlocks(cfg);
        createOres(cfg);

        cfg.save();
    }

    public static Iterable<OreConfig> getOres()
    {
        return ORES_CONFIGS.values();
    }

    public static int getId(Items item)
    {
        Item i = ITEMS.get(item);
        return (null == i ? -1 : i.itemID);
    }

    public static int getId(Blocks block)
    {
        Block b = BLOCKS.get(block);
        return (null == b ? -1 : b.blockID);
    }

    public static int getId(Ores block)
    {
        Block b = ORES.get(block);
        return (null == b ? -1 : b.blockID);
    }

    public static void registerNames()
    {
        for (Map.Entry<Items, Item> entry : ITEMS.entrySet())
        {
            if (null != entry.getValue())
            {
                LanguageRegistry.addName(entry.getValue(), entry.getKey().getDisplayName());
            }
        }

        for (Map.Entry<Blocks, Block> entry : BLOCKS.entrySet())
        {
            if (null != entry.getValue())
            {
                LanguageRegistry.addName(entry.getValue(), entry.getKey().getDisplayName());
            }
        }

        for (Map.Entry<Ores, Block> entry : ORES.entrySet())
        {
            if (null != entry.getValue())
            {
                LanguageRegistry.addName(entry.getValue(), entry.getKey().getDisplayName());
            }
        }
    }

    public static void registerBlocks()
    {
        for (Map.Entry<Blocks, Block> entry : BLOCKS.entrySet())
        {
            if (null != entry.getValue())
            {
                if (null != entry.getKey().getHarvestTool())
                {
                    MinecraftForge.setBlockHarvestLevel(entry.getValue(), entry.getKey().getHarvestTool(), entry.getKey().getHarvestLevel());
                }
                GameRegistry.registerBlock(entry.getValue(), entry.getKey().getUnlocalizedName());
            }
        }

        for (Map.Entry<Ores, Block> entry : ORES.entrySet())
        {
            if (null != entry.getValue())
            {
                if (null != entry.getKey().getHarvestTool())
                {
                    MinecraftForge.setBlockHarvestLevel(entry.getValue(), entry.getKey().getHarvestTool(), entry.getKey().getHarvestLevel());
                }
                GameRegistry.registerBlock(entry.getValue(), entry.getKey().getUnlocalizedName());
                OreDictionary.registerOre(entry.getKey().getUnlocalizedName(), entry.getValue());
            }
        }
    }

    private static void createItems(Configuration cfg)
    {
        for (Items item : Items.values())
        {
            ITEMS.put(
                item,
                item.create(
                    cfg.getItem(Configuration.CATEGORY_ITEM, item.getUnlocalizedName(), item.getDefaultId()).getInt()
                )
            );
        }
    }

    private static void createBlocks(Configuration cfg)
    {
        for (Blocks block : Blocks.values())
        {
            BLOCKS.put(
                block,
                block.create(
                    cfg.getBlock(Configuration.CATEGORY_BLOCK, block.getUnlocalizedName(), block.getDefaultId()).getInt()
                )
            );
        }
    }

    private static void createOres(Configuration config)
    {
        for (Ores ore : Ores.values())
        {
            ORES.put(
                ore,
                ore.create(
                    config.getBlock(Configuration.CATEGORY_BLOCK, ore.getUnlocalizedName(), ore.getDefaultId()).getInt()
                )
            );
            if (config.get(WORLDGEN, "generate" + ore.getUnlocalizedName(), true).getBoolean(true))
            {
                ORES_CONFIGS.put(ore, ore.createConfig(config));
            }
        }
    }
}
