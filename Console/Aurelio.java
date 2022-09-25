package Console;
import Types.*;
import World.World;

public class Aurelio
{
	private Lang l = new Lang();
	private World world;
	public Aurelio(World inW)
	{
		world = inW;
	}

	private void doMove(String d, int index)
	{
		switch(d)
		{
			case "n":
			{
				world.creature.human[index].position.y++;
			}
			break;
			case "s":
			{
				world.creature.human[index].position.y--;
			}
			break;
			case "w":
			{
				world.creature.human[index].position.x++;
			}
			break;
			case "e":
			{
				world.creature.human[index].position.x--;
			}
			break;
		}
	}
	
	private void move(String[] lmd)
	{
		int localV = Integer.parseInt(lmd[2]);
		
		if(!(localV != localV))//if true it is NaN
			doMove(lmd[1],localV);
		else
			for(int k = 0;k<64;k++)
				if(world.creature.human[k].name == lmd[2])
					doMove(lmd[1],localV);
	}

	public boolean interpreter(String[] in)
	{
		for(int i = 0; i<in.length;i++)
		{
			String[] lmd = l.translate(in).split(" ");
			switch(lmd[0])
			{
				case "mv":
				{
					move(lmd);
				}
				break;
				case "exit":
				{
					return true;
				}
			}
		}
		return(false);
	}
}
