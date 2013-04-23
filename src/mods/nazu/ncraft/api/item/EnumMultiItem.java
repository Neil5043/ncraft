package mods.nazu.ncraft.api.item;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

/**
 * @author wasche
 * @copyright Wil Asche (wil@asche.us)
 * @license CC BY 3.0
 * @since 2013.04.23
 */
public class EnumMultiItem extends Item
{
    private final Icon[] icons;
    private final Type[] types;

    public EnumMultiItem(int id, Type[] types)
    {
        super(id);

        setMaxDamage(0);
        setHasSubtypes(true);

        this.types = types;
        icons = new Icon[types.length];
    }

    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        return getUnlocalizedName() + "." + types[stack.getItemDamage()].getName();
    }

    @Override
    public String getItemDisplayName(ItemStack stack)
    {
        return types[stack.getItemDamage()].getDisplayName();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister)
    {
        for (Type t : types)
        {
            icons[t.getId()] = iconRegister.registerIcon("ncraft:" + getUnlocalizedName() + "." + t.getName());
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
        for (Type t : types)
        {
            list.add(new ItemStack(id, 1, t.getId()));
        }
    }

    public Type[] getTypes()
    {
        return types;
    }

    public static interface Type
    {
        public int getId();
        public String getName();
        public String getDisplayName();
    }
}
