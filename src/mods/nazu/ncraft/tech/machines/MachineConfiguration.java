package mods.nazu.ncraft.tech.machines;

/**
 * Represents the part layout of a machine, and provides mechanisms to validate the layout.
 *
 * Any intake/outlet placed around the edges (excluding the corners) connects to that face of the machine. Of the eight
 * middle slots, the left four connect to the front, the right four connect to the back. Not all components connect, but
 * you can't have more than one that does on the same face. The layout looks something like:
 *
 *                                     X T T T T X
 *                       X T T T X     L X X X X R
 *           X T T X     L F X K R     L F F K K R
 * X T X     L F K R     L F X K R     L F F K K R
 * L F R     L F K R     L F X K R     L X X X X R
 * X B X     X B B X     X B B B X     X B B B B X
 *
 * Any connections must also be adjacent to any corresponding components. For instance, if you have a capacitor and a
 * power outlet, they need to be adjacent. The same goes if you also had a power inlet. The capacitor would need to be
 * adjacent to both. Alternatively, you can use wiring or pipes to connect components.
 *
 * @author nazuraki
 * @license CC BY 3.0
 * @since 2013.04.22
 */
public class MachineConfiguration
{
    
}
