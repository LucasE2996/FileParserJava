package myreader;

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
    // Integer = linha; ArrayList = coluna
    private HashMap<Integer, ArrayList> data;
    private String author;
    private Date date;
    private int configNumber;
    private HashMap<Integer, MyInterpretator> interpretators;

    public MyReader() {
        lines =  new ArrayList<>();
        interpretators = new HashMap<>();
        addConfigs();
    }

    // Routene
    public void read(String path) {
        saveFile(path);
        readHeader();
        readData(configNumber);
    }

    private void saveFile(String path) {
        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            stream.forEach(lines::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        final MyInterpretator interpretator = interpretators.entrySet().stream()
                .filter(e -> e.getKey() == configNumber)
                .findFirst()
                .get()
                .getValue();

        interpretator.loadDataInColumns(lines);
        data = interpretator.dataColumn;
    }

    private void addConfigs() {
        interpretators.put(1, new Config1());
    }
}
