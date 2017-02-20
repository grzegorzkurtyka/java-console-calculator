package calc.tokenizer.token;

import calc.tokenizer.token.IntegerType;
import calc.tokenizer.token.DoubleType;
import calc.tokenizer.token.type.NumberType;
import calc.tokenizer.token.type.OperatorType;

public class OperatorMUL implements OperatorType {

    public int precedence() {
        return 3;
    }

    public Associativity associativity() {
        return Associativity.LEFT;
    }

    public NumberType operate(IntegerType op1, IntegerType op2) {
        return new IntegerType(op1.value.intValue() * op2.value.intValue());
    }

    public DoubleType operate(DoubleType op1, DoubleType op2) {
        return new DoubleType(op1.value.doubleValue() * op2.value.doubleValue());
    }

    public DoubleType operate(IntegerType op1, DoubleType op2) {
        return new DoubleType(op1.value.intValue() * op2.value.doubleValue());
    }

    public DoubleType operate(DoubleType op1, IntegerType op2) {
        return operate(op2, op1);
    }

    public String toString() {
        return "'*'";
    }
}
