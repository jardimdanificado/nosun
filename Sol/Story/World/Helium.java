package Sol.Story.World;
import Sol.Primitives;
import java.util.Scanner;

public class Helium
{
	//system basics
	private Primitives.Vector4 sizes = new Primitives.Vector4(0);//geral, properties size, attributes size, containers size
	private Scanner scan = new Scanner(System.in);
	public boolean exit = false;

	private Primitives.Object.Default[] obj;

	//Helium object functions
	public void newobj(String inFo,String inVec)
	{
		String[] info = inFo.split(",");
		Primitives.Vector3 lvec = Primitives.Vector3.Unfold(inVec);
		for(int i = 0; i< obj.length;i++)
			if(obj[i].name.equals("nada"))
			{
				obj[i] = new Primitives.Object.Default(inFo,inVec);
				sizes.y = lvec.x;
				sizes.z = lvec.y;
				sizes.w = lvec.z;
				break;
			}
	}

	public void delobj(String objName)
	{
		for(int i = 0; i< obj.length;i++)
			if(obj[i].name.equals(objName))
			{
				obj[i] = new Primitives.Object.Default(Primitives.Object.Property.Fold("nada","any","nada"),Primitives.Vector3.Fold(sizes.y,sizes.z,sizes.w));
				break;
			}
	}
	public void property(String objName, Primitives.Object.Property info)
	{
		int tempIndex = -1;
		for(int i = 0; i< obj.length;i++)
			if(obj[i].name.equals(objName))
			{
				for(int k = 0; k< obj.length;k++)
				{
					if(obj[i].property[k].name.equals(info.name))
					{
						obj[i].property[k] = new Primitives.Object.Property(info.name,info.type,info.value);
						break;
					}
					else if(tempIndex ==-1)
						if(obj[i].property[k].name.equals("nada"))
							tempIndex = k;
					else if(k == obj.length)
						obj[i].property[tempIndex] = new Primitives.Object.Property(info.name,info.type,info.value);
				}
				break;
			}
	}
	public void property(String objName, String name, String type,String value)
	{
		int tempIndex = -1;
		for(int i = 0; i< obj.length;i++)
			if(obj[i].name.equals(objName))
			{
				for(int k = 0; k< obj.length;k++)
				{
					if(obj[i].property[k].name.equals(name))
					{
						obj[i].property[k] = new Primitives.Object.Property(name,type,value);
						break;
					}
					else if(tempIndex ==-1)
						if(obj[i].property[k].name.equals("nada"))
							tempIndex = k;
					else if(k == obj.length)
						obj[i].property[tempIndex] = new Primitives.Object.Property(name,type,value);
				}
				break;
			}
	}

	private static String Vocabulary[][] = 
	{
		//acts
		{"mk","make","new"},
		{"mv","move","mov"},
		{"mvt","moveto","movto","movt"},
		{"human"}
	};

	private String simplify(String input)
	{
		for(int i = 0; i<Vocabulary.length;i++)
			for(int k = 1; k<Vocabulary[i].length;k++)
				input = input.replaceAll(Vocabulary[i][k],(Vocabulary[i][0]+" "));
		return input;
	}

	public String interpret(String in)
	{
		String cmd = "nd";
		String[] preprocess = simplify(in).split("&");
		for(int i = 0; i < preprocess.length;i++)
		{
			String[] buffer = preprocess[i].split("\\s+");
			String[] refid = buffer[0].split(":");
			if(buffer[1].equals("mk"))
			{
				switch(buffer.length)
				{
					case 2://(type:indentifier) mk 
					{
						newobj((refid[1] + "," + refid[0] + ",nada"), sizes.y  + "," + sizes.z  + "," + sizes.w);
					}
					break;
					case 3://(type:indentifier) mk (value)
					{
						newobj((refid[1] + "," + refid[0] + "," + buffer[2]), sizes.y  + "," + sizes.z  + "," + sizes.w);
					}
					break;
					case 4://(type:indentifier) mk (value) (size)
					{
						newobj((refid[1] + "," + refid[0] + "," + buffer[3]), sizes.y  + "," + sizes.z  + "," + sizes.w);
					}
					break;
					case 7://(type:indentifier) mk (value)
					{
						newobj((refid[1] + "," + refid[0] + "," + buffer[2]), sizes.y  + "," + sizes.z  + "," + sizes.w);
					}
					break;
				}
			}
		}
		return cmd;
	}
	
	//helium constructor
	public Helium(int size)
	{
		obj = new Primitives.Object.Default[size];
		sizes = new Primitives.Vector4(size);
	}
}
