package com.company.components;

public abstract class SoftwareComponents extends Component {
    private int capacityConsumption;
    private int memoryConsumption;


    public SoftwareComponents(String name, String type, int capacityConsumption, int memoryConsumption) {
        super(name, type);
        this.capacityConsumption = capacityConsumption;
        this.memoryConsumption = memoryConsumption;
    }

    public int getCapacityConsumption() {
        return capacityConsumption;
    }

    protected void setCapacityConsumption(int capacityConsumption) {
        this.capacityConsumption = capacityConsumption;
    }

    public int getMemoryConsumption() {
        return memoryConsumption;
    }

    protected void setMemoryConsumption(int memoryConsumption) {
        this.memoryConsumption = memoryConsumption;
    }
}
