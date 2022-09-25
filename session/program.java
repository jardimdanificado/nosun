package session;
import java.util.Scanner;
import World.*;

public class program
{
	public class iMax
	{
		public int obj = 64;
		public iMax(int maxObj)
		{
			this.obj = maxObj;
		}
	}
	protected World world = new World();

	public boolean exit = false;
	public iMax max = new iMax(64);
	public Scanner scan = new Scanner(System.in);
	
	protected Aurelio a = new Aurelio();

	protected void interpreter(String[] in)
	{
		for(int i = 0; i<in.length;i++)
		{
			String[] lmd = in[i].split(" ");
			switch(lmd[0])
			{
				case "mv":
				{
					switch(lmd[1])
					{
						case "mvn":
						{
							world.creature.human[0].position.y++;
						}
						break;
						case "mvs":
						{
							world.creature.human[0].position.y--;
						}
						break;
						case "mvw":
						{
							world.creature.human[0].position.x++;
						}
						break;
						case "mve":
						{
							world.creature.human[0].position.x--;
						}
						break;
					}
				}
				break;
			}
		}
	}
	
	public void run()
	{
		interpreter(a.abstracter(scan.nextLine().split("//+s")).split("&"));
	}
}
