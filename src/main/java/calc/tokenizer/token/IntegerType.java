package calc.tokenizer.token;

import calc.tokenizer.token.type.NumberType;

public class IntegerType extends NumericToken implements NumberType {

    public IntegerType(Integer i) {
        this.value = i;
    }

    public String toString() {
        return value.toString();
    }

}
