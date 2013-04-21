package mods.nazu.ncraft.tech;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

import java.util.List;

/**
 * @author nazuraki
 * @since 2013.04.21
 */
public class MachineTool extends Item
{
    private final Icon[] icons;

    public MachineTool(int id)
    {
        super(id);

        setCreativeTab(TabTech.INSTANCE);
        setMaxDamage(0);
        setHasSubtypes(true);
        setUnlocalizedName(Items.MachineTool.getName());

        icons = new Icon[MachineTools.values().length];
    }

    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        return getUnlocalizedName() + "." + MachineTools.get(stack.getItemDamage()).getName();
    }

    @Override
    public String getItemDisplayName(ItemStack stack)
    {
        return MachineTools.get(stack.getItemDamage()).getDisplayName();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister)
    {
        for (MachineTools tool : MachineTools.values())
        {
            icons[tool.ordinal()] = iconRegister.registerIcon("ncraft:" + Items.MachineTool.getName() + "." + tool.getName());
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
        for (MachineTools tool : MachineTools.values())
        {
            list.add(new ItemStack(id, 1, tool.ordinal()));
        }
    }
}
