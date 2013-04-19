package mods.nazu.ncraft.world;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockOre;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;

import java.util.Random;

public class PlaceholderOre extends BlockOre
{
	private Icon texture;

	public PlaceholderOre(int id)
	{
		super(id);
		
		setHardness(1.0f);
		setStepSound(soundStoneFootstep);
		setUnlocalizedName("placeholderOre");
		setCreativeTab(CreativeTabs.tabBlock);
		
	}

    @Override
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return 5000;
    }

    @Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister)
	{
		texture = iconRegister.registerIcon("ncraft:orePlaceholder");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getBlockTexture(IBlockAccess par1iBlockAccess, int x, int y, int z, int side)
	{
		return texture;
	}
}
