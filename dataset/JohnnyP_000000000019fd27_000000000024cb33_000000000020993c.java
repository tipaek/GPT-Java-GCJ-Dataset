import java.util.*;
import java.lang.*;
import java.io.*;
     
public class Solution
{
	
   	public static void main (String[] args) throws java.lang.Exception
   	{
		
		Scanner in = new Scanner(System.in);
		
		int t = in.nextInt();
		
		for(int test = 0;test<t;test++)
		{
			int n = in.nextInt();
			
			int[][] m = new int[n][n];
			
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					m[i][j] = in.nextInt();
				}
			}
			
			int trace = 0;
			
			for(int i=0;i<n;i++)
			{
				trace += m[i][i];
			}
			
			System.out.print("Case #" + (test +1) + ": " + trace);
			
			int[] check = new int[n];
			
			for(int i=0;i<n;i++)
			{
				check[i]=1;
			}
			
			
			int r = 0;
			for(int i =0; i< n; i++)
			{
				for(int j=0;j<n;j++)
				{
					if(m[i][j] - 1 >= n || check[m[i][j]-1] != 1)
					{
						r++;
						break;
					}
					else
					{
						check[m[i][j]-1] = 0;
					}
					
				}
				
			
			for(int j=0;j<n;j++)
			{
				check[j]=1;
			}
			
			}
			
			
			int c = 0;
			for(int i =0; i< n; i++)
			{
				for(int j=0;j<n;j++)
				{
					if(m[j][i] -1 >= n || check[m[j][i]-1] != 1)
					{
						c++;
						break;
					}
					else
					{
						check[m[j][i]-1] = 0;
					}
					
				}
			
			for(int j=0;j<n;j++)
			{
				check[j]=1;
			}
			}
			
			System.out.println(" " + r +" " + c);
		}
		
		
		
    }
}