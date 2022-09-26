import java.util.Scanner;

//O.EST, acronym for "OBJECTIVE ENVIRONMENT SIMULATOR TERMINAL"
//formely package Est
//Objective.EST is a multi-console object-oriented sandbox simulation environment written in java meant to be used with JVM or compiled with GCJ(althought not recommended due to its BIG performance cost, JVM is the better option in most cases).
//its designed as a "Console Adventure Playground" with 2 default consoles
//a console(which we can separate in two types StoryTeller(Server-Side) and Actor(Client-Side)) is basically a Class file capable of modify the Est.World from String inputs. 
//Therefore the implemetation is totally up to you, yet, there are 2 examples included in Est.Console: Aurelio and Dora.
//Aurelio is a "StoryTeller", a Server-Console, basically a superuser
//Dora, unlike Aurelio, is a invited user, an "Actor", a user without any previleges beside reading, it cannot modify anything except itself, all other events are handled by the Server-Console,
import Est.World;

class nosun
{
    public static void main(String[] args) 
    {
    	boolean exit = false;
    	World world = new World();
		while(exit == false)
        {
        	System.out.println("o sol apagou, oque vc vai fazer?");
        }
    }
}
