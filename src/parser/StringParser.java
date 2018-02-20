package parser;

public class StringParser implements MyParser {
    @Override
    public Object getValue(String value) {
        return value;
    }
}
