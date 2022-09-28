package Sol;

public class Primitives
{
	public static class Vector4
	{
		public int x = 0;
		public int y = 0;
		public int z = 0;
		public int w = 0;
		public static String Vector4(Primitives.Vector4 in){return((in.x + "," + in.y + "," + in.z + "," + in.w));}
		public static String Fold(int[] in){return((in[0] + "," + in[1] + "," + in[2] + "," + in[3]));}
		public static String Fold(int in0,int in1, int in2, int in3){return((in0 + "," + in1 + "," + in2 + "," + in3));}
		public static Primitives.Vector4 Vector4(String in)
		{
			String[] lstr = in.split(",");
			Primitives.Vector4 lvec = new Primitives.Vector4(Integer.parseInt(lstr[0]),Integer.parseInt(lstr[1]),Integer.parseInt(lstr[2]),Integer.parseInt(lstr[3]));
			return(lvec);
		}
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
		public static String Fold(Primitives.Vector3 in){return((in.x + "," + in.y + "," + in.z));}
		public static String Fold(int[] in){return((in[0] + "," + in[1] + "," + in[2]));}
		public static String Fold(int in0,int in1, int in2){return((in0 + "," + in1 + "," + in2));}
		public static Primitives.Vector3 Unfold(String in)
		{
			String[] lstr = in.split(",");
			Primitives.Vector3 lvec = new Primitives.Vector3(Integer.parseInt(lstr[0]),Integer.parseInt(lstr[1]),Integer.parseInt(lstr[2]));
			return(lvec);
		}
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
		public static String Fold(Primitives.Vector2 in){return((in.x + "," + in.y));}
		public static String Fold(int[] in){return((in[0] + "," + in[1]));}
		public static String Fold(int in0,int in1){return((in0 + "," + in1));}
		public static Primitives.Vector2 Unfold(String in)
		{
			String[] lstr = in.split(",");
			Primitives.Vector2 lvec = new Primitives.Vector2(Integer.parseInt(lstr[0]),Integer.parseInt(lstr[1]));
			return(lvec);
		}
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
			public static String Fold(Primitives.Object.Property in){return((in.value + "," + in.type + "," + in.value));}
			public static String Fold(String[] in){return((in[0] + "," + in[1] + "," + in[2]));}
			public static String Fold(String in0,String in1,String in2){return((in0 + "," + in1 + "," + in2));}
			public static Primitives.Object.Property Unfold(String in)
			{
				String[] lstr = in.split(",");
				Primitives.Object.Property lvec = new Primitives.Object.Property(lstr[0],lstr[1],lstr[2]);
				return(lvec);
			}
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
			public Default(String inFo,String sizevec3)
			{
				Primitives.Object.Property info = Primitives.Object.Property.Unfold(inFo);
				name = info.name;
				type = info.type;
				value = info.value;
				Primitives.Vector3 lvec3 = Primitives.Vector3.Unfold(sizevec3);
				property = new Object.Property[lvec3.x];
				attribute = new Object.Property[lvec3.y];
				container = new Object.Generic[lvec3.z];
			}
		}
	}
}
