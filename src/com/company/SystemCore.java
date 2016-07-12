package com.company;

import com.company.components.HardwareComponents;
import com.company.dump.Dump;

import java.util.ArrayList;
import java.util.List;

public class SystemCore {
    private List<HardwareComponents> hardwareComponents;
    private Dump dump;

    public SystemCore() {
        this.hardwareComponents = new ArrayList<>();
        this.dump = new Dump(new ArrayList<>());
    }

    public Dump getDump() {
        return dump;
    }

    public List<HardwareComponents> getHardwareComponents() {
        return hardwareComponents;
    }
}
