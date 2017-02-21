package calc.tokenizer.token;

import java.util.Objects;

public class BaseToken {

    protected String value;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseToken that = (BaseToken) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public String toString() {
        return "'" + value + "'";
    }
}
