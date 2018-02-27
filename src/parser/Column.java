package parser;

import java.util.ArrayList;

public class Column<T> {

    private final ArrayList<T> data;

    public Column(ArrayList<T> data){
        this.data = data;
    }

    public ArrayList<T> getData() {
        return data;
    }
}
