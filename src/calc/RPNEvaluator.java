package calc;

import java.util.ArrayList;
import java.util.Stack;
import calc.tokenizer.token.TokenType;
import calc.tokenizer.token.NumberType;
import calc.tokenizer.token.IntegerType;
import calc.tokenizer.token.DoubleType;
import calc.tokenizer.token.OperatorType;

class RPNEvaluator {

  Stack<TokenType> stack;
  ArrayList<TokenType> rpn;

  public RPNEvaluator(ArrayList<TokenType> rpn) {
    this.rpn = rpn;
    this.stack = new Stack<TokenType>();
  }

  public Number evaluate()
  {
    Number output = null;
    for(TokenType token: this.rpn) {
      if (token instanceof NumberType) {
        this.stack.push((TokenType) token);
      }
      if (token instanceof OperatorType) {
        TokenType op1, op2;
        op2 = this.stack.pop();
        op1 = this.stack.pop();
        NumberType newToken = operateOnStack((OperatorType) token, (NumberType) op1, (NumberType) op2);

        this.stack.push(newToken);
      }
      // System.out.println(this.stack);
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
