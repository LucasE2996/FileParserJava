import file.MyFile;
import myreader.Config1;
import myreader.MyReader;

public class Main {
    public static void main(String[] args) {

        MyReader reader = new MyReader();
        MyFile file;

        file = reader.read("/home/marshmello/Documents/Github/FocusNetworks/desafio2/secondTest.txt");

        file.printContent();

    }
}
