package com.company;

import com.company.components.ComponentFactory;
import com.company.dump.DumpFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ComponentFactory factory = new ComponentFactory();
        DumpFactory dumpFactory = new DumpFactory();
        SystemCore system = new SystemCore();
        String line = reader.readLine();
        while (!line.equals("System Split")) {
            String command = line.substring(0, line.indexOf("("));
            switch (command) {
                case "RegisterPowerHardware":
                    String[] powerHardwareComponents = line.substring(line.indexOf("(") + 1, line.indexOf(")")).split(", ");
                    String powerHardwareName = powerHardwareComponents[0];
                    int powerHardwareCapacity = Integer.parseInt(powerHardwareComponents[1]);
                    int powerHardwareMemory = Integer.parseInt(powerHardwareComponents[2]);
                    factory.registerPowerHardware(system, powerHardwareName, powerHardwareCapacity, powerHardwareMemory);
                    break;
                case "RegisterHeavyHardware":
                    String[] heavyHardwareComponents = line.substring(line.indexOf("(") + 1, line.indexOf(")")).split(", ");
                    String heavyHardwareName = heavyHardwareComponents[0];
                    int heavyHardwareCapacity = Integer.parseInt(heavyHardwareComponents[1]);
                    int heavyHardwareMemory = Integer.parseInt(heavyHardwareComponents[2]);
                    factory.registerHeavyHardware(system, heavyHardwareName, heavyHardwareCapacity, heavyHardwareMemory);
                    break;
                case "RegisterExpressSoftware":
                    String[] expressSoftwareComponents = line.substring(line.indexOf("(") + 1, line.indexOf(")")).split(", ");
                    String hardwareName1 = expressSoftwareComponents[0];
                    String expressSoftwareName = expressSoftwareComponents[1];
                    int expressSoftwareCapacity = Integer.parseInt(expressSoftwareComponents[2]);
                    int expressSoftwareMemory = Integer.parseInt(expressSoftwareComponents[3]);
                    factory.registerExpressSoftware(system, hardwareName1, expressSoftwareName, expressSoftwareCapacity, expressSoftwareMemory);
                    break;
                case "RegisterLightSoftware":
                    String[] lightSoftwareComponents = line.substring(line.indexOf("(") + 1, line.indexOf(")")).split(", ");
                    String hardwareName2 = lightSoftwareComponents[0];
                    String lightSoftwareName = lightSoftwareComponents[1];
                    int lightSoftwareCapacity = Integer.parseInt(lightSoftwareComponents[2]);
                    int lightSoftwareMemory = Integer.parseInt(lightSoftwareComponents[3]);
                    factory.registerLightSoftware(system, hardwareName2, lightSoftwareName, lightSoftwareCapacity, lightSoftwareMemory);
                    break;
                case "ReleaseSoftwareComponent":
                    String[] releaseSoftwareComponents = line.substring(line.indexOf("(") + 1, line.indexOf(")")).split(", ");
                    String hardwareName = releaseSoftwareComponents[0];
                    String softwareName = releaseSoftwareComponents[1];
                    factory.releaseSoftwareComponent(system, hardwareName, softwareName);
                    break;
                case "Analyze":
                    System.out.println(factory.analyze(system));
                    break;
                case "Dump":
                    String[] dumpComponent = line.substring(line.indexOf("(") + 1, line.indexOf(")")).split(", ");
                    String hardwareToDump = dumpComponent[0];
                    dumpFactory.dump(system, system.getDump(), hardwareToDump);
                    break;
                case "Restore":
                    String[] dumpComponentToRestore = line.substring(line.indexOf("(") + 1, line.indexOf(")")).split(", ");
                    String hardwareToRestore = dumpComponentToRestore[0];
                    dumpFactory.restore(system, system.getDump(), hardwareToRestore);
                    break;
                case "Destroy":
                    String[] dumpComponentToDestroy = line.substring(line.indexOf("(") + 1, line.indexOf(")")).split(", ");
                    String hardwareToDestroy = dumpComponentToDestroy[0];
                    dumpFactory.destroy(system, system.getDump(), hardwareToDestroy);
                    break;
                case "DumpAnalyze":
                    System.out.println(dumpFactory.dumpAnalyse(system, system.getDump()));
                default:
                    break;
            }
            line = reader.readLine();

        }
        System.out.println(factory.systemSplit(system));
    }
}
