
import java.util.*;
import java.io.*;

 public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int ii = 1; ii <= t; ++ii) 
		{
			int n = in.nextInt();
			int flag=0;
			int arr[]=new int[100000];
			int st[]=new int[n];
			int end[]=new int[n];
            for (int j = 0; j < n; j++) 
            {
				 st[j]=in.nextInt();
				 end[j]=in.nextInt();
				for (int k = st[j]; k <end[j] ; k++) 
				{
					arr[k]++;
					if(arr[k]>2)
					{flag=1;}
				}
			}
            if(flag==1)
				System.out.println("Case #" + ii + ": IMPOSSIBLE" );
			else
			{
				int ass[]=new int[n];
				ass[0]=0;
				for (int i = 1; i<n; i++) 
				{
					for (int j = i-1; j>=0; j--) 
					{
						if( (st[i]>=st[j]&&st[i]<end[j])|| (end[i]>st[j]&&end[i]<=end[j]) ) 
						{
							ass[i]=1-ass[j];break;
						}
					}
				}
				System.out.print("Case #" + ii + ": " );
				for (int i = 0; i < ass.length; i++) 
				{
					if(ass[i]==1)
					System.out.print('C');
					else
						System.out.print('J');
				}
				System.out.println();
				
			}//else
			
		}//test
	}
}