package calc.tokenizer.token;

import java.lang.Double;
import calc.tokenizer.token.type.NumberType;

public class DoubleType implements NumberType {

  Double value;

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
