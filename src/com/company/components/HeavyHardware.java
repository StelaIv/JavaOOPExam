package com.company.components;

import java.util.List;

public class HeavyHardware extends HardwareComponents {

    public HeavyHardware(
            String name,
            String type,
            int maxCapacity,
            int maxMemory,
            List<SoftwareComponents> softwareComponents) {
        super(name, type, maxCapacity, maxMemory, softwareComponents);
        this.setMaxCapacity(this.getMaxCapacity() * 2);
        this.setMaxMemory(this.getMaxMemory() - (this.getMaxMemory() / 4));
    }
}
