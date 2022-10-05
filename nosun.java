import obiectiv.Property;
import obiectiv.Aurelius;
import java.util.Scanner;
import java.util.ArrayList;

class nosun
{
	public static void main(String[] args)
	{
		Aurelius ns = new Aurelius();
		Scanner scan = new Scanner(System.in);
		ArrayList<Property> props = new ArrayList<Property>();
		
		while(!ns.interpret(scan.nextLine(),props).equals("exit"))
		{}
	}
}
