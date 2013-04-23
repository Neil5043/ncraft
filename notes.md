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

