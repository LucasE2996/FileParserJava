import myfile.*;
import myreader.*;
import parser.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        HashMap<Integer, ArrayList<MyParser>> configurations = new HashMap<>();
        Configuration configuration = new Configuration();
        configurations.put(1, configuration.addConfiguration(new IntegerParser()).addConfiguration(new FloatParser()).addConfiguration(new DateParser()).addConfiguration(new StringParser()).addConfiguration(new IntegerParser()).build());
        configurations.put(2, configuration.addConfiguration(new StringParser()).addConfiguration(new IntegerParser()).addConfiguration(new IntegerParser()).addConfiguration(new FloatParser()).build());



        MyReader reader = new MyReader(configurations);
        MyFile file;

//        file = reader.read("C:\\Users\\Focusnetworks\\Documents\\GitHub\\FileParserJava\\src\\dbfile\\fileTest.txt");
//        file.printContent();

        file = reader.read("C:\\Users\\Focusnetworks\\Documents\\GitHub\\FileParserJava\\src\\dbfile\\fileTest02.txt");
        file.printContent();
    }
}
