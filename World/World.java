package World;
import Types.*;

public class World
{
	public class Human
	{
		public class Body
		{
			public class bodypart
			{
				double hp = 100;
				double resistance = 0;
				String status = "saudavel";
			}
			public bodypart cabeca = new bodypart();
			public bodypart torso = new bodypart();
			public bodypart braco[] = new bodypart[2];
			public bodypart mao[] = new bodypart[2];
			public bodypart perna[] = new bodypart[2];
			public bodypart pe[] = new bodypart[2];
			public Body()
			{
				for(int i = 0;i<2;i++)
				{
					braco[i] = new bodypart();
					mao[i] = new bodypart();
					perna[i] = new bodypart();
					pe[i] = new bodypart();
				}
			}
		}
		public String name = "ninguem";
		public String status = "normal";
		public double speed = 1.0;
		public double strn = 1.0;
		public double intel = 1.0;
		public double dex = 1.0;
		public vec3 position = new vec3();
		Body body = new Body();
		
	}
	public class Creatures
	{
		public Human human[] = new Human[64];
	}
	public Creatures creature = new Creatures();
	public World()
	{
		for(int i = 0;i<64;i++)
			creature.human[i] = new Human();
	}
}
