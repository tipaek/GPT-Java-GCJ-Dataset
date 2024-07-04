

import java.util.*;
import java.io.*;
public class Solution
{
		
	public static void main(String[] args) 
	{

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i)
		{	
			String w = in.next();
			StringBuilder result = new StringBuilder();
			int depth = 0;
			
			for(int c=0;c<w.length();++c)
			{
				int digit = ((int)w.charAt(c)) - (int)'0';
				while(depth > digit)
				{
					result.append(')');
					--depth;
				}
				while(depth < digit)
				{
					result.append('(');
					++depth;
				}
				result.append(digit);
			}

			while(depth > 0)
			{
				result.append(')');
				--depth;
			}

			System.out.println("Case #"  + i + ": " + result.toString());

		}

		in.close();
	}
}
