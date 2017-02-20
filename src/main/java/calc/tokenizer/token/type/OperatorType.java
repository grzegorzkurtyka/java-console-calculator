package calc.tokenizer.token.type;

import calc.tokenizer.token.IntegerType;
import calc.tokenizer.token.DoubleType;

public interface OperatorType extends TokenType {

    enum Associativity {LEFT, RIGHT}

    int precedence();

    Associativity associativity();

    NumberType operate(IntegerType op1, IntegerType op2);

    NumberType operate(DoubleType op1, IntegerType op2);

    NumberType operate(IntegerType op1, DoubleType op2);

    NumberType operate(DoubleType op1, DoubleType op2);

}
