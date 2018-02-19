package myreader;

import java.util.HashMap;

public class Configurations {
    private HashMap<Integer, MyInterpretator> interpretators;

    Configurations() {
        interpretators = new HashMap<>();
        addConfigs();
    }

    private void addConfigs() {
        interpretators.put(1, new Config1());
        interpretators.put(2, new Config2());
    }

    public HashMap<Integer, MyInterpretator> getInterpretators() {
        return interpretators;
    }
}
