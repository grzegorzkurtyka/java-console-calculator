package calc.tokenizer.token;

import calc.tokenizer.token.type.TokenType;

public class StringToken extends BaseToken implements TokenType {

    public StringToken(String i) {
        this.value = i;
    }

}
