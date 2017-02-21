package calc.tokenizer.token;

import calc.tokenizer.token.type.ParenType;

public class ParenOpenToken extends BaseToken implements ParenType {

    public ParenOpenToken() {
        this.value = "(";
    }
}
