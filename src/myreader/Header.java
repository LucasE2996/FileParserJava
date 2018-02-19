package myreader;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Header {

    private final ArrayList<String> header;

    Header(ArrayList<String> header) {
        this.header = header;
    }

    protected Date getDate() {
        final DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = null;
        try {
            date = df.parse(header.get(1));
        }catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    protected int getConfigNumber() {
        return Integer.parseInt(header.get(0).trim());
    }

    protected String getAuthor() {
        return header.get(2);
    }

}
