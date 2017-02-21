package calc;

import calc.tokenizer.token.IntegerType;
import calc.tokenizer.token.OperatorADD;
import calc.tokenizer.token.type.TokenType;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class ShuntingYardTest {

    @Test
    void simpleAdder() {
        ArrayList<TokenType> input = new ArrayList<>();
        input.add(new IntegerType(1));
        input.add(new OperatorADD());
        input.add(new IntegerType(2));

        Stack<TokenType> expected = new Stack<>();
        expected.push(new IntegerType(1));
        expected.push(new IntegerType(2));
        expected.push(new OperatorADD());

        ShuntingYard sy = new ShuntingYard(input);
        try {
            Stack<TokenType> rpn = sy.rpn();
            assertArrayEquals(expected.toArray(), rpn.toArray());
        } catch (Exception e) {
            fail("ShuntingYard throwed exception");
        }
    }
}
