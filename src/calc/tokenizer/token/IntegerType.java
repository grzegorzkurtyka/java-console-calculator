package calc.tokenizer.token;

public class IntegerType implements NumberType {
  Integer value;

  public IntegerType(Integer i) {
    this.value = i;
  }

  public Number value() {
    return this.value;
  }

  public String toString(){
    return this.value.toString();
  }
}
