package obiectiv;
import java.util.ArrayList;

public class Aurelius
{
	public static String interpret(String str, ArrayList<Property> props)
	{
		String cmd = "nd";
		if(str.contains("exit"))
			return "exit";
		else if(str.contains("$"))
		{
			String[] splited = str.split(" ");
			for(int i =2;i<splited.length;i++)
				splited[1] += (" " + splited[i]);
			for(int i = 0; i< props.size();i++)
			{
				if(props.get(i).name.equals(splited[0]))
				{
					String[] func = splited[1].split("$");					
					if(func[0].equals("pitagoras"))
					{
						func[1].replace("in",splited[2]);
						func[1].replace("out",splited[3]);
						Pitagoras.interpret(func[1],props);
					}
				}
			}
			Property lprop = new Property(splited[0],splited[1]);
			props.add(lprop);
		}
		else if(str.contains("delete"))
		{
			String[] splited = str.split(" ");
			for(int i = 0;i< props.size();i++)
				if(props.get(i).name.equals(splited[0]))
					props.remove(i);
		}
		else if(!str.contains(" "))
		{
			for(int i = 0; i< props.size(); i++)
				if(str.equals(props.get(i).name))
					return(props.get(i).value);
		}
		else
		{
			String[] splited = str.split(" ");
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
