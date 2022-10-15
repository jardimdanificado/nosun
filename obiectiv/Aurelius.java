package obiectiv;

public class Aurelius 
{
	private class Format 
	{
		class Print 
		{
			static String system(String str) 
			{
				return ("print.system->" + str);
			}
		}
	}

	public static String interpret(String str, PropertyList list) 
	{
		String cmd = "0";
		String[] splited = str.split("\\s+");
		if (splited.length == 1) 
		{
			str = str.replace("\\s+", "");
			if (!str.contains("(")) 
			{
				Property found = list.find(str);
				if (found.name == "nd")
					return "404";
				else
					return (Format.Print.system(found.value));
			}
		}
		else if (str.contains("=")) 
		{
			Property found;
			if (splited[2].equals("=")) 
			{
				Property input = Property.fromString(str);
				found = list.find(input.name);

				if(input.type.equals("eval") || input.type.equals("evaluate"))
				{
					input.value = Pitagoras.eval(input.value) + "";
					input.type = "double";
				}
					
				if (found.name.equals("nd"))
					list.add(input);
				else
					found = input;
			} 
			else if (splited.length >= 3)
				if (splited[1].equals("=")) 
				{
					found = list.find(splited[0]);
					found.value = str.replace("\\s+","").substring(str.indexOf("=")+1,str.replace("\\s+","").length());
					if (found.name.equals("nd"))
						return (Format.Print.system("\"" + splited[0] + "\" doesn't exist."));
					
				} 
				else
					return (Format.Print.system("couldn't understand this command."));
		} 
		else if (splited[0].equals("eval")) 
		{
			Property found = list.find(splited[1]);
			if (found.name != "nd") 
			{
				found.value = Pitagoras.eval(found.value) + "";
			}
		}
		return cmd;
	}
}
