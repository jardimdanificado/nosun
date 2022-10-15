package obiectiv;

import java.util.ArrayList;

public class PropertyList {
	public Property nd = new Property("nd","nd","nd");	
	public Property info;
	public ArrayList<Property> properties = new ArrayList<Property>();

	public Property add(Property in) {
		properties.add(in);
		return properties.get(properties.size()-1);
	}

	public String toString() {
		String outputBuffer = "";
		for (int i = 0; i < properties.size(); i++)
			outputBuffer = (outputBuffer + Property.toString(properties.get(i)) + "\n");
		return (outputBuffer);
	}

	public Property find(String name) {
		for (int i = 0; i < properties.size(); i++)
			if (properties.get(i).name.equals(name))
				return properties.get(i);
		return nd;
	}

	public static String toString(ArrayList<Property> inlist) {
		String outputBuffer = "";
		for (int i = 0; i < inlist.size(); i++)
			outputBuffer = (outputBuffer + Property.toString(inlist.get(i)) + "\n");
		return (outputBuffer);
	}

	public static PropertyList fromString(String instr) {
		String[] splited = instr.split(System.lineSeparator());
		PropertyList llist = new PropertyList(Property.fromString(splited[0]));
		for (int i = 1; i < splited.length; i++)
			llist.add(Property.fromString(splited[i]));
		return (llist);
	}

	public PropertyList(String in, String it, String iv) {
		info = new Property(in, it, iv);
	}

	public PropertyList(Property input) {
		info = input;
	}
}