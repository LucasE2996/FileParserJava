package parser;

public class FloatParser implements MyParser {
    @Override
    public Float getValue(String value) {
        return Float.parseFloat(value);
    }
}
