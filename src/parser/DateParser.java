package parser;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateParser implements MyParser {
    @Override
    public Object getValue(String inputDate) {
        final DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = null;
        try {
            date = df.parse(inputDate);
        }catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
