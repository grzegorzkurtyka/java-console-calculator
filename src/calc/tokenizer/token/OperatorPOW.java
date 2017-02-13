package calc.tokenizer.token;

import calc.tokenizer.token.IntegerType;
import calc.tokenizer.token.DoubleType;
import calc.tokenizer.token.type.NumberType;
import calc.tokenizer.token.type.OperatorType;

public class OperatorPOW implements OperatorType {

  public int precedence() {
    return 4;
  }

  public Associativity associativity() {
      return Associativity.RIGHT;
  }

  public NumberType operate(IntegerType op1, IntegerType op2) {
    return new DoubleType(Math.pow(op1.value.doubleValue(), op2.value.doubleValue()));
  }

  public DoubleType operate(DoubleType op1, DoubleType op2) {
    return new DoubleType(Math.pow(op1.value.doubleValue(), op2.value.doubleValue()));
  }

  public DoubleType operate(IntegerType op1, DoubleType op2) {
    return new DoubleType(Math.pow(op1.value.intValue(), op2.value.doubleValue()));
  }

  public DoubleType operate(DoubleType op1, IntegerType op2) {
    return new DoubleType(Math.pow(op1.value.doubleValue(), op2.value.doubleValue()));
  }

  public String toString() {
    return "'^'";
  }
}
