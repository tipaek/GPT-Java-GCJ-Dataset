import java.util.*;
import java.io.*;

public class Solution 
{
	
	public static String findSolution(String s)
	{
		char[] charArray = s.toCharArray();
		StringBuilder sol = new StringBuilder();
		
		int lastVal = 0;
		
		for (int i=0; i<charArray.length; i++) 
		{
			char c = charArray[i];
			int val = Character.getNumericValue(c);
			int diff = val - lastVal;
			
			if (diff > 0)
			{
				for (int n=0; n<diff; n++)
				{
					sol.append("(");
				}
			}
			if (diff < 0)
			{
				for (int n=0; n<Math.abs(diff); n++)
				{
					sol.append(")");
				}
				
			}
			
			sol.append(c);
			
			
			lastVal = Character.getNumericValue(charArray[i]);
			
			
			// Last char
			if (i == charArray.length - 1)
			{
				for (int n=0; n<val; n++)
				{
					sol.append(")");
				}
			}
		}
		
		return sol.toString();
	}
	
	public static void main(String[] args) 
	{
	    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int numTestCase = in.nextInt(); 
	
	    for (int i = 1; i <= numTestCase; ++i) 
	    {
	    	String s = in.next();
	    	
	    	
	    	String solution = Solution.findSolution(s);
	    	System.out.println("Case #" + i + ": " + solution);
	    }
	}
}