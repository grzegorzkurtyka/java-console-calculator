package calc;

import calc.parsers.*;
import calc.tokenizer.*;
import calc.tokenizer.token.type.TokenType;

import java.util.ArrayList;
import java.util.Stack;

class Calculator {

    public static void main(String[] args) throws Exception {
        String input;
        ParserInterface parser;
        if (args.length > 0) {
            parser = new CmdLineParser(args);
        } else {
            parser = new InteractiveParser();
        }

        input = parser.getInput();
        System.out.println("input = " + input);

        if (input.isEmpty()) {
            System.out.println("Input missing");
            return;
        }

        try {
            Tokenizer tokenizer = new Tokenizer(input);
            ArrayList<TokenType> tokens = tokenizer.get();

            System.out.println("tokens = " + tokens);

            ShuntingYard sy = new ShuntingYard(tokens);
            Stack<TokenType> rpn = sy.rpn();
            System.out.println("rpn = " + rpn);

            RPNEvaluator r = new RPNEvaluator(rpn);

            Number result = r.evaluate();
            System.out.println("result = " + result);
        } catch (Exception e) {
            System.out.println(e);
            throw e;
        }
    }
}
