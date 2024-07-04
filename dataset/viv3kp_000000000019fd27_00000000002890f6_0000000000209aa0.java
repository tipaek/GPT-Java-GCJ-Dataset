
import java.io.*;
import java.util.*;
public class Solution {
	
	public static void main(String args[])throws IOException
	{
		Scanner sc=new Scanner(System.in);
		
		
		int test=sc.nextInt();
		int caseNo=1;
		
		
	
		while(test-->0)
		{
			int n=sc.nextInt();
			
			int k=sc.nextInt();
			
			
			if(k==n+1 || k==n*n-1)
				System.out.println("Case #"+caseNo+": IMPOSSIBLE");
			else
			{
				int arr[][]=new int[n][n];
				for(int i=0;i<n;i++)
				{
					arr[0][i]=i+1;
				}
				
			
				
				if(k%n==0)
				{
					System.out.println("Case #"+caseNo+": POSSIBLE");
					int t=k/n;
					
					while(arr[0][0]!=t)
					{
						rotate(arr,0);
					}
					
					for(int i=1;i<n;i++)
					{
						for(int j=0;j<n;j++)
						{
							arr[i][j]=arr[i-1][j];
							System.out.print(arr[i-1][j]+" ");
						}
						System.out.println();
						rotate(arr,i);
					}
					
					for(int i=0;i<n;i++)
					{
						System.out.print(arr[n-1][i]+" ");
					}
					System.out.println();
					
				}
				else
				{
					System.out.println("Case #"+caseNo+": IMPOSSIBLE");
				}
			}
				
			
		
			
			
			caseNo++;
			
			
			
		}
		
		
	}
	
	static void rotate(int arr[][],int pos)
	{
		for(int i=0;i<arr[0].length;i++)
		{
			if(arr[pos][i]!=1)
			arr[pos][i]=arr[pos][i]-1;
			
			else
			arr[pos][i]=arr[0].length;
		}
		
	}
	
}
