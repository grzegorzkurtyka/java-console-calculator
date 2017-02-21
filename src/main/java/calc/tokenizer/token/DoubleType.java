package calc.tokenizer.token;

import java.lang.Double;
import java.util.Objects;

import calc.tokenizer.token.type.NumberType;

public class DoubleType extends NumericToken implements NumberType {

    public DoubleType(Double d) {
        this.value = d;
    }

    public Number value() {
        return this.value;
    }

    public String toString() {
        return this.value.toString();
    }

}
