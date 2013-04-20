package mods.nazu.ncraft.world;

import cpw.mods.fml.common.IWorldGenerator;
import mods.nazu.ncraft.Config;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.Random;

/**
 * @author nazuraki
 * @since 2013.04.19
 */
public class WorldGenerator implements IWorldGenerator
{
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
    {
        if (world.provider.dimensionId != -1) // nether
        {
            for (int k = 0; k < 10; k++)
            {
                int x = chunkX + random.nextInt(16);
                int y = random.nextInt(64);
                int z = chunkZ + random.nextInt(16);

                (new WorldGenMinable(Config.getId(Blocks.Green), 13)).generate(world, random, x, y, z);
            }
        }
    }
}
