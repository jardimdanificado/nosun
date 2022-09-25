import session.program;

class nosun
{
    public static void main(String[] args) 
    {
    	program sistema = new program();
		while(sistema.exit == false)
        {
        	System.out.println("o sol apagou, oque vc vai fazer?");
			sistema.run();
        	sistema.exit = true;
        }
    }
}
