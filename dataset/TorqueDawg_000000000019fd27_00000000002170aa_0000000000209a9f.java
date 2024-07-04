//Template for Solution submissions
import java.util.*;
import java.io.*;
public class Solution 
{
	public static void main (String [] args)
	{
		Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = input.nextInt();
		for(int i = 1; i <= t; i++)
		{
			String s = input.next();
			String output = "";
			for(int j = 0; j < s.length(); j++)
			{
				String currentSubStr = s.substring(j, j+1);
				int subStrVal = Integer.parseInt(currentSubStr);
				for(int num = 0; num < subStrVal; num++)
				{
					currentSubStr = "(" + currentSubStr + ")";
				}
				output += currentSubStr;
			}
			for(int p = 0; p < output.length()-1; p++)
			{
				if(output.substring(p, p+2).equals(")("))
				{
					output = output.substring(0, p) + output.substring(p+2);
					p-=2;
				}
			}
			System.out.println("Case #" + i + ": " + output);
		}
	}
}
