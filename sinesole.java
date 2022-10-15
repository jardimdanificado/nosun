import java.util.Scanner;
import java.io.IOException;

import obiectiv.Property;
import obiectiv.PropertyList;
import obiectiv.PropertyListManager;
import obiectiv.Aurelius;

class sinesole 
{
	private class Util
	{
		class Text
		{
			static int occurrencesOf(String findStr, String str)
			{
				int lastIndex = 0;
				int count = 0;
				
				while (lastIndex != -1) 
				{
				
				    lastIndex = str.indexOf(findStr, lastIndex);
				
				    if (lastIndex != -1) {
				        count++;
				        lastIndex += findStr.length();
				    }
				}
				return(count);
			}
			static String reference(String userInput)
			{
				userInput = userInput.replace("="," = ").replace("$"," $").replace("+"," + ").replace("-"," - ").replace("/"," / ").replace("*"," * ").replace("("," ( ").replace(")"," ) ");
				String[] userSplited = userInput.split("\\s+");
				String result = "";
				if(userInput.contains("$"))
				{
					int acres = 0;
					for(int i = 0;i < userSplited.length;i++)
						if(userSplited[i].contains("$"))
						{
							Property lprop = listmanager.find("data").find(userSplited[i].replace(" ","").replace("$",""));
							if(!lprop.name.equals("nd"))
								result += lprop.value + " ";
							else
								result += userSplited[i];	
						}
						else
						{
							result += userSplited[i];
						}
				}
				return result;
			}
		}
		
	}
	
	private class Print 
	{
		static private void system(String str) 
		{
			System.out.println("$System > " + str);
		}

		static private void log(Property prop) 
		{
			System.out.println("$" + prop.name + " sent:");
			System.out.println("    " + prop.type);
			System.out.println("$" + prop.name + " received:");
			System.out.println("    " + prop.value);
		}

		static private void logList(PropertyList list) 
		{
			for (int i = 0; i < list.properties.size(); i++) 
			{
				System.out.println("--------> Log Number " + i + ":");
				Print.log(list.properties.get(i));
			}
			System.out.println("<-------- end.");
		}

		static private void property(Property prop) 
		{
			System.out.println(prop.name + "(" + prop.type + "){" + prop.value + "}");
		}

		static private void propertyList(PropertyList list) 
		{
			for (int i = 0; i < list.properties.size(); i++)
				System.out.println(list.properties.get(i).name + "(" + list.properties.get(i).type + "){" + list.properties.get(i).value + "}");
		}
	}

	static private void login() 
	{
		System.out.printf("\nuser:");
		String lusr = scan.nextLine();
		System.out.printf("\npassword:");
		String lpss = scan.nextLine();
	}

	static Aurelius aurelius = new Aurelius();
	static Scanner scan = new Scanner(System.in);

	private class Current 
	{
		static int user = 0;
	}

	private static PropertyListManager listmanager = new PropertyListManager();

	public static void main(String[] args) throws IOException 
	{
		listmanager.add(new PropertyList("data", "public", "rw"));
		listmanager.add(new PropertyList("logs", "public", "rw"));
		if(args.length == 1)
			listmanager.script.read(args[0]);
		
		String cmdOutput = "nd";
		String userInput;
		while (!cmdOutput.equals("exit")) 
		{
			System.out.printf("$%s > ", listmanager.find("users").properties.get(Current.user).name);
			userInput = scan.nextLine();
			String[] userSplited = userInput.split("\\s+");
			
			if(userSplited[0].equals("write"))
			{
				listmanager.script.write(userSplited[1],userSplited[2]);
			}
			else if (userSplited[0].equals("ls") || userSplited[0].equals("list")) 
			{
				if (userSplited.length == 1)
					for (int i = 0; i < listmanager.lists.size(); i++)
						Print.property(listmanager.lists.get(i).info);
				else if (userSplited.length >= 2)
					if (listmanager.find(userSplited[1]).properties.get(Current.user).type.replace("\\s+","").equals("root"))
						Print.propertyList(listmanager.find(userSplited[1]));
					else
					{
						if(listmanager.find(userSplited[1]).info.type.equals("system"))
							Print.system(listmanager.find("users").properties.get(Current.user).name + " is not a superuser");
						else
							Print.propertyList(listmanager.find(userSplited[1]));
					}
			}
			else if(userSplited[0].equals("exit"))
			{
				Print.system("bye");
				cmdOutput = "exit";
			}
			else if(userInput.contains("<<"))
			{
				String[] splited = userInput.replace(" ","").split("<<");
				Property found = listmanager.find("data").find(splited[0]);
				Property func = listmanager.find("data").find(splited[1]);
				String localCmd = splited[0] + " = " + func.value;				
				for(int i = 0;i < Util.Text.occurrencesOf("#",localCmd)+1;i++)
					localCmd = localCmd.replace("#" + i, splited[i+2]);
				localCmd = Util.Text.reference(localCmd);
				cmdOutput = aurelius.interpret(localCmd.replace("="," = "), listmanager.find("data"));
				cmdOutput += aurelius.interpret("eval " + splited[0] ,listmanager.find("data"));
			}
			else
			{
				cmdOutput = aurelius.interpret(userInput, listmanager.find("data"));
				if(cmdOutput.contains("print"))
				{
					String[] cmdSplited = cmdOutput.split("->");
					if(cmdSplited[0].contains("system"))
						Print.system(cmdSplited[1]);
				}
			}
			listmanager.find("logs").add(new Property(listmanager.find("users").properties.get(Current.user).name, userInput, cmdOutput));
		}
	}
}
