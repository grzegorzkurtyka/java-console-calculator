package calc.tokenizer.token;

import calc.tokenizer.token.IntegerType;
import calc.tokenizer.token.DoubleType;
import calc.tokenizer.token.type.NumberType;
import calc.tokenizer.token.type.OperatorType;

public class OperatorDIV implements OperatorType {

    public int precedence() {
        return 3;
    }

    public Associativity associativity() {
        return Associativity.LEFT;
    }

    public DoubleType operate(IntegerType op1, IntegerType op2) {
        return new DoubleType((double) op1.value / (double) op2.value);
    }

    public DoubleType operate(DoubleType op1, DoubleType op2) {
        return new DoubleType(op1.value / op2.value);
    }

    public DoubleType operate(IntegerType op1, DoubleType op2) {
        return new DoubleType(op1.value / op2.value);
    }

    public DoubleType operate(DoubleType op1, IntegerType op2) {
        return new DoubleType(op1.value / op2.value);
    }

    public String toString() {
        return "'/'";
    }

}
