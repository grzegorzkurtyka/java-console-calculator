package calc.tokenizer;

import calc.tokenizer.token.*;
import java.util.ArrayList;
import java.lang.StringBuilder;

public class Tokenizer {
    String input;

    ArrayList<TokenType> tokens;

    public Tokenizer(String input) {
      this.input = input;
      tokens = new ArrayList<TokenType>();
    }

    public ArrayList<TokenType> get() {
      TokenType token;
      String candidate;
      StringBuilder builder = new StringBuilder();
      OperatorType currentOperator;

      boolean isOperator = false;

      for(int i=0; i < input.length(); i++) {
          char c = input.charAt(i);
          if (c == ' ')
              continue;
          isOperator = (c == '+') || (c == '-') || (c == '/') || (c == '*');
          if (!isOperator) {
            builder.append(c);
          } else {
            // push current string to token
            token = builderToToken(builder);
            tokens.add(token);
            builder = new StringBuilder();

            // push currrent operator to token
            currentOperator = operatorToken(c);
            tokens.add(currentOperator);
          }
      }
      token = builderToToken(builder);
      tokens.add(token);

      return tokens;
    }

    private TokenType builderToToken(StringBuilder builder)
    {
      TokenType token = null;

      if (builder.length() > 0) {
        String candidate = builder.toString();
        // token = new StringToken(candidate);
        token = numberToken(candidate);
      }
      return token;
    }

    private NumberType numberToken(String s) {
      NumberType n = null;
      try {
          Integer i = Integer.valueOf(s);
          n = new IntegerType(i);
          return n;
      } catch(NumberFormatException e) {
          // System.out.println("Cannot parse '" + s + "' as Integer");
      }
      try {
          Double d = Double.valueOf(s);
          n = new DoubleType(d);
      } catch(NumberFormatException e) {
          // System.out.println("Cannot parse '" + s + "' as Double");
      }
      return n;
    }

    private OperatorType operatorToken(char c) {
      OperatorType t = null;
      switch (c) {
        case '+': t = new OperatorADD(); break;
        case '-': t = new OperatorSUB(); break;
        case '*': t = new OperatorMUL(); break;
        case '/': t = new OperatorDIV(); break;
      }
      return t;
    }
}
