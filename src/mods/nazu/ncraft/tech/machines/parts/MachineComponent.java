package mods.nazu.ncraft.tech.machines.parts;

import java.util.Set;

import mods.nazu.ncraft.tech.machines.MachineFace;

/**
 * @author wasche
 * @copyright Wil Asche (wil@asche.us)
 * @license CC BY SA 3.0
 * @since 2013.04.22
 */
public interface MachineComponent
{
    /**
     * @return the unlocalized name of this component
     */
    public String getName();

    /**
     * @return the localized display name of this component
     */
    public String getDisplayName();

    /**
     * Returns whether or not this component accepts a connection. A component that accepts a connection must be placed
     * on a machine face.
     *
     * @return true if this component accepts a connection
     */
    public boolean acceptsConnection();

    /**
     * Returns the set of faces this machine can connect to. The Machine MUST be placed on of these faces. If it can be
     * placed on any, return {code}EnumSet.allOf(MachineFace.class){/code}. If it does not need to be placed on a face,
     * return null.
     *
     * @return set of faces
     */
    public Set<MachineFace> requiresFace();
}
