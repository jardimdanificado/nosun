package session;
import types.*;

public class Aurelio
{
	static String mv[] = {"move","mov","mv"};
	static String no[] = {"north","n"};
	static String so[] = {"south","s"};
	static String we[] = {"west","w"};
	static String ea[] = {"east","e"};
	static String and[] = {"and","&","&&","then"};
	
	protected boolean ck(String[] inWords, String target)//checker
	{
		for(int i = 0;i<inWords.length;i++)
			if(target.equals(inWords[i]))
				return true;
		return false;
	}
	
	public String abstracter(String[] in)
	{
		int start = 0;
		String lcmd = new String();
		if(ck(mv,in[0]))
			if(ck(no,in[1]))
			{
				lcmd="mvn";
			}
			else if(ck(so,in[1]))
			{
				lcmd="mvs";
			}
			else if(ck(we,in[1]))
			{
				lcmd="mvw";
			}
			else if(ck(ea,in[1]))
			{
				lcmd="mve";
			}
		lcmd+="&nd";
		return(lcmd);
	}
}
