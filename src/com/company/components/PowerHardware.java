package com.company.components;

import java.util.List;

public class PowerHardware extends HardwareComponents {

    public PowerHardware(
            String name,
            String type,
            int maxCapacity,
            int maxMemory,
            List<SoftwareComponents> softwareComponents) {
        super(name, type, maxCapacity, maxMemory, softwareComponents);
        this.setMaxCapacity(this.getMaxCapacity() - ((this.getMaxCapacity() * 3) / 4));
        this.setMaxMemory(this.getMaxMemory() + ((this.getMaxMemory() * 3) / 4));
    }
}
