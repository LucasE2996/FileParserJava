package myfile;

import parser.Column;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class MyFile {
    private int configNumber;
    private Date date;
    private String author;
    private HashMap<Integer, Column> data;

    public MyFile(int configNumber, String author, Date date, HashMap<Integer, Column> data) {
        this.configNumber = configNumber;
        this.author = author;
        this.date = date;
        this.data = data;
    }

    public void printContent() {
        System.out.println(configNumber);
        System.out.println(date);
        System.out.println(author);
        ArrayList<String> dataContent = parseDatatoString(data);
        dataContent.forEach(System.out::println);
    }

    private ArrayList<String> parseDatatoString(HashMap<Integer, Column> data) {
        ArrayList<String> lines = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            for (int j = 0; j < data.get(i).getData().size(); j++) {
                if(i == 0) {
                    lines.add(data.get(i).getData().get(j).toString());
                } else {
                    lines.set(j, lines.get(j) + "\t" + data.get(i).getData().get(j).toString());
                }
            }
        }
        return lines;
    }

}
