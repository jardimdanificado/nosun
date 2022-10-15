package obiectiv;

import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class PropertyListManager 
{
	public class Script 
	{
		public void read(String filepath) throws IOException 
		{
			Path fileName = Path.of(filepath);
			String[] text = Files.readString(fileName).replace(System.lineSeparator(),"").split("#!");
			int startPoint = 1;
			for(int i = 0;i < text[0].length();i++)
				if(Character.isLetterOrDigit(text[0].charAt(i)))
				{
					startPoint = 0;
					break;
				}
			for(int i = startPoint; i< text.length; i++)
			{
				String[] splited = text[i].split(";");
				
				PropertyList list = PropertyList.fromString(splited[0]);
				for (int k = 1; k < splited.length; k++)
				{
					list.add(Property.fromString(splited[k]));
				}
				lists.add(list);
			}
		}

		public void write(String filepath, String name) 
		{
			String[] splited = name.split(",");
			
			try (PrintWriter out = new PrintWriter(filepath);) 
			{
				for(int i = 0;i< splited.length;i++)
				{
					PropertyList localist = find(splited[i]);
					out.println("#!" + localist.info.name + " " + localist.info.type + " = " + localist.info.value + ";");
					for (int k = 0; k < localist.properties.size(); k++)
						out.println(Property.toString(localist.properties.get(k)));
				}			
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	}

	public PropertyList add(PropertyList input) 
	{
		lists.add(input);
		return find(input.info.name);
	}

	public PropertyList find(String str) 
	{
		for (int i = 1; i < lists.size(); i++)
			if (lists.get(i).info.name.equals(str))
				return lists.get(i);
		return lists.get(0);
	}

	public ArrayList<PropertyList> lists = new ArrayList<PropertyList>();
	public Script script = new Script();

	public PropertyListManager() 
	{
		lists.add(new PropertyList("nd", "nd", "nd"));
		lists.get(0).properties.add(new Property("nd", "nd", "nd"));
	}
}