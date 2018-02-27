package myfile;

import parser.Column;

import java.util.*;

public class MyFile {
    private int configNumber;
    private Date date;
    private String author;
    private ArrayList<Column<?>> data;

    public MyFile(int configNumber, String author, Date date, ArrayList<Column<?>> data) {
        this.configNumber = configNumber;
        this.author = author;
        this.date = date;
        this.data = data;
    }

    public int getConfigNumber() {
        return configNumber;
    }

    public String getAuthor() {
        return author;
    }

    public Date getDate() {
        return date;
    }

    public ArrayList<Column<?>> getData() {
        return data;
    }
}
