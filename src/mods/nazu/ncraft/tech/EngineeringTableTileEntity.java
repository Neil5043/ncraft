package mods.nazu.ncraft.tech;

import mods.nazu.ncraft.api.tech.machines.MachineRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

/**
 * @author nazuraki
 * @since 2013.04.21
 */
public class EngineeringTableTileEntity extends TileEntity implements IInventory
{
    private ItemStack[] inv;

    public EngineeringTableTileEntity()
    {
        inv = new ItemStack[6 * 6];
    }

    @Override
    public int getSizeInventory()
    {
        return inv.length;
    }

    @Override
    public ItemStack getStackInSlot(int slot)
    {
        return inv[slot];
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack stack)
    {
        inv[slot] = stack;
        if (null != stack && stack.stackSize > getInventoryStackLimit())
        {
            stack.stackSize = getInventoryStackLimit();
        }
    }

    @Override
    public ItemStack decrStackSize(int slot, int amount)
    {
        ItemStack stack = getStackInSlot(slot);
        if (null != stack)
        {
            if (stack.stackSize <= amount)
            {
                setInventorySlotContents(slot, null);
            }
            else
            {
                stack = stack.splitStack(amount);
                if (0 == stack.stackSize)
                {
                    setInventorySlotContents(slot, null);
                }
            }
        }
        return stack;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int slot)
    {
        ItemStack stack = getStackInSlot(slot);
        if (null != stack)
        {
            setInventorySlotContents(slot, null);
        }
        return stack;
    }

    @Override
    public String getInvName()
    {
        return "ncraft.engineeringTable";
    }

    @Override
    public boolean isInvNameLocalized()
    {
        return false;
    }

    @Override
    public int getInventoryStackLimit()
    {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityplayer)
    {
        return this == worldObj.getBlockTileEntity(xCoord, yCoord, zCoord)
            && entityplayer.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64;
    }

    @Override
    public void openChest()
    {
    }

    @Override
    public void closeChest()
    {
    }

    @Override
    public boolean isStackValidForSlot(int i, ItemStack stack)
    {
        return MachineRegistry.contains(stack.itemID, stack.getItemDamage());
    }

    @Override
    public void readFromNBT(NBTTagCompound tagCompound)
    {
        super.readFromNBT(tagCompound);

        NBTTagList tagList = tagCompound.getTagList("Inventory");
        for (int i = 0; i < tagList.tagCount(); i++)
        {
            NBTTagCompound tag = (NBTTagCompound) tagList.tagAt(i);
            byte slot = tag.getByte("Slot");
            if (slot >= 0 && slot < inv.length)
            {
                inv[slot] = ItemStack.loadItemStackFromNBT(tag);
            }
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound tagCompound)
    {
        super.writeToNBT(tagCompound);

        NBTTagList itemList = new NBTTagList();
        for (int i = 0; i < inv.length; i++)
        {
            ItemStack stack = inv[i];
            if (null != stack)
            {
                NBTTagCompound tag = new NBTTagCompound();
                tag.setByte("Slot", (byte) i);
                stack.writeToNBT(tag);
                itemList.appendTag(tag);
            }
        }
        tagCompound.setTag("Inventory", itemList);
    }
}
