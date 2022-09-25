package Console;
import Types.*;
import World.World;

public class Dora
{
	private Lang l = new Lang();
	public String abstracter(String[] in)
	{
		String cmd = new String();
		for(int i = 0; i<in.length;i++)
		{
			//actions
			if(l.check(l.move,in[i])) cmd += "mv ";
			else if(l.check(l.move,in[i])) cmd += "mk ";
			//operators
			else if(l.check(l.then,in[i])) cmd += "&";
			else if(l.check(l.equal,in[i])) cmd += " = ";
			//directions
			else if(l.check(l.north,in[i])) cmd += "n";
			else if(l.check(l.south,in[i])) cmd += "s";
			else if(l.check(l.west,in[i])) cmd += "w";
			else if(l.check(l.east,in[i])) cmd += "e";
			//creatures
			else if(l.check(l.human,in[i])) cmd += "h";
			//else/values
			else cmd += in[i];
		}
		cmd+="&nd";
		return(cmd);
	}

	public void interpreter(String[] in, World world)
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
}
