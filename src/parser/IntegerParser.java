package parser;

public class IntegerParser implements MyParser {
    @Override
    public Integer getValue(String value) {
        return Integer.parseInt(value);
    }
}
