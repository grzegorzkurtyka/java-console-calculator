package calc;

import java.util.ArrayList;
import java.util.Stack;
import calc.tokenizer.token.type.TokenType;
import calc.tokenizer.token.type.NumberType;
import calc.tokenizer.token.type.OperatorType;
import calc.tokenizer.token.ParenOpenToken;
import calc.tokenizer.token.ParenCloseToken;

class ShuntingYard {

  ArrayList<TokenType> input;

  Stack<TokenType> operators;
  Stack<TokenType> output;

  public ShuntingYard(ArrayList<TokenType> input) {
    this.input = input;
    this.output = new Stack<TokenType>();
    this.operators = new Stack<TokenType>();
  }

  public Stack<TokenType> rpn() throws Exception
  {
    for(TokenType token: this.input) {
      if (token instanceof NumberType) {
        // If the token is a number, then push it to the output queue
        output.push(token);
      }
      else if (token instanceof OperatorType) {
        // If the token is an operator, o1, then:
        if (!operators.empty()) {
          // while there is an operator token o2, at the top of the operator stack and either
          while(shouldPushOperatorToStack(token)) {
              output.push(operators.pop());
          }
        }
        operators.push((OperatorType) token);
      } else if (token instanceof ParenOpenToken) {
        // If the token is a left parenthesis (i.e. "("), then push it onto the stack.
        operators.push(token);
      } else if (token instanceof ParenCloseToken) {
        // Until the token at the top of the stack is a left parenthesis, pop operators off the stack onto the output queue.
        // Pop the left parenthesis from the stack, but not onto the output queue.

        TokenType tmp;
        boolean popOperators = true;
        try {
          // If the stack runs out without finding a left parenthesis, then there are mismatched parentheses
          while(popOperators) {
            tmp = operators.pop();
            if (tmp instanceof ParenOpenToken) {
              popOperators = false;
            } else {
              output.push(tmp);
            }
          }
        } catch (java.util.EmptyStackException es) {
            throw new Exception("ShuntingYard: Unbalanced parenthesis");
        }
      } else {
        throw new Exception("ShuntingYard: Unrecognized token type: " + token);
      }
      // System.out.println("output" + output + "  operators=" + operators);
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
