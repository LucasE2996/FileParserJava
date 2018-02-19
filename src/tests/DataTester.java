package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataTester {

    @Test
    void date() throws ParseException {
        final DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = df.parse("16/12/2005 20:00:00");

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date2 = new Date();

        Assertions.assertEquals("16/12/2005 20:00:00", dateFormat.format(date));
    }

    @Test
    void integerParser() {
        String number = " 1";
//        int num = Integer.parseInt(number.replaceAll("\\s+",""));
        int num = Integer.parseInt(number.trim());
        //        int num = Integer.parseInt(number);
        System.out.println(num);
    }
}
