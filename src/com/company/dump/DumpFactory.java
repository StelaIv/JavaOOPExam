package com.company.dump;

import com.company.SystemCore;
import com.company.components.HardwareComponents;
import com.company.components.SoftwareComponents;

import java.util.Iterator;

public class DumpFactory {

    public DumpFactory() {
    }

    public void dump(SystemCore system, Dump dump, String hardwareComponentName) {

        Iterator<HardwareComponents> iterator = system.getHardwareComponents().iterator();
        while (iterator.hasNext()) {
            HardwareComponents comp = iterator.next();
            if (comp.getName().equals(hardwareComponentName)) {
                dump.getHardwareComponents().add(comp);
                iterator.remove();
            }
        }
    }

    public void restore(SystemCore system, Dump dump, String hardwareComponentName) {
        Iterator<HardwareComponents> iterators = dump.getHardwareComponents().iterator();
        while (iterators.hasNext()) {
            HardwareComponents comp = iterators.next();
            if (comp.getName().equals(hardwareComponentName)) {
                system.getHardwareComponents().add(comp);
                iterators.remove();
            }
        }
    }

    public void destroy(SystemCore system, Dump dump, String hardwareComponentName) {
        Iterator<HardwareComponents> iterators = dump.getHardwareComponents().iterator();
        while (iterators.hasNext()) {
            HardwareComponents comp = iterators.next();
            if (comp.getName().equals(hardwareComponentName)) {
                iterators.remove();
            }
        }
    }

    public String dumpAnalyse(SystemCore system, Dump dump) {
        int powerHardwareCount = 0;
        int heavyHardwareCount = 0;
        int lightSoftware = 0;
        int expressSoftware = 0;
        for (HardwareComponents hardwareComponents : dump.getHardwareComponents()) {
            if (hardwareComponents.getType().equals("Power")) {
                powerHardwareCount++;
            } else {
                heavyHardwareCount++;
            }
            for (SoftwareComponents softwareComponent : hardwareComponents.getSoftwareComponents()) {
                if (softwareComponent.getType().equals("Light")) {
                    lightSoftware++;
                } else {
                    expressSoftware++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        int totalDumpMemoryInUse = dump.getHardwareComponents().stream().mapToInt(HardwareComponents::getUsedMemory).sum();
        int totalDumpCapacityTaken = dump.getHardwareComponents().stream().mapToInt(HardwareComponents::getUsedCapacity).sum();
        sb.append(String.format("Dump Analysis%n"));
        sb.append(String.format("Power Hardware Components: %s%n", powerHardwareCount));
        sb.append(String.format("Heavy Hardware Components: %s%n", heavyHardwareCount));
        sb.append(String.format("Express Software Components: %s%n", expressSoftware));
        sb.append(String.format("Light Software Components: %s%n", lightSoftware));
        sb.append(String.format("Total Dumped Memory: %s%n", totalDumpMemoryInUse));
        sb.append(String.format("Total Dumped Capacity: %s", totalDumpCapacityTaken));
        return sb.toString();
    }
}
