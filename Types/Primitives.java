package Types;

public class Primitives
{
	public class Vector3
	{
		public int x = 0;
		public int y = 0;
		public int z = 0;
		public void Vector3(int inX, int inY, int inZ)
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

	public class Vector2
	{
		public int x = 0;
		public int y = 0;
		public Vector2(int inX, int inY)
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

	public class Object
	{
		public class Property
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
		public class Generic
		{
			public String name = "nada";
			public String type = "any";
			public String value = "normal";
			public Property[] property;
			public Property[] atribute;
			public Generic(Property info,int pSize,int aSize)
			{
				name = info.name;
				type = info.type;
				value = info.value;
				property = new Object.Property[pSize];
				atribute = new Object.Property[aSize];
			}
		}
		public class Default
		{
			public String name = "nada";
			public String type = "any";
			public String value = "normal";
			public Property[] property;
			public Property[] atribute;
			public Generic[] container;
			public Default(Property info,int pSize,int aSize,int cSize)
			{
				name = info.name;
				type = info.type;
				value = info.value;
				property = new Object.Property[pSize];
				atribute = new Object.Property[aSize];
				container = new Object.Generic[cSize];
				for(int i = 0;i<pSize;i++)
					
			}
		}
	}
}
