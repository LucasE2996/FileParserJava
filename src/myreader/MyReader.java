package myreader;

import myfile.MyFile;
import parser.Column;
import parser.MyParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Stream;


public class MyReader {

    private ArrayList<String> lines;
    private HashMap<Integer, Column<Object>> data;
    private HashMap<Integer, ArrayList<MyParser>> configurations;

    public MyReader(HashMap<Integer, ArrayList<MyParser>> configurations) {
        lines =  new ArrayList<>();
        this.configurations = configurations;
    }

    public MyFile read(String path) {
        lines = saveFile(path);
        Header header = new Header(lines);
        readData(header.getConfigNumber());
        return new MyFile(header.getConfigNumber(), header.getAuthor(), header.getDate(), data);
    }

    // This class will delegate the task of reading the data of a file depending on its configuration number.
    private void readData(int configNumber) {
       ArrayList<MyParser> parsers = configurations.entrySet().stream()
               .filter(e -> e.getKey() == configNumber)
               .findFirst()
               .get().getValue();
        ArrayList<String[]> characters = new ArrayList<>();
        lines.forEach(line -> characters.add(line.split("\t")));
        for (int i = 0; i < characters.size(); i++) {
            ArrayList<Object> dataColumn = new ArrayList<>();
            dataColumn.add(parsers.get(i).getValue(characters.get(i)[i]));
            data.put(i, new Column<>(dataColumn));
        }
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
