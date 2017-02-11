package calc;

import java.util.ArrayList;
import java.util.Stack;
import calc.tokenizer.token.TokenType;
import calc.tokenizer.token.NumberType;
import calc.tokenizer.token.OperatorType;

class ShuntingYard {

  Stack<OperatorType> operators;
  ArrayList<TokenType> input;
  ArrayList<TokenType> output;

  public ShuntingYard(ArrayList<TokenType> input) {
    this.input = input;
    this.output = new ArrayList<TokenType>();
    this.operators = new Stack<OperatorType>();
  }

  public ArrayList<TokenType> rpn()
  {
    for(TokenType token: this.input) {
      if (token instanceof NumberType) {
        output.add(token);
      }
      if (token instanceof OperatorType) {
        if (!operators.empty()) {
          while(shouldPushOperatorToStack(token)) {
              output.add(operators.pop());
          }
        }
        operators.push((OperatorType) token);
      }
    }

    while(!operators.empty()) {
      output.add(operators.pop());
    }

    return output;
  }

  private boolean shouldPushOperatorToStack(TokenType token) {
    if (operators.empty()) {
      return false;
    }
    TokenType onStack = operators.peek();

    if (onStack instanceof OperatorType) {
      OperatorType opToken = (OperatorType) token;
      OperatorType opOnStack = (OperatorType) onStack;

      if(opToken.associativity() == OperatorType.Associativity.LEFT && opToken.precedence() <= opOnStack.precedence() ) {
        return true;
      }
      if(opToken.associativity() == OperatorType.Associativity.RIGHT && opToken.precedence() < opOnStack.precedence() ) {
          return true;
      }
    }
    return false;
  }

}
