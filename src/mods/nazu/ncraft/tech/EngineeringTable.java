package mods.nazu.ncraft.tech;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;

/**
 * @author nazuraki
 * @since 2013.04.21
 */
public class EngineeringTable extends Block
{
    public EngineeringTable(int id)
    {
        super(id, Material.wood);

        setHardness(1.0f);
        setStepSound(soundWoodFootstep);
        setUnlocalizedName(Blocks.EngineeringTable.getUnlocalizedName());
        setCreativeTab(TabTech.INSTANCE);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister)
    {
        blockIcon = iconRegister.registerIcon("ncraft:engineeringTable");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Icon getBlockTexture(IBlockAccess access, int x, int y, int z, int side)
    {
        return blockIcon;
    }
}
