package mods.nazu.ncraft.world;

import cpw.mods.fml.common.IWorldGenerator;
import mods.nazu.ncraft.config.Config;
import mods.nazu.ncraft.config.OreConfig;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

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
        if (!world.provider.isHellWorld)
        {
            for (OreConfig ore : Config.getOres())
            {
                ore.generate(chunkX, chunkZ, random, world);
            }
        }
    }
}
