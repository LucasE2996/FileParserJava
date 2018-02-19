package myreader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;

public abstract class MyInterpretator {

    protected HashMap<Integer, ArrayList> dataColumn = new HashMap<>();

    protected MyInterpretator() {
        setDefaultConfig();
    }

    abstract protected void setDefaultConfig();

    public ArrayList getColumn(int column) throws NoSuchElementException {
        return dataColumn.entrySet().stream()
                .filter(e -> e.getKey() == column)
                .findFirst()
                .get()
                .getValue();
    }

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

    public Object getDataAtLineColumn(int columnNumber, int lineNumber) throws NoSuchElementException{
        return getColumn(columnNumber).get(lineNumber);
    }
}
