package calc.tokenizer;

import calc.tokenizer.token.*;
import calc.tokenizer.token.type.TokenType;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TokenizerTest {
    @Test
    void whiteSpacesAreIgnored() {
        Tokenizer t1, t2;

        t1 = new Tokenizer("1 + 1");
        t2 = new Tokenizer("1+1");
        try {
            assertArrayEquals(t1.get().toArray(), t2.get().toArray());
        } catch (Exception e) {
            fail("Exception thrown from Tokenizer");
        }

        t1 = new Tokenizer("(1+1*2/3^4)");
        t2 = new Tokenizer(" ( 1 +        1 * 2 / 3^4         )     ");
        try {
            assertArrayEquals(t1.get().toArray(), t2.get().toArray());
        } catch (Exception e) {
            fail("Exception thrown from Tokenizer");
        }
    }

    @Test
    void basicAddingOperation() {
        Tokenizer t = new Tokenizer("1+2");
        ArrayList<TokenType> expected = new ArrayList<>();
        expected.add(new IntegerType(1));
        expected.add(new OperatorADD());
        expected.add(new IntegerType(2));
        try {
            assertArrayEquals(expected.toArray(), t.get().toArray());
        } catch (Exception e) {
            fail("Exception thrown from Tokenizer");
        }
    }

    @Test
    void recognizeOperators() {
        Tokenizer t = new Tokenizer("+-*/^");
        ArrayList<TokenType> expected = new ArrayList<>();
        expected.add(new OperatorADD());
        expected.add(new OperatorSUB());
        expected.add(new OperatorMUL());
        expected.add(new OperatorDIV());
        expected.add(new OperatorPOW());
        try {
            assertArrayEquals(expected.toArray(), t.get().toArray());
        } catch (Exception e) {
            fail("Exception thrown from Tokenizer");
        }
    }

    @Test
    void recognizeNumbers() {
        Tokenizer t = new Tokenizer("10 + 10000 + 0.3");
        try {
            ArrayList<TokenType> tokens = t.get();
            assertEquals(new IntegerType(10), tokens.get(0));
            assertEquals(new IntegerType(10000), tokens.get(2));
            assertEquals(new DoubleType(0.3), tokens.get(4));
        } catch (IndexOutOfBoundsException e) {
            fail("Wrong number of tokens");
        } catch (Exception e) {
            fail("Exception thrown from Tokenizer");
        }

    }

}
