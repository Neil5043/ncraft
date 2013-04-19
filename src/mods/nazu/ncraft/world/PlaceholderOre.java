package mods.nazu.ncraft.world;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockOre;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;

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
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister)
	{
		texture = iconRegister.registerIcon("ncraft:placeholderOre");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getBlockTexture(IBlockAccess par1iBlockAccess, int par2,
			int par3, int par4, int par5)
	{
		return texture;
	}
}
