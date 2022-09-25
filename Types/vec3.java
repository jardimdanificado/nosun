package Types;

public class vec3
{
	public int x = 0;
	public int y = 0;
	public int z = 0;
	public void vec3(int inX, int inY, int inZ)
	{
		x = inX;
		y = inY;
		z = inZ;
	}
	public void fromString(String in)
	{
		String[] lstr = in.split(",");
		if(lstr.length !=3) lstr = in.split("x");
		x = Integer.parseInt(lstr[0]);
		y = Integer.parseInt(lstr[1]);
		z = Integer.parseInt(lstr[2]);
	}
}
