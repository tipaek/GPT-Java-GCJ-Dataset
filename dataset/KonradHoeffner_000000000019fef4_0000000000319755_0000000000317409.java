

import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

public class Solution
{
	
	static String solve()
	{
		return "";
	}

	//static int manhattan(x1,y1,x2,y2) {return Math.abs(x2-x1)+Math.abs(y2-y1);}
	
	public static void main(String[] args) throws IOException
	{	
		try(Scanner in = new Scanner(System.in))
		{
			PrintStream out = System.out; 
			{
				int T = in.nextInt();
				outer:
				for(int t=1;t<=T;t++)
				{					
					int X = in.nextInt(); // Peppurr start X									
					int Y = in.nextInt(); // Peppurr start Y
					String M = in.nextLine();
					
					for(int i=0;i<M.length();i++)
					{
						switch(M.charAt(i))
						{
							case 'N': Y++;break;
							case 'S': Y--;break;
							case 'E': X++;break;
							case 'W': X--;break;							
						}
						
						int dist = Math.abs(X)+Math.abs(Y); 
						if(dist<=i)
						{
							out.println("Case #"+t+": "+i);
							//System.err.println("Met at point "+X+" "+Y);
							continue outer;
						}
					}
					out.println("Case #"+t+": IMPOSSIBLE");
				}
			}
		}
	}
}