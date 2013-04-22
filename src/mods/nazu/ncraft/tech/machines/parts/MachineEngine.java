package mods.nazu.ncraft.tech.machines.parts;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.nazu.ncraft.tech.Items;
import mods.nazu.ncraft.tech.TabTech;
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
public class MachineEngine extends Item
{
    private final Icon[] icons;

    public MachineEngine(int id)
    {
        super(id);

        setCreativeTab(TabTech.INSTANCE);
        setMaxDamage(0);
        setHasSubtypes(true);
        setUnlocalizedName(Items.MachineEngine.getName());

        icons = new Icon[MachineEngines.values().length];
    }

    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        return getUnlocalizedName() + "." + MachineEngines.get(stack.getItemDamage()).getName();
    }

    @Override
    public String getItemDisplayName(ItemStack stack)
    {
        return MachineEngines.get(stack.getItemDamage()).getDisplayName();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister)
    {
        for (MachineEngines engine : MachineEngines.values())
        {
            icons[engine.ordinal()] = iconRegister.registerIcon("ncraft:" + Items.MachineEngine.getName() + "." + engine.getName());
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
        for (MachineEngines engine : MachineEngines.values())
        {
            list.add(new ItemStack(id, 1, engine.ordinal()));
        }
    }
}
