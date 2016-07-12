package com.company.components;

public class ExpressSoftware extends SoftwareComponents {

    public ExpressSoftware(
            String name,
            String type,
            int capacityConsumption,
            int memoryConsumption) {
        super(name, type, capacityConsumption, memoryConsumption);
        this.setMemoryConsumption(this.getMemoryConsumption() * 2);
    }
}
