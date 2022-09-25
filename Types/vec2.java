package Types;

public class vec2
{
	public int x = 0;
	public int y = 0;
	public vec2(int inX, int inY)
	{
		x = inX;
		y = inY;
	}
	public void fromString(String in)
	{
		String[] lstr = in.split(",");
		if(lstr.length !=2) lstr = in.split("x");
		x = Integer.parseInt(lstr[0]);
		y = Integer.parseInt(lstr[1]);
	}
}
