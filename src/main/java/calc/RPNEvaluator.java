package calc;

import java.util.Stack;

import calc.tokenizer.token.type.TokenType;
import calc.tokenizer.token.type.OperatorType;
import calc.tokenizer.token.type.NumberType;

import calc.tokenizer.token.IntegerType;
import calc.tokenizer.token.DoubleType;

class RPNEvaluator {

    Stack<TokenType> stack;
    Stack<TokenType> rpn;

    public RPNEvaluator(Stack<TokenType> rpn) {
        this.rpn = rpn;
        this.stack = new Stack<>();
    }

    public Number evaluate() throws Exception {
        Number output;
        for (TokenType token : this.rpn) {
            if (token instanceof NumberType) {
                this.stack.push(token);
            } else if (token instanceof OperatorType) {
                try {
                    TokenType op1, op2;
                    op2 = this.stack.pop();
                    op1 = this.stack.pop();
                    NumberType newToken = operateOnStack((OperatorType) token, (NumberType) op1, (NumberType) op2);

                    this.stack.push(newToken);
                } catch (java.util.EmptyStackException es) {
                    throw new Exception("RPNEvaluator: Unbalanced stack cannot be evaluated");
                }
            } else {
                throw new Exception("RPNEvaluator: Unrecognized token type: " + token);
            }
        }

        NumberType lastNumber = (NumberType) this.stack.pop();
        output = lastNumber.value();

        return output;
    }

    private NumberType operateOnStack(OperatorType token, NumberType op1, NumberType op2) {
        NumberType newToken = null;
        if (op1 instanceof IntegerType && op2 instanceof IntegerType) {
            newToken = token.operate((IntegerType) op1, (IntegerType) op2);
        } else if (op1 instanceof DoubleType && op2 instanceof IntegerType) {
            newToken = token.operate((DoubleType) op1, (IntegerType) op2);
        } else if (op1 instanceof IntegerType && op2 instanceof DoubleType) {
            newToken = token.operate((IntegerType) op1, (DoubleType) op2);
        } else if (op1 instanceof DoubleType && op2 instanceof DoubleType) {
            newToken = token.operate((DoubleType) op1, (DoubleType) op2);
        }
        return newToken;
    }

}
