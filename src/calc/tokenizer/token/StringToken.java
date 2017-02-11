package calc.tokenizer.token;

import calc.tokenizer.token.TokenType;

public class StringToken implements TokenType {

  String value;

  public StringToken(String i) {
    this.value = i;
  }

  public String toString() {
    return "'" + value + "'";
  }

}
