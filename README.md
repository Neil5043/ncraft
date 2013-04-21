ncraft
======

Nazuraki's Minecraft mod pack


core
----


api
---
- transport
  - power
    - IPowerTransmitter
      - getCapacity : int
    - IPowerProducer
    - IPowerConsumer
      - getMaxDraw : int
      - handlePowerPacket
    - PowerDistributor
      - distribute ( int amount ) : int remainder
    - EvenPowerDistributor
    - OrderedPowerDistributor
      - takes a sorter, DistanceSort (closest first), MaxDrawSort, SaturationSort (smallest capacity first)
  - liquid
  - item

world
-----
- geode (multiblock) ore? 1x1, 2^3, 3^3?

tech
----

Current design thoughts:

Have a workbench where you combine parts to make machines with whatever features you desire, based on what parts
are used, and the quality of those parts. So using a capacitor will give it an internal power buffer, adding a
power connector will allow it to send/receive power, etc. Parts will have multiple versions of varying quality,
so a gold power connector will be able to transfer more power faster than a copper one.

Also thinking of doing add-on blocks, that will grant machines additional capabilities by converting them into
multiblock machines. For example, a storage add-on block might increase the internal item storage of a machine.
Might have more specific versions as well, for instance, an input storage upgrade, or an output storage upgrade.

I like the color-coded gui idea of Thermal Expansion, but I think reconfiguring where the input/output slots are
would require putting the machine in the workbench and putting an input/output part in the correct locations.
