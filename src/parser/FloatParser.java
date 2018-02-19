package parser;

public class FloatParser implements MyParser {
    public Float convert(String value) {
        return Float.parseFloat(value);
    }
}
