package myreader;

import java.util.ArrayList;

import parser.MyParser;

public class Configuration {
    private ArrayList<MyParser> parsers;

    public Configuration() {
        parsers = new ArrayList<>();
    }

    public Configuration addConfiguration(MyParser parser) {
        parsers.add(parser);
        return this;
    }

    public ArrayList<MyParser> build() {
        return parsers;
    }
}
