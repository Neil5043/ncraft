package mods.nazu.ncraft.world;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.Icon;

/**
 * @author nazuraki
 * @since 2013.04.19
 */
public class ItemPlaceholder extends Item
{
    private Icon texture;

    public ItemPlaceholder(int id)
    {
        super(id);

        maxStackSize = 64;
        setCreativeTab(CreativeTabs.tabMaterials);
        setUnlocalizedName("itemPlaceholder");
    }

    @Override
    public void registerIcons(IconRegister iconRegister)
    {
        texture = iconRegister.registerIcon("ncraft:itemPlaceholder");
    }

    @Override
    public Icon getIconFromDamage(int par1)
    {
        return texture;
    }
}
