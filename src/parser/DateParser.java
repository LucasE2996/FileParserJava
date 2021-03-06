package parser;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateParser implements MyParser {
    @Override
    public Date getValue(String inputDate) {
        final DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        try {
            date = df.parse(inputDate);
        }catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
