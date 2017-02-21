package calc.tokenizer.token;

import calc.tokenizer.token.type.ParenType;

public class ParenCloseToken extends BaseToken implements ParenType {

    public ParenCloseToken() {
        this.value = ")";
    }
}
