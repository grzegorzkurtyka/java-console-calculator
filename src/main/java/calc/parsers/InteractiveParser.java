package calc.parsers;

import java.io.Console;
import java.util.Optional;

public class InteractiveParser implements ParserInterface {

    public InteractiveParser() {
    }

    public String getInput() {
        Optional<Console> console = Optional.ofNullable(System.console());
        String input = console.map(Console::readLine).orElse("");
        return input;
    }
}
