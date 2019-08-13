package Commands;

import Hardware.Hardware;

import java.util.Map;

public interface Commands {

    void registerPowerHardware(String name, int capacity, int memory);

    void registerHeavyHardware(String name, int capacity, int memory);

    void registerExpressSoftware(String hardwareComponentName, String name, int capacity, int memory);

    void registerLightSoftware(String hardwareComponentName, String name, int capacity, int memory);

    void releaseSoftware(String hardwareName, String softwareName);

    Map<String, Hardware> getHardwares();

    String analyze();

    void systemSplit();

    void dump(String hardwareName);

    void restore(String hardwareName);

    void destroy(String hardwareName);

    void dumpAnalyze();
}
