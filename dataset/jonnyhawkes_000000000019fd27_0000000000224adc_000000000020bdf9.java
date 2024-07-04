

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
			int n = in.nextInt();	

			ArrayList<int[]> list = new ArrayList<int[]>();
			for(int a=0;a<n;++a)
			{
				int s = in.nextInt();
				int e = in.nextInt();
				
				boolean bFound = false;
				for(int j=0;j<list.size();++j)
				{
					if(s<list.get(j)[0])
					{
						list.add(j, new int[] {s, e, a});
						bFound = true;
						break;
					}
				}
				if(!bFound)
					list.add(new int[] {s, e, a});
					
			}
			
			int j = -1;
			int c = -1;

			String [] result = new String [n + 1];
			result[n] = "";

			for(int a=0;a<n;++a)
			{
				if(c <= list.get(a)[0])
					c = -1;
				if(j <= list.get(a)[0])
					j = -1;

				if(c < 0)
				{					
					c = list.get(a)[1];
					result[list.get(a)[2]] = "C";
				}
				else if (j < 0)
				{
					j = list.get(a)[1];
					result[list.get(a)[2]] = "J";
				}
				else
				{
					result[n] = "I";
					break;
				}
			}

			if(result[n].equals("I"))
				System.out.println("Case #"  + i + ": IMPOSSIBLE");		
			else
			{		
				System.out.print("Case #"  + i + ": ");
				for(int a=0;a<n;++a)
					System.out.print(result[a]);
				System.out.println("");
			}
		}

		in.close();
	}
}
