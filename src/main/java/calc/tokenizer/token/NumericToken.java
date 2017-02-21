package calc.tokenizer.token;

public class NumericToken extends BaseToken {

    public Number value;

    public Number value() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        NumericToken that = (NumericToken) o;
        return value.equals(that.value());
    }

}
