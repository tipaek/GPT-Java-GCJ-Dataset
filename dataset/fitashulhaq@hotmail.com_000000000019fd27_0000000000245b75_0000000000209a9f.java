

import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			

			String line = in.nextLine(); 
			if (line.isEmpty())
			{
				i--;
				continue;
			}
			System.out.print("Case #" + i + ": " + "");

			int bracketCount=0;

			for (int index=0;index<line.length();index++)
			{
				
				int number=Integer.parseInt(line.charAt(index)+"");
				
				if (index==0)
				{
					for (int bracks=0;bracks<number;bracks++)
					{
						System.out.print("(");
						bracketCount++;	
					}
					System.out.print(number);
				}
				if (index>0)
				{
					if (number==bracketCount)
						System.out.print(number);
					if (number<bracketCount)
					{
						while (number !=bracketCount)
						{
							
							System.out.print(")");
							bracketCount--;
						}
						System.out.print(number);
					}
					if (number>bracketCount)
					{
						while (number !=bracketCount)
						{
							
							System.out.print("(");
							bracketCount++;
						}
						System.out.print(number);
					}

				}				
				
				
				
/*				if (line.charAt(index)=='0')
				{
					if 
				}
				*/
			}

			for (int bracks=bracketCount;bracks>0;bracks--)
			{
				System.out.print(")");
				
			}
			System.out.println("");




		}
	}
}
