package com.company.dump;

import com.company.components.HardwareComponents;

import java.util.List;

public class Dump {
    private List<HardwareComponents> hardwareComponents;

    public Dump(List<HardwareComponents> hardwareComponents) {
        this.hardwareComponents = hardwareComponents;
    }

    public List<HardwareComponents> getHardwareComponents() {
        return hardwareComponents;
    }
}
