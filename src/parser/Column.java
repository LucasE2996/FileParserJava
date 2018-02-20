package parser;

import java.util.ArrayList;

public class Column<T> {
    ArrayList<T> data;

    public Column(ArrayList<T> data){
        this.data = data;
    }

    void addElement(T t) {
        data.add(t);
    }

    public ArrayList<T> getData() {
        return data;
    }
}
