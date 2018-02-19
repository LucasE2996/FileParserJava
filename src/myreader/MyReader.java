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
    private final Configurations configurations;

    public MyReader() {
        lines =  new ArrayList<>();
        configurations = new Configurations();
    }

    public MyFile read(String path) {
        lines = saveFile(path);
        Header header = new Header(lines);
        readData(header.getConfigNumber());
        return new MyFile(header.getConfigNumber(), header.getAuthor(), header.getDate(), data);
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

    private ArrayList<String> saveFile(String path) {
        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            stream.forEach(lines::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}
