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

In order to build any of the machines, you'll first need to build an Engineering Table.

todo: screenshot

The basic engineering table gives you a 3x3 crafting grid:

todo: screenshot

Some of the slots in the crafting grid are colored. The blue one in the center is for the machine face. The green one
on the left is for the left side of the machine, the orange for the right. The pink corresponds to the top, the purple
for the bottom. Larger engineering tables will give additional slots, including some colored red for the back of the
machine being crafted.

Building an Engineering Workbench and placing it next to the Engineering Table will cause it to form a multiblock
and give you a large crafting area, allowing more advanced machines. Each additional workbench will increase the size,
up to 3 workbenches, giving a 6x6 crafting area.

Building machines just requires crafting whatever components you like, and combining them in the engineering table.
There are a number of components available. Some components use a connection, and thus must be on one of the faces.

Listed below are all of the tool and engine components, but to support those there are many other components.

Some require internal storage:

- **Capacitor** - stores energy
- **Liquid Tank** - stores, ahem, liquids
- **Hopper** - stores items
- **Compression Cylinder** - stores gases like steam

You may also want to fill/empty that internal storage:

- **Power Intake/Outlet** - used to add/remove stored energy
- **Liquid Intake/Outlet** - used to add/remove liquids
- **Valve** - combination liquid intake/outlet
- **Item Input/Output** - used to add/remove items
- **Hatch** - combination item input/output

In addition, there are components which when placed adjacent to a component they modify, will increase its
efficiency:

- **Vent** - works with hammer, drill and saw
- **Heating Element** - works with oven, cast, and boiler
- **Furnace** -
![Furnace](https://raw.github.com/kurakin/ncraft/master/res/mods/ncraft/textures/items/machinePart.furnace.png)
works with oven and cast
- **Generator/Industrial Generator** - works with solid/liquid fueled and solar engines.
- **Turbine/Industrial Turbine** - works with hydro, thermal, wind, and steam engines.

#### Tools

These components perform some sort of processing. You can have mulitple of these in a machine, but you'll need a
controller component for them to interact.

- **Hammer** -
![Hammer](https://raw.github.com/kurakin/ncraft/master/res/mods/ncraft/textures/items/machineTool.hammer.png)
Pulverizes ores into dust. Smelting the resulting dusts will increase the ore yeild by 1.5x on average.
- **Drill** -
![Drill](https://raw.github.com/kurakin/ncraft/master/res/mods/ncraft/textures/items/machineTool.drill.png)
Extracts chunks from ores. Will also produce some dusts. Smelting the resulting chunks and dusts will increase the ore
yield by 2.0x on average.
- **Saw** -
![Saw](https://raw.github.com/kurakin/ncraft/master/res/mods/ncraft/textures/items/machineTool.saw.png)
Cuts wood logs into planks. Increases yield by 1.5x.
- **Cast** -
![Cast](https://raw.github.com/kurakin/ncraft/master/res/mods/ncraft/textures/items/machineTool.cast.png)
Smelts ore, chunks, and dust into ingots.
- **Sifter** -
![Sifter](https://raw.github.com/kurakin/ncraft/master/res/mods/ncraft/textures/items/machineTool.sifter.png)
Removes impurities from the dusts. Increases yield from hammer by an additional 0.25x, and the drill by an additional
0.2x.
- **Oven** -
Creates cobble, stone, obsidian, brick, and much more. Requires at least one liquid tank, but two are required for
cobble, stone, and obsidian.
- **Boiler** -
![Hammer](https://raw.github.com/kurakin/ncraft/master/res/mods/ncraft/textures/items/machineTool.boiler.png)
Produces steam. Requires a liquid tank and a compression cylinder.

#### Engines

These components produce energy. Multiple of the same component will increase efficiency, but multiple different
engines will reduce efficiency.

- **Hydro** -
Uses current in adjacent blocks to produce power. Only the block adjacent to the face this component is on is used
though.
- **Solar** -
![Solar](https://raw.github.com/kurakin/ncraft/master/res/mods/ncraft/textures/items/machineEngine.solar.png)
Collects sunlight to produce power. Does not work on the bottom face. The top is best, but the sides will operate at
half efficiency.
- **Thermal** -
![Thermal](https://raw.github.com/kurakin/ncraft/master/res/mods/ncraft/textures/items/machineEngine.thermal.png)
Uses heat produced by adjacent lava blocks to generate power. Must be facing the lava block to work. Also requires a
liquid tank with water.
- **Wind** -
Harnesses the power of the wind. Only works on the front/back/left/right faces. Up to two of these can be combined in
a machine, but must be on opposite faces. Only effective if the block is placed so these face east/west. (Clouds move
towards west.)
- **Solid/Liquid Fueled** -
Burn solid or liquid fuels to generate power. Require a liquid tank or a hopper.
- **Steam** -
![Steam](https://raw.github.com/kurakin/ncraft/master/res/mods/ncraft/textures/items/machineEngine.steam.png)
Uses steam to produce energy. Requires a compression cylinder. There is also an industrial version, which is more
efficient.

#### Additional Components

- **LED** - adds an LED light to the face of the machine. If adjacent to a power input, it will indicate when the
machine as power, if adjacent to a tool, it will indicate when the machine is working, if adjacent to an engine it
will indicate when power is being produced. Supports dual and tri color LEDs. Tri color LEDs use the second color
to indicate 'ready' state, when it has resources but output is blocked.
- **Wiring** - used to connect a power input/output to a component that requires power.
- **Controller** - used to move items from one tool to another.

