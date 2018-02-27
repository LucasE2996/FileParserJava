package myreader;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Header {

    Date getDate(ArrayList<String> lines) {
        final DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = null;
        try {
            date = df.parse(lines.get(1));
        }catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    int getConfigNumber(ArrayList<String> lines) {
        return Integer.parseInt(lines.get(0).trim());
    }

    String getAuthor(ArrayList<String> lines) {
        return lines.get(2);
    }

}
