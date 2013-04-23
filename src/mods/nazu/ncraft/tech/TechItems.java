package mods.nazu.ncraft.tech;

import mods.nazu.ncraft.api.tech.machines.part.MachineComponentMultiItem;
import mods.nazu.ncraft.tech.machines.parts.MachineBuffers;
import mods.nazu.ncraft.tech.machines.parts.MachineEngines;
import mods.nazu.ncraft.tech.machines.parts.MachineIOs;
import mods.nazu.ncraft.tech.machines.parts.MachineParts;
import mods.nazu.ncraft.tech.machines.parts.MachineTools;
import net.minecraft.item.Item;

/**
 * @author nazuraki
 * @since 2013.04.19
 */
public enum TechItems
{
    MachinePart("machinePart", 540, "Machine Part")
            {
                @Override
                public Item create(int id)
                {
                    return new MachineComponentMultiItem(id, MachineParts.values())
                            .setCreativeTab(TabTech.INSTANCE)
                            .setUnlocalizedName(getName());
                }
            },
    MachineTool("machineTool", 541, "Machine Tool")
            {
                @Override
                public Item create(int id)
                {
                    return new MachineComponentMultiItem(id, MachineTools.values())
                            .setCreativeTab(TabTech.INSTANCE)
                            .setUnlocalizedName(getName());
                }
            },
    MachineEngine("machineEngine", 542, "Machine Engine")
            {
                @Override
                public Item create(int id)
                {
                    return new MachineComponentMultiItem(id, MachineEngines.values())
                            .setCreativeTab(TabTech.INSTANCE)
                            .setUnlocalizedName(getName());
                }
            },
    MachineBuffer("machineBuffers", 543, "Machine Buffer")
            {
                @Override
                public Item create(int id)
                {
                    return new MachineComponentMultiItem(id, MachineBuffers.values())
                            .setCreativeTab(TabTech.INSTANCE)
                            .setUnlocalizedName(getName());
                }
            },
    MachineIO("machineIO", 544, "Machine I/O")
            {
                @Override
                public Item create(int id)
                {
                    return new MachineComponentMultiItem(id, MachineIOs.values())
                            .setCreativeTab(TabTech.INSTANCE)
                            .setUnlocalizedName(getName());
                }
            },
    ;

    private final String name;
    private final int defaultId;
    private final String displayName;

    private TechItems(String name, int defaultId, String displayName)
    {
        this.name = name;
        this.defaultId = defaultId;
        this.displayName = displayName;
    }

    public String getName() { return name; }
    public String getDisplayName() { return displayName; }
    public int getDefaultId() { return defaultId; }

    public abstract Item create(int id);
}
