package com.company.components;

import java.util.ArrayList;
import java.util.List;

public abstract class HardwareComponents extends Component {
    private int usedCapacity;
    private int usedMemory;
    private int maxCapacity;
    private int maxMemory;
    private List<SoftwareComponents> softwareComponents = new ArrayList<>();

    public HardwareComponents(
            String name,
            String type,
            int maxCapacity,
            int maxMemory,
            List<SoftwareComponents> softwareComponents) {
        super(name, type);
        this.setMaxMemory(maxMemory);
        this.setMaxCapacity(maxCapacity);
        this.setSoftwareComponents(softwareComponents);
        this.setUsedCapacity(0);
        this.setUsedMemory(0);
    }

    public void setUsedCapacity(int usedCapacity) {
        this.usedCapacity = this.softwareComponents.stream().mapToInt(SoftwareComponents::getCapacityConsumption).sum();
    }

    public void setUsedMemory(int usedMemory) {
        this.usedMemory = this.softwareComponents.stream().mapToInt(SoftwareComponents::getMemoryConsumption).sum();
    }

    public int getUsedCapacity() {
        return usedCapacity;
    }

    public int getUsedMemory() {
        return usedMemory;
    }

    public List<SoftwareComponents> getSoftwareComponents() {
        return softwareComponents;
    }

    protected void setSoftwareComponents(List<SoftwareComponents> softwareComponents) {
        this.softwareComponents = softwareComponents;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    protected void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public int getMaxMemory() {
        return maxMemory;
    }

    protected void setMaxMemory(int maxMemory) {
        this.maxMemory = maxMemory;
    }

    public int softwareSize() {
        return this.getSoftwareComponents().size();
    }

    public int getExpresSoftwareCount() {
        int count = 0;
        for (SoftwareComponents softwareComponent : softwareComponents) {
            if (softwareComponent.getType().equals("Express")) {
                count++;
            }
        }
        return count;
    }

    public int getLightSoftwareCount() {
        int count = 0;
        for (SoftwareComponents softwareComponent : softwareComponents) {
            if (softwareComponent.getType().equals("Light")) {
                count++;
            }
        }
        return count;
    }

    @Override
    public String toString() {

        List<String> softwareNames = new ArrayList<>();
        for (SoftwareComponents softwareComponent : this.softwareComponents) {
            softwareNames.add(softwareComponent.getName());
        }
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Hardware Component - %s%n", this.getName()));
        sb.append(String.format("Express Software Components - %s%n", this.getExpresSoftwareCount()));
        sb.append(String.format("Light Software Components - %s%n", this.getLightSoftwareCount()));
        sb.append(String.format("Memory Usage: %s / %s%n", this.usedMemory, this.maxMemory));
        sb.append(String.format("Capacity Usage: %s / %s%n", this.usedCapacity, this.maxCapacity));
        sb.append(String.format("Type: %s%n", this.getType()));
        sb.append("Software Components: ");
        if (softwareNames.size() > 0) {
            sb.append(String.join(", ", softwareNames));
            sb.append(String.format("%n"));
        } else {
            sb.append("None");
        }

        return sb.toString();
    }
}
