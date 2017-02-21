package calc.tokenizer.token;

import calc.tokenizer.token.type.NumberType;
import calc.tokenizer.token.type.OperatorType;

public class OperatorMUL extends BaseToken implements OperatorType {

    protected String value = "*";

    public int precedence() {
        return 3;
    }

    public Associativity associativity() {
        return Associativity.LEFT;
    }

    public NumberType operate(IntegerType op1, IntegerType op2) {
        return new IntegerType(op1.value * op2.value);
    }

    public DoubleType operate(DoubleType op1, DoubleType op2) {
        return new DoubleType(op1.value * op2.value);
    }

    public DoubleType operate(IntegerType op1, DoubleType op2) {
        return new DoubleType(op1.value * op2.value);
    }

    public DoubleType operate(DoubleType op1, IntegerType op2) {
        return operate(op2, op1);
    }

}
