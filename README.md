# ncraft

Nazuraki's Minecraft mod pack

![Screenshot](https://raw.github.com/kurakin/ncraft/master/Screenshot.png)

## core


## api
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

## world
- geode (multiblock) ore? 1x1, 2^3, 3^3?

## tech

### Machines

In order to build any of the machines, you'll first need to build an engineering table.

todo: screenshot

The basic engineering table gives you a 3x3 crafting grid:

todo: screenshot

Some of the slots in the crafting grid are colored. The blue one in the center is for the machine face. The green one
on the left is for the left side of the machine, the orange for the right. The pink corresponds to the top, the purple
for the bottom. Larger engineering tables will give additional slots, including some colored red for the back of the
machine being crafted.

Building machines just requires crafting whatever components you like, and combining them in the engineering table.
There are a number of components available. Some components use a connection, and thus must be on one of the faces.

#### Tools

These components perform some sort of processing. You can have mulitple of these in a machine, but you'll need a
controller component for them to interact.

##### Hammer

todo: screenshot

Pulverizes ores into dust. Smelting the resulting dusts will increase the ore yeild by 1.5x on average.

##### Drill

Extracts chunks from ores. Will also produce some dusts. Smelting the resulting chunks and dusts will increase the ore
yield by 2.0x on average.

##### Saw

Cuts wood logs into planks. Increases yield by 1.5x.

##### Cast

Smelts ore, chunks, and dust into ingots.

##### Sifter

Removes impurities from the dusts. Increases yield from hammer by an additional 0.25x, and the drill by an additional
0.2x.

##### Oven

Creates cobble, stone, obsidian, brick, and much more. Requires at least one liquid tank, but two are required for
cobble, stone, and obsidian.

##### Boiler

Produces steam. Requires a liquid tank and a compression cylinder.

