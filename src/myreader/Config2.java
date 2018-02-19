package myreader;

import java.util.ArrayList;

public class Config2 extends MyInterpretator {

    public Config2() {
        super();
    }

    @Override
    protected void setDefaultConfig() {
        dataColumn.put(0, new ArrayList<String>());
        dataColumn.put(1, new ArrayList<Integer>());
        dataColumn.put(2, new ArrayList<Integer>());
        dataColumn.put(3, new ArrayList<Float>());
        dataColumn.put(4, new ArrayList<String>());
    }
}
