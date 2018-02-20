package parser;

public class IntegerParser implements MyParser {
    @Override
    public Object getValue(String value) {
        return Integer.parseInt(value);
    }
}
