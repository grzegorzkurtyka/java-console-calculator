package calc.tokenizer.token;

import calc.tokenizer.token.type.NumberType;
import calc.tokenizer.token.type.OperatorType;

public class OperatorADD extends BaseToken implements OperatorType {

    public OperatorADD() {
        this.value = "+";
    }

    public int precedence() {
        return 2;
    }

    public Associativity associativity() {
        return Associativity.LEFT;
    }

    public NumberType operate(IntegerType op1, IntegerType op2) {
        return new IntegerType(op1.value.intValue() + op2.value.intValue());
    }

    public NumberType operate(DoubleType op1, IntegerType op2) {
        return new DoubleType(op1.value.doubleValue() + op2.value.intValue());
    }

    public NumberType operate(IntegerType op1, DoubleType op2) {
        return operate(op2, op1);
    }

    public NumberType operate(DoubleType op1, DoubleType op2) {
        return new DoubleType(op1.value.doubleValue() + op2.value.doubleValue());
    }

    public String toString() {
        return "'+'";
    }

}
