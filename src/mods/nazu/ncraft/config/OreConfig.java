package mods.nazu.ncraft.config;

import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.common.Configuration;

import java.util.Random;

/**
 * @author nazuraki
 * @since 2013.04.21
 */
public class OreConfig
{
    private static final String HEIGHT = "Height";
    private static final String RANGE = "Range";
    private static final String DENSITY = "Density";
    private static final String VEIN_SIZE = "VeinSize";

    private final int height;
    private final int range;
    private final int density;
    private final WorldGenMinable generator;

    public OreConfig(String name, int blockId, Configuration config, int height, int range, int density, int size)
    {
        this.height = config.get(Config.WORLDGEN, name + HEIGHT, height).getInt();
        this.range = config.get(Config.WORLDGEN, name + RANGE, range).getInt();
        this.density = config.get(Config.WORLDGEN, name + DENSITY, density).getInt();
        size = config.get(Config.WORLDGEN, name + VEIN_SIZE, size).getInt();
        generator = new WorldGenMinable(blockId, size);
    }

    public void generate(int chunkX, int chunkZ, Random random, World world)
    {
        int x, y, z;
        for (int k = 0; k < density; k++)
        {
            x = chunkX + random.nextInt(16);
            z = chunkZ + random.nextInt(16);
            y = height + random.nextInt(range - height);
            generator.generate(world, random, x, y, z);
        }
    }
}
