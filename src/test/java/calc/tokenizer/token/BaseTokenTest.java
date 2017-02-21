package calc.tokenizer.token;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseTokenTest {

    @Test
    void twoIntegerTokensAreEquals() {
        IntegerType n1 = new IntegerType(10);
        IntegerType n2 = new IntegerType(10);
        assertEquals(n1, n2);
        assertFalse(n1 == n2);
        assertTrue(n1.value.intValue() == n2.value.intValue());
    }

    @Test
    void differentIntegerTokensAreNotEquals() {
        IntegerType n1 = new IntegerType(10);
        IntegerType n2 = new IntegerType(20);
        assertEquals(10, n1.value.intValue());
        assertEquals(20, n2.value.intValue());
        assertNotEquals(n1, n2);
        assertFalse(n1 == n2);
        assertFalse(n1.value.intValue() == n2.value.intValue());
    }



//    @Test
//    void toString() {
//
//    }

}
