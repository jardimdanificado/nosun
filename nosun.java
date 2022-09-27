//Scripting Objective Lib
import Sol.Constants;
import Sol.Story.World.Helium;

class nosun
{
    public static void main(String[] args) 
    {
    	Helium world = new Helium(Constants.Max.Objects);
		while(world.exit == false)
        {
        	System.out.println("o sol apagou, oque vc vai fazer?");
        }
    }
}
