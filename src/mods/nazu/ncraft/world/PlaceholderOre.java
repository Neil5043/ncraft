package mods.nazu.ncraft.world;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.nazu.ncraft.Config;
import net.minecraft.block.BlockOre;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;

import java.util.Random;

/**
 * @author nazuraki
 * @since 2013.04.19
 */
public class PlaceholderOre extends BlockOre
{
	public PlaceholderOre(int id)
	{
		super(id);
		
		setHardness(1.0f);
		setStepSound(soundStoneFootstep);
		setUnlocalizedName(Blocks.Placeholder.getUnlocalizedName());
		setCreativeTab(CreativeTabs.tabBlock);
	}

    @Override
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return Config.getId(Items.Placeholder);
    }

    @Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister)
	{
		blockIcon = iconRegister.registerIcon("ncraft:orePlaceholder");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getBlockTexture(IBlockAccess par1iBlockAccess, int x, int y, int z, int side)
	{
		return blockIcon;
	}
}
