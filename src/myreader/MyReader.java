package myreader;

import myfile.MyFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.stream.Stream;


public class MyReader {

    private ArrayList<String> lines;
    private HashMap<Integer, ArrayList> data;
    private String author;
    private Date date;
    private int configNumber;
    private final Configurations configurations;
    private ParseFileToList parser;

    public MyReader() {
        lines =  new ArrayList<>();
        configurations = new Configurations();
        parser = new ParseFileToList();
    }

    public MyFile read(String path) {
        parser.saveFile(path);
        readHeader();
        readData(configNumber);
        return new MyFile(configNumber, author, date, data);
    }

    private void readHeader() {
        final HeadReader head = new HeadReader(lines);
        author = head.getAuthor();
        try {
            date = head.getDate();
            configNumber = head.getConfigNumber();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    // This class will delegate the task of reading the data of a file depending on its configuration number.
    private void readData(int configNumber) {
        final MyInterpretator interpretator = configurations.getInterpretators().entrySet().stream()
                .filter(e -> e.getKey() == configNumber)
                .findFirst()
                .get()
                .getValue();

        interpretator.loadDataInColumns(lines);
        data = interpretator.dataColumn;
    }
}
