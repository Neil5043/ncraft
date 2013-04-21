package mods.nazu.ncraft.world;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockOre;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;

/**
 * @author nazuraki
 * @since 2013.04.19
 */
public class RedDiamondOre extends BlockOre
{
    public RedDiamondOre(int id)
    {
        super(id);

        setHardness(1.0f);
        setStepSound(soundStoneFootstep);
        setUnlocalizedName(Ores.RedDiamond.getUnlocalizedName());
        setCreativeTab(CreativeTabs.tabBlock);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister)
    {
        blockIcon = iconRegister.registerIcon("ncraft:oreRedDiamond");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Icon getBlockTexture(IBlockAccess par1iBlockAccess, int x, int y, int z, int side)
    {
        return blockIcon;
    }
}
