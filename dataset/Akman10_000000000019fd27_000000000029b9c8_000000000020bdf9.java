import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int ii = 1; ii <= t; ++ii) 
		{
			int n = in.nextInt();
			int st[]=new int[n];
			int end[]=new int[n];
			int ass[]=new int[n];
			
			for (int i = 0; i < n; i++) 
			{
				st[i]= in.nextInt();
				end[i]= in.nextInt();
			}
			int imp=0;
			for (int i = 1; i < n; i++) 
			{
				int first=0;
				for (int j = i-1; j >=0;j--)
				{
					if((st[i]>=st[j]&&st[i]<end[j])||(end[i]>st[j]&&end[i]<=end[j]))
					{
						if(first==0)
						{
							ass[i]=1-ass[j];
							first++;
						}
						else
						{
							if(ass[i]==ass[j])
								imp=1;
						}
					}
				}
			}
			if(imp==1)
				System.out.println("Case #" + ii + ": IMPOSSIBLE" );
			else
			{
				System.out.print("Case #" + ii + ": " );
			      for (int i = 0; i < n; i++) 
			       {
			    	        if(ass[i]==1)
							System.out.print("J");
							else
							System.out.print("C");
			       }
			      System.out.println();
			}
			
		}//test
	}
}