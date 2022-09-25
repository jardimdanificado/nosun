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

	private void moveTo(String[] lmd, vec3 position)//(object) (index||name) moveTo (vec3)
	{
		vec3 lvec = new vec3();
		lvec.fromString(lmd[3]);
		position = lvec;
	}

	private void move(String[] lmd, vec3 position)//(object) (index||name) move
	{
		switch(lmd[3])
		{
			case "n":
			{
				position.y++;
			}
			break;
			case "s":
			{
				position.y--;
			}
			break;
			case "w":
			{
				position.x++;
			}
			break;
			case "e":
			{
				position.x--;
			}
			break;
		}
	}

	public boolean interpreter(String[] in)
	{
		for(int i = 0; i<in.length;i++)
		{
			String[] lmd = l.translate(in).split(" ");
			switch(lmd[0])
			{
				case "human":
				{
					//finder
					int r = Integer.parseInt(lmd[1]);
					if(r != r)//if true it is NaN
						for(int k = 0;k<64;k++)
							if(world.creature.human[k].name == lmd[1])
								r = k;
					//acts
					if(lmd[2].equals("mv")) move(lmd,world.creature.human[r].position);
					else if(lmd[2].equals("mvt")) moveTo(lmd,world.creature.human[r].position);
					else if(lmd[2].equals("del")) human[r] = new Human();
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
