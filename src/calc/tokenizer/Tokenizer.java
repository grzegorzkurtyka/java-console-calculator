package calc.tokenizer;

import calc.tokenizer.token.*;
import calc.tokenizer.token.type.*;
import java.util.ArrayList;
import java.lang.StringBuilder;

public class Tokenizer {
    String input;

    ArrayList<TokenType> tokens;

    public Tokenizer(String input) {
      this.input = input;
      tokens = new ArrayList<TokenType>();
    }

    public ArrayList<TokenType> get() throws Exception
    {
      TokenType token;
      String candidate;
      StringBuilder builder = new StringBuilder();
      OperatorType currentOperator;

      boolean isOperator = false, isParen = false;

      for(int i=0; i < input.length(); i++) {
          char c = input.charAt(i);
          isOperator = (c == '+') || (c == '-') || (c == '/') || (c == '*');
          isParen = (c == '(') || (c == ')');

          if (c == ' ')
            continue;

          if (!isOperator && !isParen) {
            builder.append(c);
            continue;
          } else {
             // push current string to token
             token = builderToToken(builder);
             if (token != null) {
               tokens.add(token);
               builder = new StringBuilder();
             }

             // push currrent operator to token
             currentOperator = operatorToken(c);
             if (currentOperator != null) {
                tokens.add(currentOperator);
             }
           }

          if (c == '(') {
            tokens.add(new ParenOpenToken());
            continue;
          }
          if (c == ')') {
            tokens.add(new ParenCloseToken());
            continue;
          }


      }
      token = builderToToken(builder);
      if (token != null) {
        tokens.add(token);
      }

      return tokens;
    }

    private TokenType builderToToken(StringBuilder builder) throws Exception
    {
      TokenType token = null;

      if (builder.length() > 0) {
        String candidate = builder.toString();
        // token = new StringToken(candidate);
        token = numberToken(candidate);
      }
      return token;
    }

    private NumberType numberToken(String s) throws Exception
    {
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
          return n;
      } catch(NumberFormatException e) {
          // System.out.println("Cannot parse '" + s + "' as Double");
      }
      throw new Exception("Parsing exception, unrecognized '" + s +  "'");
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
