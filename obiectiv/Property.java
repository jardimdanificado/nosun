package obiectiv;

public class Property {
	public String name, value, type;

	public static String toString(Property inp) 
	{
		return (inp.type + " " + inp.name + " = " + inp.value + ";");
	}

	public static Property fromString(String instr) 
	{
		String[] splited = instr.split("\\s+");
		String lvalue = instr.substring(instr.indexOf("=")+1,instr.length());
		if(splited[0].equals("String") || splited[0].equals("string") || splited[0].equals("str"))
		{
			while(lvalue.charAt(0) == ' ')
				lvalue = lvalue.substring(1,lvalue.length());
			return (new Property(splited[1], splited[0], lvalue));
		}
		else
			return (new Property(splited[1], splited[0], lvalue.replace(" ","")));
	}
	
	public Property(String in, String it, String iv) 
	{
		name = in;
		type = it;
		value = iv;
	}
}
