package obiectiv;
import java.util.ArrayList;

public class Pitagoras
{
	public static String interpret(String inCmd,ArrayList<Property> props)
	{
		String cmd = "nd";
		String[] splited = inCmd.split(" ");
		if(splited[1].equals("+"))
		{	
			String[] splitSrc = Aurelius.interpret(splited[0],props).split(",");
			String[] splitValues = splited[2].split(",");
			if(splited[2].contains("."))
			{
				double[] srcvec = new double[splitValues.length];
				double[] invec = new double[splitValues.length];
				String result = new String();
				for(int i = 0; i<splitValues.length;i++)
				{
					srcvec[i] = Double.parseDouble(splitSrc[i]);		
					invec[i] = Double.parseDouble(splitValues[i]);
					result = result + "," + (srcvec[i]+invec[i]);
				}
				Aurelius.interpret((splited[0] + " " + result),props);
			}
			else
			{
				int[] srcvec = new int[splitValues.length];
				int[] invec = new int[splitValues.length];
				String result = new String();
				for(int i = 0; i<splitValues.length;i++)
				{
					srcvec[i] = Integer.parseInt(splitSrc[i]);		
					invec[i] = Integer.parseInt(splitValues[i]);
					result = result + "," + (srcvec[i]+invec[i]);
				}
				Aurelius.interpret((splited[0] + " " + result),props);	
			}
		}
		else if(splited[1].equals("-"))
		{	
			String[] splitSrc = Aurelius.interpret(splited[0],props).split(",");
			String[] splitValues = splited[2].split(",");
			if(splited[2].contains("."))
			{
				double[] srcvec = new double[splitValues.length];
				double[] invec = new double[splitValues.length];
				String result = new String();
				for(int i = 0; i<splitValues.length;i++)
				{
					srcvec[i] = Double.parseDouble(splitSrc[i]);		
					invec[i] = Double.parseDouble(splitValues[i]);
					result = result + "," + (srcvec[i]-invec[i]);
				}
				Aurelius.interpret((splited[0] + " " + result),props);
			}
			else
			{
				int[] srcvec = new int[splitValues.length];
				int[] invec = new int[splitValues.length];
				String result = new String();
				for(int i = 0; i<splitValues.length;i++)
				{
					srcvec[i] = Integer.parseInt(splitSrc[i]);		
					invec[i] = Integer.parseInt(splitValues[i]);
					result = result + "," + (srcvec[i]-invec[i]);
				}
				Aurelius.interpret((splited[0] + " " + result),props);	
			}
		}
		else if(splited[1].equals("/"))
		{	
			String[] splitSrc = Aurelius.interpret(splited[0],props).split(",");
			String[] splitValues = splited[2].split(",");
			if(splited[2].contains("."))
			{
				double[] srcvec = new double[splitValues.length];
				double[] invec = new double[splitValues.length];
				String result = new String();
				for(int i = 0; i<splitValues.length;i++)
				{
					srcvec[i] = Double.parseDouble(splitSrc[i]);		
					invec[i] = Double.parseDouble(splitValues[i]);
					result = result + "," + (srcvec[i]/invec[i]);
				}
				Aurelius.interpret((splited[0] + " " + result),props);
			}
			else
			{
				int[] srcvec = new int[splitValues.length];
				int[] invec = new int[splitValues.length];
				String result = new String();
				for(int i = 0; i<splitValues.length;i++)
				{
					srcvec[i] = Integer.parseInt(splitSrc[i]);		
					invec[i] = Integer.parseInt(splitValues[i]);
					result = result + "," + (srcvec[i]/invec[i]);
				}
				Aurelius.interpret((splited[0] + " " + result),props);	
			}
		}
		else if(splited[1].equals("*"))
		{	
			String[] splitSrc = Aurelius.interpret(splited[0],props).split(",");
			String[] splitValues = splited[2].split(",");
			if(splited[2].contains("."))
			{
				double[] srcvec = new double[splitValues.length];
				double[] invec = new double[splitValues.length];
				String result = new String();
				for(int i = 0; i<splitValues.length;i++)
				{
					srcvec[i] = Double.parseDouble(splitSrc[i]);		
					invec[i] = Double.parseDouble(splitValues[i]);
					result = result + "," + (srcvec[i]*invec[i]);
				}
				Aurelius.interpret((splited[0] + " " + result),props);
			}
			else
			{
				int[] srcvec = new int[splitValues.length];
				int[] invec = new int[splitValues.length];
				String result = new String();
				for(int i = 0; i<splitValues.length;i++)
				{
					srcvec[i] = Integer.parseInt(splitSrc[i]);		
					invec[i] = Integer.parseInt(splitValues[i]);
					result = result + "," + (srcvec[i]*invec[i]);
				}
				Aurelius.interpret((splited[0] + " " + result),props);	
			}
		}
		else if(splited[1].equals("%"))
		{	
			String[] splitSrc = Aurelius.interpret(splited[0],props).split(",");
			String[] splitValues = splited[2].split(",");
			if(splited[2].contains("."))
			{
				double[] srcvec = new double[splitValues.length];
				double[] invec = new double[splitValues.length];
				String result = new String();
				for(int i = 0; i<splitValues.length;i++)
				{
					srcvec[i] = Double.parseDouble(splitSrc[i]);		
					invec[i] = Double.parseDouble(splitValues[i]);
					result = result + "," + (srcvec[i]%invec[i]);
				}
				Aurelius.interpret((splited[0] + " " + result),props);
			}
			else
			{
				int[] srcvec = new int[splitValues.length];
				int[] invec = new int[splitValues.length];
				String result = new String();
				for(int i = 0; i<splitValues.length;i++)
				{
					srcvec[i] = Integer.parseInt(splitSrc[i]);		
					invec[i] = Integer.parseInt(splitValues[i]);
					result = result + "," + (srcvec[i]%invec[i]);
				}
				Aurelius.interpret((splited[0] + " " + result),props);	
			}
		}
		return cmd;
	}
}
