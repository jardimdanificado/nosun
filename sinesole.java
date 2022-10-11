import obiectiv.Property;
import obiectiv.Aurelius;
import java.util.Scanner;
import java.util.ArrayList;

class sinesole {
	static Aurelius aurelius = new Aurelius();
	static ArrayList<Property> objects = new ArrayList<Property>();
	static ArrayList<Property> users = new ArrayList<Property>();
	static ArrayList<Property> logs = new ArrayList<Property>();

	static Scanner scan = new Scanner(System.in);

	static int currentUser = 0;

	private class Print {
		static private void system(String str) {
			System.out.printf("\n$ystem > %s", str);
		}

		static private void property(Property prop) {
			System.out.println(prop.name + "(" + prop.type + "){" + prop.value + "}");
		}

		static private void propertyList(ArrayList<Property> props) {
			for (int i = 0; i < props.size(); i++)
				System.out.println(props.get(i).name + "(" + props.get(i).type + "){" + props.get(i).value + "}");
		}
	}

	static private boolean coreUtil(String str) {
		String[] splited = str.split(" ");
		if (splited[0].equals("ls") || splited[0].equals("list")) {
			if (splited.length == 1 || splited[1].equals("all") || splited[1].equals("*"))
				Print.propertyList(objects);
			else if (splited[1].equals("log") || splited[1].equals("logs"))
				Print.propertyList(logs);
			else if (splited[1].equals("user") || splited[1].equals("users"))
				if (users.get(currentUser).type.equals("root"))
					Print.propertyList(users);
				else
					Print.system(users.get(currentUser).name + " is not a superuser");
			return true;
		}
		return false;
	}

	static private void login() {
		System.out.printf("\nuser:");
		String lusr = scan.nextLine();
		String lpss = scan.nextLine();
	}

	public static void main(String[] args) {

		String cmdOutput = "nd";
		String userInput;
		users.add(new Property("root", "root", "root"));

		while (!cmdOutput.equals("exit")) {
			System.out.printf("$%s > ", users.get(currentUser).name);
			userInput = scan.nextLine();
			if (coreUtil(userInput))
				continue;
			cmdOutput = aurelius.interpret(userInput, objects);
			logs.add(new Property(users.get(currentUser).name, userInput, cmdOutput));
		}
	}
}
