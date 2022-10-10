package obiectiv;

import java.util.ArrayList;

public class Aurelius {
	public static String interpret(String str, ArrayList<Property> props) {
		String cmd = "0";
		String[] splited = str.split(" ");
		if (str.contains("exit"))
			return "exit";
		else if (splited[0].equals("run")) {
			for (int i = 0; i < props.size(); i++)
				if (props.get(i).name.equals(splited[1]))
					if (props.get(i).type.equals("function")) {
						String lcmd = props.get(i).value + " ";
						lcmd = lcmd.replace("out", splited[2]);
						if (splited.length == 4)
							lcmd = lcmd.replace("in", splited[3]);
						System.out.println(lcmd);
						return Aurelius.interpret(lcmd, props);
					} else
						System.out.println(splited[1] + " is not a function.");
		} else if (splited[0].equals("delete")) {
			for (int i = 0; i < props.size(); i++)
				if (props.get(i).name.equals(splited[1]))
					props.remove(i);
		} else if (splited[0].equals("get")) {
			for (int i = 0; i < props.size(); i++)
				if (splited[1].equals(props.get(i).name)) {
					System.out.println(props.get(i).value);
					return (props.get(i).value);
				}
		}
		if (splited[1].equals("=")) {
			Property lobj = new Property("nd", "nd", "nd");
			for (int i = 0; i < props.size(); i++)
				if (splited[0].equals(lobj.name))
					lobj = props.get(i);
			if (lobj.name.equals("nd"))
				return "object not found";
			if (splited[2].charAt(0) == '$') {
				for (int k = 0; k < props.size(); k++)
					if (splited[2].equals("$" + props.get(k).name)) {
						lobj.value = "" + props.get(k).value;
						return (lobj.value);
					}
				return ("second object not found");
			} else if (splited[2].charAt(0) == '@') {
				for (int k = 0; k < props.size(); k++)
					if (splited[2].equals("@" + props.get(k).name)) {
						lobj.value = props.get(k).value;
						return (lobj.value);
					}
				return ("second object not found");
			} else if (splited[2].contains("{")) {
				for (int i = 0; i < props.size(); i++)
					str = str.replace(("$" + lobj.name), lobj.value);
				lobj.value = "" + Pitagoras.eval(str.substring(str.indexOf("{") + 1, str.indexOf( }")));
			}
			 else if(Character.isDigit(splited[2].charAt (0))| |splited[2].charAt(0) == '-'||spl
					it ed[2].charAt(0) == '+') {
				lobj.value = "" + Pitagoras.eval(str.substring(str.indexOf("=") + 1, str.indexOf("}")));
			} else {
				lobj.value = splited[2];
			}
		} else if (splited[0].equals("set")) {
			for (int i = 0; i < props.size(); i++)
				if (splited[1].equals(props.get(i).name)) {
					props.get(i).value = splited[2];
					return (cmd);
				}
		} else if (splited[0].equals("new")) {
			if (splited[1].equals("function")) {
				String locfunc = str.substring(str.indexOf("(") + 1, str.indexOf(")"));
				Property lobj = new Property(splited[2], splited[1], locfunc);
				props.add(lobj);
				return locfunc;
			}
			Property lobj = new Property(splited[2], splited[1], splited[3]);
			props.add(lobj);
		}
		return cmd;
	}
}
