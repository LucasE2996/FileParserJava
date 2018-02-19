package parser;

public class IntegerParser implements MyParser {

    public Integer convert(String value) {
        return Integer.parseInt(value);
    }
}
