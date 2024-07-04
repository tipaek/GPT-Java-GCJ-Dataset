import java.io.*;
import java.util.*;
public class Solution {

	public static void main(String[] args) 
	{
		Scanner sc= new Scanner(System.in);
		int test= sc.nextInt();
		for(int g=0;g<test;g++)
		{
			int n=sc.nextInt();
			int k=sc.nextInt();
			int[][] ans= new int[n][n];
			if(n==2)
			{
				if(k==2)
				{
					System.out.println("Case #" + (g+1) + ": Possible");	
					System.out.println("1 2");
					System.out.println("2 1");
				}
				else if(k==4)
				{
					System.out.println("Case #" + (g+1) + ": Possible");	
					System.out.println("2 1");
					System.out.println("1 2");
				}
				else
				{
					System.out.println("Case #" + (g+1) + ": Impossible");	
				}
				
			}
			else
			{
				if(k%n==0)
				{
					int start=k/n;
					for(int x=0;x<n;x++)
					{
						int curr=start;
						for(int y=0;y<n;y++)
						{
							ans[x][y]=curr;
							curr++;
							if(curr>n)
							{
								curr=1;
							}
						}
						start--;
						if(start==0)
						{
							start=n;
						}
					}
					
				}
				else if(k==(n*(n+1)/2))
				{
					int start=1;
					for(int x=0;x<n;x++)
					{
						int curr=start;
						for(int y=0;y<n;y++)
						{
							ans[x][y]=curr;
							curr++;
							if(curr>n)
							{
								curr=1;
							}
						}
						start++;
						if(start>n)
						{
							start=1;
						}
					}
				}
				else
				{
					System.out.println("Case #" + (g+1) + ": Impossible");	
					continue;
				}
				System.out.println("Case #" + (g+1) + ": Possible");	
				for(int x=0;x<n;x++)
				{
					for(int y=0;y<n;y++)
					{
						System.out.print(ans[x][y]+ " ");
					}
					System.out.println();
				}
				
			}
		}
	}

}
