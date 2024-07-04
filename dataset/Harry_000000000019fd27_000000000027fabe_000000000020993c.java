import java.util.*;
import java.io.*;

public class Solution
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
			int k=0,r=0,c=0,e=0,temp;
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
				e=0;
				for(int j=0;j<3;j++)
				{
					temp=a[u][j];
					for(int m=j+1;m<n;m++)
					{
						if(temp==a[u][m] && e<1)
						{
							r++;
							e++;
						}
					}
				}
			}
			for(int u=0;u<n;u++)
			{
				e=0;
				for(int j=0;j<3;j++)
				{
					temp=a[j][u];
					for(int m=j+1;m<n;m++)
					{
						if(temp==a[m][u] && e<1)
						{
							c++;
							e++;
						}
					}
				}
			}
			System.out.println("Case #"+i+": "+k+" "+r+" "+c);	
		}
	}
}