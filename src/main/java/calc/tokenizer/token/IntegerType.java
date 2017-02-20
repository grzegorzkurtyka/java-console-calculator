package calc.tokenizer.token;

import calc.tokenizer.token.type.NumberType;

public class IntegerType implements NumberType {
    Integer value;

    public IntegerType(Integer i) {
        this.value = i;
    }

    public Number value() {
        return this.value;
    }

    public String toString() {
        return this.value.toString();
    }
}
