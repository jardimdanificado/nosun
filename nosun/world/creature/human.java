package world.creature;
import types.*;

class bp
{
	int hp = 100;
	String status = "saudavel";
}

class HBody
{
	public bp cabeca = new bp();
	public bp torso = new bp();
	public bp braco[] = new bp[2];
	public bp mao[] = new bp[2];
	public bp perna[] = new bp[2];
	public bp pe[] = new bp[2];
}

public class human
{
	public String name = "ninguem";
	public String status = "normal";
	public double speed = 1.0;
	HBody body = new HBody();
}
