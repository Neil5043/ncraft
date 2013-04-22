package mods.nazu.ncraft.tech.machines.parts;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.nazu.ncraft.tech.Items;
import mods.nazu.ncraft.tech.TabTech;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

/**
 * @author nazuraki
 * @since 2013.04.21
 */
public class MachineBuffer extends Item
{
    private final Icon[] icons;

    public MachineBuffer(int id)
    {
        super(id);

        setCreativeTab(TabTech.INSTANCE);
        setMaxDamage(0);
        setHasSubtypes(true);
        setUnlocalizedName(Items.MachineBuffer.getName());

        icons = new Icon[MachineBuffers.values().length];
    }

    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        return getUnlocalizedName() + "." + MachineBuffers.get(stack.getItemDamage()).getName();
    }

    @Override
    public String getItemDisplayName(ItemStack stack)
    {
        return MachineBuffers.get(stack.getItemDamage()).getDisplayName();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister)
    {
        for (MachineBuffers buffer : MachineBuffers.values())
        {
            icons[buffer.ordinal()] = iconRegister.registerIcon("ncraft:" + Items.MachineBuffer.getName() + "." + buffer.getName());
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Icon getIconFromDamage(int meta)
    {
        return icons[meta];
    }

    @SuppressWarnings("unchecked")
    @Override
    public void getSubItems(int id, CreativeTabs tab, List list)
    {
        for (MachineBuffers buffer : MachineBuffers.values())
        {
            list.add(new ItemStack(id, 1, buffer.ordinal()));
        }
    }
}
