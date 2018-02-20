package parser;

public class FloatParser implements MyParser {
    @Override
    public Object getValue(String value) {
        return Float.parseFloat(value);
    }
}
