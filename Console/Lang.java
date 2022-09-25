package Console;

public class Lang
{
	//actions
	private static String make[] = {"make","mk","create","new"};//make (creature||object||item) (id) (vector3)
	private static String move[] = {"move","mov","mv"};//move (creature||object||item) (id) (direction)
	private static String exit[] = {"exit","quit"};//exit program
	//operators
	private static String then[] = {"and","&","&&","then"};// {action} then {action}
	private static String equal[] = {"equal","=", "set"};// (property) = (value)
	//creatures 
	private static String human[] = {"human","player"};//human (index||name)
	//directions
	private static String north[] = {"north","n"};
	private static String south[] = {"south","s"};
	private static String west[] = {"west","w"};
	private static String east[] = {"east","e"};
	//etc
	private static String nada[] = {"null","void","nd","nada"};
	//checker
	private boolean check(String[] inWords, String target)//checker
	{
		for(int i = 0;i<inWords.length;i++)
			if(target.equals(inWords[i]))
				return true;
		return false;
	}

	public String translate(String[] in)
	{
		String cmd = new String();
		for(int i = 0; i<in.length;i++)
		{
			//actions
			if(check(move,in[i])) cmd += "mv ";
			else if(check(make,in[i])) cmd += "mk ";
			//operators
			else if(check(then,in[i])) cmd += "&";
			else if(check(equal,in[i])) cmd += " = ";
			//directions
			else if(check(north,in[i])) cmd += "n";
			else if(check(south,in[i])) cmd += "s";
			else if(check(west,in[i])) cmd += "w";
			else if(check(east,in[i])) cmd += "e";
			//creatures
			else if(check(human,in[i])) cmd += "h";
			//system
			else if(check(exit,in[i])) cmd += "exit";
			//else/values
			else cmd += in[i];
		}
		//cmd+="&nd";
		return(cmd);
	}
}
