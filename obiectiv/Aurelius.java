package obiectiv;
import java.util.ArrayList;

public class Aurelius
{
	public static String interpret(String str, ArrayList<Property> props)
	{
		String cmd = "0";
		String[] splited = str.split(" ");
		if(str.contains("exit"))
			return "exit";
		else if(str.contains(";"))
		{
			String[] func = str.split(";");
			if(func.length == 2)
				for(int i = 0; i< props.size();i++)
				{
					if(props.get(i).name.equals(func[0]))
					{
						String lstr = Aurelius.interpret(func[0],props);
						System.out.println(lstr);
						String[] savedFunc = lstr.split(";");
						String locFunc = savedFunc[1];
						if(savedFunc[0].equals("pitagoras"))
						{
							locFunc.replace("in",func[1]);
							//func[1].replace("out",splited[3]);
							Pitagoras.interpret(locFunc,props);
						}
					}
				}
			else
			{
				Property lprop = new Property(func[1],(func[0] + ";" + func[2]));
				props.add(lprop);
			}
		}
		else if(str.contains("delete"))
		{
			for(int i = 0;i< props.size();i++)
				if(props.get(i).name.equals(splited[0]))
					props.remove(i);
		}
		else if(!str.contains(" "))
		{
			for(int i = 0; i< props.size(); i++)
				if(str.equals(props.get(i).name))
				{
					System.out.println(props.get(i).value);
					return(props.get(i).value);
				}
		}
		else if(splited[1].equals("+") || splited[1].equals("-") || splited[1].equals("/") || splited[1].equals("*") || splited[1].equals("%"))
		{
			cmd = Pitagoras.interpret(str,props);
		}
		else
		{
			for(int i =0;i<props.size();i++)
				if(splited[0].equals(props.get(i).name))
				{
					props.get(i).value = splited[1];
					return(cmd);
				}
			Property lobj = new Property(splited[0],splited[1]);
			props.add(lobj);
		}
		return cmd;
	}
}
