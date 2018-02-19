package file;

import myreader.MyInterpretator;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class MyFile {
    private int configNumber;
    private Date date;
    private String author;
    private HashMap<Integer, ArrayList> data;
    private ArrayList<String> dataContent;

    public MyFile(int configNumber, String author, Date date, HashMap<Integer, ArrayList> data) {
        this.configNumber = configNumber;
        this.author = author;
        this.date = date;
        this.data = data;
    }

    public void printContent() {
        System.out.println(configNumber);
        System.out.println(date);
        System.out.println(author);
        dataContent.forEach(System.out::println);
    }

    private ArrayList<String> parseDatatoString() {
        ArrayList<String> lines = new ArrayList<>();

        for (int i = 0; i < data.size(); i++) {
            for (int j = 0; j < data.size(); j++) {
                lines.add(data.get(i).get(j).toString());
            }
        }
        return lines;
    }
}
