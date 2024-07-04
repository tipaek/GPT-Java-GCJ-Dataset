import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String [] args)
	{
		Scanner y=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t;
		t=y.nextInt();
		for(int i=1;i<=t;i++)
		{
			int n=y.nextInt();
			int a[][]=new int[n][n];
			int k=0,r=0,c=0;
			for(int j=0;j<n;j++)
			{
				for(int m=0;m<n;m++)
				{
					a[j][m]=y.nextInt();
					if(j==m)
						k=k+a[j][m];
				}
			}
			for(int u=0;u<n;u++)
			{
				comp:for(int j=0;j<3;j++)
				{
					for(int m=j+1;m<n;m++)
					{
						if(a[u][j]==a[u][m])
						{
							r++;
							break comp;
						}
					}
				}
			}
			for(int u=0;u<n;u++)
			{
				comp1:for(int j=0;j<3;j++)
				{
					for(int m=j+1;m<n;m++)
					{
						if(a[j][u]==a[m][u])
						{
							c++;
							break comp1;
						}
					}
				}
			}
			System.out.println("Case #"+i+": "+k+" "+r+" "+c);	
		}
	}
}