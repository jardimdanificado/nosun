package Console;
import Types.*;

public class Aurelio
{
	public static String translate(String[] in)
	{
		String cmd = new String();
		for(int i = 0; i<in.length;i++)
		{
			//actions
			if(check(move,in[i])) cmd += "mv ";
			else if(check(moveTo,in[i])) cmd += "mvt ";
			else if(check(make,in[i])) cmd += "mk ";
			//operators
			else if(check(then,in[i])) cmd += "&";
			else if(check(equal,in[i])) cmd += " = ";
			//directions
			else if(check(north,in[i])) cmd += "n";
			else if(check(south,in[i])) cmd += "s";
			else if(check(west,in[i])) cmd += "w";
			else if(check(east,in[i])) cmd += "e";
			//creatures
			else if(check(human,in[i])) cmd += "h";
			//system
			else if(check(exit,in[i])) cmd += "exit";
			//else/values
			else cmd += in[i];
		}
		//cmd+="&nd";
		return(cmd);
	}
	
	private void moveTo(String[] lmd, vec3 position)//(object):(index||name) moveTo (vec3)
	{
		vec3 lvec = new vec3();
		lvec.fromString(lmd[3]);
		position = lvec;
	}

	private void move(String[] lmd, vec3 position)//(object):(index||name) move (direction)
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
			String[] objid = lmd[0].split(":");
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
