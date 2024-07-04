import java.util.HashMap;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		
		int t=s.nextInt();
		
		for(int i=0;i<t;i++)
		{
			int n=s.nextInt();
			
			int[][] arr=new int[n][n];
			
			for(int j=0;j<n;j++)
			{
				for(int k=0;k<n;k++)
				{
					arr[j][k]=s.nextInt();
				}
			}
			
			int rows=0;
			int cols=0;
			
			for(int j=0;j<n;j++)
			{
				int[] count=new int[n+1];
				
				for(int k=0;k<n;k++)
				{
					if(count[arr[j][k]]>0)
					{
						rows++;
						break;
					}
					else
					{
						count[arr[j][k]]++;
					}
				}
			}
			
			for(int j=0;j<n;j++)
			{
				int[] count=new int[n+1];
				
				for(int k=0;k<n;k++)
				{
					if(count[arr[k][j]]>0)
					{
						cols++;
						break;
					}
					else
					{
						count[arr[k][j]]++;
					}
				}
			}
			
			int trace=0;
			
			for(int j=0;j<n;j++)
			{
				trace=trace+arr[j][j];
			}
			
			System.out.println("Case #"+(i+1)+": "+trace+" "+rows+" "+cols);
			
		}
		
	}
	
}