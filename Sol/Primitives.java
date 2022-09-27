package Sol;

public class Primitives
{
	public static class Vector4
	{
		public int x = 0;
		public int y = 0;
		public int z = 0;
		public int w = 0;
		public Vector4(int inX, int inY, int inZ, int inW)
		{
			x = inX;
			y = inY;
			z = inZ;
			w = inW;
		}
		public Vector4(String in)
		{
			String[] lstr = in.split(",");
			if(lstr.length !=4) lstr = in.split("x");
			x = Integer.parseInt(lstr[0]);
			y = Integer.parseInt(lstr[1]);
			z = Integer.parseInt(lstr[2]);
			w = Integer.parseInt(lstr[3]);
		}
		public Vector4(int in)
		{
			x = in;
			y = in;
			z = in;
			w = in;
		}
	}
	public static class Vector3
	{
		public int x = 0;
		public int y = 0;
		public int z = 0;
		public Vector3(int inX, int inY, int inZ)
		{
			x = inX;
			y = inY;
			z = inZ;
		}
		public Vector3(String in)
		{
			String[] lstr = in.split(",");
			if(lstr.length !=3) lstr = in.split("x");
			x = Integer.parseInt(lstr[0]);
			y = Integer.parseInt(lstr[1]);
			z = Integer.parseInt(lstr[2]);
		}
		public Vector3(int in)
		{
			x = in;
			y = in;
			z = in;
		}
	}

	public static class Vector2
	{
		public int x = 0;
		public int y = 0;
		public Vector2(int inX, int inY)
		{
			x = inX;
			y = inY;
		}
		public Vector2(String in)
		{
			String[] lstr = in.split(",");
			if(lstr.length !=2) lstr = in.split("x");
			x = Integer.parseInt(lstr[0]);
			y = Integer.parseInt(lstr[1]);
		}
		public Vector2(int in)
		{
			x = in;
			y = in;
		}
	}

	public static class Object
	{
		public static class Property
		{
			public String name = "nada";
			public String type = "any";
			public String value = "nada";
			public Property(String inName,String inType,String inValue)
			{
				name = inName;
				type = inType;
				value = inValue;
			}
		}
		public static class Generic
		{
			public String name = "nada";
			public String type = "any";
			public String value = "nada";
			public Property[] property = new Object.Property[Constants.Max.Objects];
			public Property[] atribute = new Object.Property[Constants.Max.Objects];
			public Generic(Property info,int pSize,int aSize)
			{
				name = info.name;
				type = info.type;
				value = info.value;
				property = new Object.Property[pSize];
				atribute = new Object.Property[aSize];
			}
		}
		public static class Default
		{
			public String name = "nada";
			public String type = "any";
			public String value = "nada";
			public Property[] property = new Object.Property[Constants.Max.Objects];
			public Property[] attribute = new Object.Property[Constants.Max.Objects];
			public Generic[] container = new Object.Generic[Constants.Max.Objects];
			public Default(Property info,int pSize,int aSize,int cSize)
			{
				name = info.name;
				type = info.type;
				value = info.value;
				property = new Object.Property[pSize];
				attribute = new Object.Property[aSize];
				container = new Object.Generic[cSize];
			}
		}
	}
}
