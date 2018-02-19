package myreader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;

public abstract class MyInterpretator {

    protected HashMap<Integer, ArrayList> dataColumn = new HashMap<>();

    MyInterpretator() {
        setDefaultConfig();
    }

    abstract protected void setDefaultConfig();

    protected void loadDataInColumns(ArrayList<String> lines) throws NullPointerException {
        String[] lineData;
        try {
            for (int i=3; i < lines.size(); i++) {
                lineData = lines.get(i).split("\t");
                for (int j = 0; j < dataColumn.size(); j++) {
                    dataColumn.get(j).add(lineData[j]);
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
