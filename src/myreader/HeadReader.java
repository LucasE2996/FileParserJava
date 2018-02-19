package myreader;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class HeadReader {

    private final ArrayList<String> header;

    HeadReader(ArrayList<String> header) {
        this.header = header;
    }

    protected Date getDate() throws ParseException {
        final DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return df.parse(header.get(1));
    }

    protected int getConfigNumber() {
        return Integer.parseInt(header.get(0).trim());
    }

    protected String getAuthor() {
        return header.get(2);
    }
}
