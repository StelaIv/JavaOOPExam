package com.company.components;

public class LightSoftware extends SoftwareComponents {

    public LightSoftware(
            String name,
            String type,
            int capacityConsumption,
            int memoryConsumption) {
        super(name, type, capacityConsumption, memoryConsumption);
        this.setMemoryConsumption(this.getMemoryConsumption() - ((this.getMemoryConsumption() * 2) / 4));
        this.setCapacityConsumption(this.getCapacityConsumption() + ((this.getCapacityConsumption() * 2) / 4));
    }
}
