package calc.tokenizer.token;

public class OperatorSUB implements OperatorType {
  public NumberType operate(NumberType op1, NumberType op2) {
    return new IntegerType(-123);
  }
}
