package obiectiv;
import java.util.ArrayList;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;

public class Pitagoras
{
	private class parentese
	{
		int inicio,fim;
		parentese(int in, int fi)
		{
			inicio = in;
			fim = fi;
		}
	}
	public static String interpret(String inCmd,ArrayList<Property> props)
	{
		String cmd = "";
		String[] splited = inCmd.split(" ");
		String[] valores = splited[2].split(",");
		
		if(splited[1].contains("+"))
		{
			
		}
		return cmd;
	}
}
