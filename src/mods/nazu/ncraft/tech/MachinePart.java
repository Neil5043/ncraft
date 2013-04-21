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
public class MachinePart extends Item
{
    private final Icon[] icons;

    public MachinePart(int id)
    {
        super(id);

        setCreativeTab(TabTech.INSTANCE);
        setMaxDamage(0);
        setHasSubtypes(true);
        setUnlocalizedName(Items.MachinePart.getName());

        icons = new Icon[MachineParts.values().length];
    }

    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        return getUnlocalizedName() + "." + MachineParts.get(stack.getItemDamage()).getName();
    }

    @Override
    public String getItemDisplayName(ItemStack stack)
    {
        return MachineParts.get(stack.getItemDamage()).getDisplayName();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister)
    {
        for (MachineParts part : MachineParts.values())
        {
            icons[part.ordinal()] = iconRegister.registerIcon("ncraft:" + Items.MachinePart.getName() + "." + part.getName());
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
        for (MachineParts part : MachineParts.values())
        {
            list.add(new ItemStack(id, 1, part.ordinal()));
        }
    }
}
