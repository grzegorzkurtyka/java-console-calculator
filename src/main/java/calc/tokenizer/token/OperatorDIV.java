package calc.tokenizer.token;

import calc.tokenizer.token.type.OperatorType;

public class OperatorDIV extends BaseToken implements OperatorType {

    public OperatorDIV() {
        this.value = "/";
    }

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
        return new DoubleType(op1.value.doubleValue() / op2.value.doubleValue());
    }

    public DoubleType operate(IntegerType op1, DoubleType op2) {
        return new DoubleType(op1.value.intValue() / op2.value.doubleValue());
    }

    public DoubleType operate(DoubleType op1, IntegerType op2) {
        return new DoubleType(op1.value.doubleValue() / op2.value.intValue());
    }

}
