package myreader;

import java.util.ArrayList;
import java.util.Date;

public class Config1 extends MyInterpretator {


    protected Config1() {
        super();
    }

    @Override
    protected void setDefaultConfig() {
        dataColumn.put(0, new ArrayList<Integer>());
        dataColumn.put(1, new ArrayList<Float>());
        dataColumn.put(2, new ArrayList<Date>());
        dataColumn.put(3, new ArrayList<String>());
        dataColumn.put(4, new ArrayList<Integer>());
    }

}
