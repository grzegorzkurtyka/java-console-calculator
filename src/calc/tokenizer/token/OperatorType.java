package calc.tokenizer.token;

public interface OperatorType extends TokenType {

    public enum Associativity {LEFT, RIGHT}

    public int precedence();

    public Associativity associativity();

    public NumberType operate(IntegerType op1, IntegerType op2);
    public NumberType operate(DoubleType op1, IntegerType op2);
    public NumberType operate(IntegerType op1, DoubleType op2);
    public NumberType operate(DoubleType op1, DoubleType op2);

}
