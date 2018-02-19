import myfile.MyFile;
import myreader.MyReader;

public class Main {
    public static void main(String[] args) {

        MyReader reader = new MyReader();
        MyFile file;

        file = reader.read("C:\\Users\\Focusnetworks\\Documents\\GitHub\\FileParserJava\\src\\dbfile\\fileTest.txt");

        file.printContent();

    }
}
