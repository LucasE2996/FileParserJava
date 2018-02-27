package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import parser.FloatParser;
import parser.IntegerParser;
import parser.MyParser;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class DataTester {

    @Test
    void date() throws ParseException {
        final DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = df.parse("16/12/2005 20:00:00");
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        Assertions.assertEquals("16/12/2005 20:00:00", dateFormat.format(date));
    }

    @Test
    void integerParser() {
        MyParser parser = new IntegerParser();
        String number = "1";
        int realNum = 1;
        double shouldFail = 1;
        System.out.println(parser.getValue(number).equals(realNum));
        System.out.println(parser.getValue(number).equals(shouldFail));
    }

    @Test
    void FloatParser() {
        MyParser parser = new FloatParser();
        String number = "1.55";
        float realNum = 1.55f;
        double shouldFail = 1.55;
        System.out.println(parser.getValue(number).equals(realNum));
        System.out.println(parser.getValue(number).equals(shouldFail));
    }
}
