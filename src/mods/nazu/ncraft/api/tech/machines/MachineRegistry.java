package mods.nazu.ncraft.api.tech.machines;

import java.util.HashMap;
import java.util.Map;

/**
 * @author nazuraki
 * @license CC BY 3.0
 * @since 2013.04.23
 */
public class MachineRegistry
{
    private static Map<Integer, MachineComponent> components = new HashMap<Integer, MachineComponent>();

    private MachineRegistry() {}

    public static void registerComponent(int itemId, int meta, MachineComponent component)
    {
        components.put(getKey(itemId, meta), component);
    }

    public static boolean contains(int itemId, int meta)
    {
        return components.containsKey(getKey(itemId, meta));
    }

    private static int getKey(int itemId, int meta)
    {
        // meta is 0-15, which is only 4 bits
        return meta + itemId << 4;
    }
}
