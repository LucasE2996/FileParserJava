import myfile.*;
import myreader.*;
import parser.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        HashMap<Integer, ArrayList<MyParser>> configurations = new HashMap<>();
        configurations.put(1, new Configuration()
                .addConfiguration(new IntegerParser())
                .addConfiguration(new FloatParser())
                .addConfiguration(new DateParser())
                .addConfiguration(new StringParser())
                .addConfiguration(new IntegerParser())
                .build());
        configurations.put(2, new Configuration()
                .addConfiguration(new StringParser())
                .build());



        MyReader reader = new MyReader(configurations);
        MyFile file;

        file = reader.read("C:\\Users\\Focusnetworks\\Documents\\GitHub\\FileParserJava\\src\\dbfile\\fileTest.txt");
        file.printContent();

//        file = reader.read("C:\\Users\\Focusnetworks\\Documents\\GitHub\\FileParserJava\\src\\dbfile\\fileTest02.txt");
//        file.printContent();
    }
}
