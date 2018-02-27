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
        MyFile file = reader.read("/home/marshmello/Documents/Github/FileParserJava/src/dbfile/fileTest.txt");
        System.out.println(file.getConfigNumber());
        System.out.println(file.getDate());
        System.out.println(file.getAuthor());
        parseDataToString(file.getData()).forEach(System.out::println);

//        file = reader.read("C:\\Users\\Focusnetworks\\Documents\\GitHub\\FileParserJava\\src\\dbfile\\fileTest02.txt");
//        file.getContent();
    }

    // move this code to some frontend class later
    private static ArrayList<String> parseDataToString(ArrayList<Column<Object>> data) {
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
