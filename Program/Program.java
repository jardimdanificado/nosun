package Program;

import java.util.Scanner;

import World.World;

import Console.Aurelio;
import Console.Dora;

public class Program
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
	
	protected Aurelio a = new Aurelio(world);
	
	public void run()
	{
		exit = a.interpreter(scan.nextLine().split(" "));
	}
}
