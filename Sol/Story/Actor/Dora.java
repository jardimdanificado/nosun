package Sol.Story.World;
import Sol.Primitives.Vector3;

public class Dora
{	
	private static String Vocabulary[][] = 
	{
		//acts
		{"mk","make","new"},
		{"mv","move","mov"},
		{"mvt","moveto","movto","movt"},
		{"human"}
	};
	private void moveTo(String[] lmd, Vector3 position)//(object):(index||name) moveTo (vec3)
	{
		Vector3 lvec = new Vector3(lmd[3]);
		position = lvec;
	}

	private void move(String[] lmd, Vector3 position)//(object):(index||name) move (direction)
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

	}
}
