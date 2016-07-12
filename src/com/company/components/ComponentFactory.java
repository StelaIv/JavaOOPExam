package com.company.components;

import com.company.SystemCore;

import java.util.ArrayList;
import java.util.Iterator;

public class ComponentFactory {
    
    public ComponentFactory() {
    }

    public void registerPowerHardware(SystemCore system, String hardwareName, int hardwareCapacity, int hardwareMemory) {
        system.getHardwareComponents().add(
                new PowerHardware(hardwareName,
                        "Power",
                        hardwareCapacity,
                        hardwareMemory,
                        new ArrayList<SoftwareComponents>()));
    }

    public void registerHeavyHardware(SystemCore system, String hardwareName, int hardwareCapacity, int hardwareMemory) {
        system.getHardwareComponents().add(
                new HeavyHardware(hardwareName,
                        "Heavy",
                        hardwareCapacity,
                        hardwareMemory,
                        new ArrayList<SoftwareComponents>()));
    }

    public void registerExpressSoftware(SystemCore system, String hardwareComponentName, String name, int softwareCapacity, int softwareMemory) {
        system.getHardwareComponents().stream().forEach(h -> {
            if (((h.getMaxCapacity() - h.getUsedCapacity()) >= softwareCapacity) && ((h.getMaxMemory() - h.getUsedMemory()) >= softwareMemory)) {
                if (h.getName().equals(hardwareComponentName)) {
                    h.getSoftwareComponents().add(new ExpressSoftware(name, "Express", softwareCapacity, softwareMemory));
                    h.setUsedCapacity(h.getUsedCapacity() + softwareCapacity);
                    h.setUsedMemory(h.getUsedMemory() + softwareMemory);
                }
            }
        });
    }

    public void registerLightSoftware(SystemCore system, String hardwareComponentName, String name, int softwareCapacity, int softwareMemory) {
        system.getHardwareComponents().stream().forEach(h -> {
            if (((h.getMaxCapacity() - h.getUsedCapacity()) >= softwareCapacity) && ((h.getMaxMemory() - h.getUsedMemory()) >= softwareMemory)) {
                if (h.getName().equals(hardwareComponentName)) {
                    h.getSoftwareComponents().add(new LightSoftware(name, "Light", softwareCapacity, softwareMemory));
                    h.setUsedCapacity(h.getUsedCapacity() + softwareCapacity);
                    h.setUsedMemory(h.getUsedMemory() + softwareMemory);
                }
            }
        });
    }

    public void releaseSoftwareComponent(SystemCore system, String hardwareComponentName, String softwareComponentName) {

        system.getHardwareComponents().stream().forEach(h -> {
            if (h.getName().equals(hardwareComponentName)) {

                Iterator<SoftwareComponents> iterator = h.getSoftwareComponents().iterator();
                while (iterator.hasNext()) {
                    SoftwareComponents softwareComponent = iterator.next();
                    if (softwareComponent.getName().equals(softwareComponentName)) {
                        iterator.remove();
                        h.setUsedCapacity(h.getUsedCapacity() - softwareComponent.getCapacityConsumption());
                        h.setUsedMemory(h.getUsedMemory() - softwareComponent.getMemoryConsumption());
                        break;
                    }
                }
            }
        });
    }

    public String analyze(SystemCore system) {
        StringBuilder sb = new StringBuilder();
        int softwareCount = system.getHardwareComponents().stream().mapToInt(HardwareComponents::softwareSize).sum();
        int totalMemoryInUse = system.getHardwareComponents().stream().mapToInt(HardwareComponents::getUsedMemory).sum();
        int totalMemory = system.getHardwareComponents().stream().mapToInt(HardwareComponents::getMaxMemory).sum();
        int totalCapacityTaken = system.getHardwareComponents().stream().mapToInt(HardwareComponents::getUsedCapacity).sum();
        int totalCapacity = system.getHardwareComponents().stream().mapToInt(HardwareComponents::getMaxCapacity).sum();
        sb.append(String.format("System Analysis%n"));
        sb.append(String.format("Hardware Components: %s%n", system.getHardwareComponents().size()));
        sb.append(String.format("Software Components: %s%n", softwareCount));
        sb.append(String.format("Total Operational Memory: %s / %s%n", totalMemoryInUse, totalMemory));
        sb.append(String.format("Total Capacity Taken: %s / %s", totalCapacityTaken, totalCapacity));
        return sb.toString();
    }

    public String systemSplit(SystemCore system) {
        StringBuilder sb = new StringBuilder();
        for (HardwareComponents hardwareComponents : system.getHardwareComponents()) {
            if (hardwareComponents.getType().equals("Power"))
                sb.append(hardwareComponents.toString());
        }
        for (HardwareComponents hardwareComponents : system.getHardwareComponents()) {
            if (hardwareComponents.getType().equals("Heavy"))
                sb.append(hardwareComponents.toString());
        }
        return sb.toString();
    }
}
