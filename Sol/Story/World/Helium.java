package Sol.Story.World;
import Sol.Primitives;
import java.util.Scanner;

public class Helium
{
	//system basics
	private Scanner scan = new Scanner(System.in);
	private boolean exit = false;
	private Primitives.Object.Default[] obj;
	private Primitives.Vector4 sizes = new Primitives.Vector4(0);//geral, properties size, attributes size, containers size
	
	//Helium object functions
	public void newobj(Primitives.Object.Property info,int sizep, int sizea,int sizec)
	{
		for(int i = 0; i< obj.length;i++)
			if(obj[i].name.equals("nada"))
			{
				obj[i] = new Primitives.Object.Default(info,sizep,sizea,sizec);
				sizes.y = sizep;
				sizes.z = sizea;
				sizes.w = sizec;
				break;
			}
	}
	public void newobj(Primitives.Object.Property info)
	{
		for(int i = 0; i< obj.length;i++)
			if(obj[i].name.equals("nada"))
			{
				obj[i] = new Primitives.Object.Default(info,sizes.y,sizes.z,sizes.w);
				break;
			}
	}
	public void delobj(String objName)
	{
		for(int i = 0; i< obj.length;i++)
			if(obj[i].name.equals(objName))
			{
				Primitives.Object.Property info = new Primitives.Object.Property(obj[i].name,obj[i].type,obj[i].value);
				obj[i] = new Primitives.Object.Default(info,sizes.x,sizes.y,sizes.z);
				break;
			}
	}
	
	//helium constructor
	public Helium(int size)
	{
		obj = new Primitives.Object.Default[size];
		sizes = new Primitives.Vector4(size);
	}
}
