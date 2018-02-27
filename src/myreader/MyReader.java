package myreader;

import myfile.MyFile;
import parser.Column;
import parser.MyParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.stream.Stream;


public class MyReader {

    private ArrayList<String> lines;
    private HashMap<Integer, ArrayList<MyParser>> configurations;
    private final Header header = new Header();

    public MyReader(HashMap<Integer, ArrayList<MyParser>> configurations) {
        lines =  new ArrayList<>();
        this.configurations = configurations;
    }

    public MyFile read(String path) {
        lines = saveFile(path);
        readData(header.getConfigNumber(lines));
        return new MyFile(header.getConfigNumber(lines),
                header.getAuthor(lines),
                header.getDate(lines),
                readData(header.getConfigNumber(lines)));
    }

    private ArrayList<Column<?>> readData(int configNumber) {
        ArrayList<Column<?>> data = new ArrayList<>();
        ArrayList<MyParser> parsers = getParsersConfig(configNumber);
        ArrayList<String[]> characters = new ArrayList<>(); // change this later
        lines.forEach(line -> characters.add(line.split("\t")));
        int counter = 0;
        for (int j = 0; j < characters.get(3).length; j++) {
            ArrayList<Object> dataColumn = new ArrayList<>();
            for (int i = 3; i < characters.size(); i++) {
                dataColumn.add(parsers.get(j).getValue(characters.get(i)[counter]));
            }
            data.add(new Column<>(dataColumn));
            counter++;
        }
        return data;
    }

    private ArrayList<String> saveFile(String path) {
        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            stream.forEach(lines::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    private ArrayList<MyParser> getParsersConfig(int configNumber) {
        return configurations.entrySet().stream()
                .filter(e -> e.getKey() == configNumber)
                .findAny()
                .orElseThrow(NoSuchElementException::new)
                .getValue();
    }
}
