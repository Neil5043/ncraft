package mods.nazu.ncraft.tech;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * @author nazuraki
 * @since 2013.04.21
 */
public class GuiHandler implements IGuiHandler
{
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
        if (tileEntity instanceof EngineeringTableTileEntity)
        {
            return new EngineeringTableContainer(player.inventory, (EngineeringTableTileEntity) tileEntity);
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
        if (tileEntity instanceof EngineeringTableTileEntity)
        {
            return new EngineeringTableGui(player.inventory, (EngineeringTableTileEntity) tileEntity);
        }
        return null;
    }
}
