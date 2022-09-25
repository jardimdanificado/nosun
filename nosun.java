import Program.*;

class nosun
{
    public static void main(String[] args) 
    {
    	Program sistema = new Program();
		while(sistema.exit == false)
        {
        	System.out.println("o sol apagou, oque vc vai fazer?");
			sistema.run();
//        	sistema.exit = true;
        }
    }
}
