import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution
{
	
	static List<String> solve(int R,int S, List<String> tmp)
	{
		if(R==1) return tmp;
		for(int i=0;i<S-1;i++)
		{
			tmp.add(R*(i+1)+" "+(R-1));
		}
		return solve(R-1,S,tmp);		
	}

	static List<String> solve(int R,int S)
	{
		return solve(R,S,new ArrayList<String>());
	}
	
	public static void main(String[] args) throws IOException
	{	
		try(Scanner in = new Scanner(System.in))
		{
			PrintStream out = System.out; 
			{
				int T = in.nextInt();
				for(int t=1;t<=T;t++)
				{					
					int R = in.nextInt(); // number of people									
					int S = in.nextInt(); // maximum index both x and y
					List<String> lines = solve(R,S);					
					out.println("Case #"+t+": "+lines.size());
					for(String line: lines) {System.out.println(line);}
				}
			}
		}
	}
}