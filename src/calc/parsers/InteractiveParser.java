package calc.parsers;

public class InteractiveParser implements ParserInterface {
  public InteractiveParser() {

  }

  public String getInput() {
    String input = System.console().readLine();
    return input;
  }
}
