package calc.parsers;

public class CmdLineParser implements ParserInterface
{
   String input;
   public CmdLineParser(String[] args){
      input = args[0];
   }

    public String getInput() {
      return input;
    }
}
