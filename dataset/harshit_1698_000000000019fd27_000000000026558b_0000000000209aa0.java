// package codejam_2020;
import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		for(int hp=1;hp<=t;hp++)
		{
		
		String[] s=br.readLine().split(" ");
		int n=Integer.parseInt(s[0]);
		int given_sum=Integer.parseInt(s[1]);;
		int[][] a=generate(n);
		int sum=0;
		for(int i=0;i<n;i++)
		{
			sum+=a[i][i];
		}
		
		int[][] tmp=new int[n][n];
		boolean flag=(sum==given_sum);
		if(flag)
		{
			tmp=a;
		}
		for(int i=0;i<n && !flag;i++)
		{
			sum=0;
			for(int j=0;j<i;j++)
			{
				sum+=a[j][j];
			}
			for(int j=i+1;j<n;j++)
			{
				sum+=a[j][j-1];
			}
			sum+=a[i][n-1];
			if(sum==given_sum)
			{
				int x=0,y=0;
				flag=true;
				for(int j=0;j<i;j++)
				{
					for(int p=0;p<n;p++)
					{
						tmp[x][y++]=a[j][p];
					}
					x++;
					y=0;
					
				}
				for(int j=i+1;j<n;j++)
				{
					for(int p=0;p<n;p++)
					{
						tmp[x][y++]=a[j][p];
					}
					x++;
					y=0;
					
				}
				for(int j=0;j<n;j++)
				{
					tmp[x][j]=a[i][j];
				}
				
				
			}
			
		}
		
		if(flag)
		{
		System.out.println("Case #"+hp+": "+"POSSIBLE");
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(tmp[i][j]+" ");
			}
			System.out.println();
		}
		}else {
			System.out.println("Case #"+hp+": "+"IMPOSSIBLE");
		}
		}
		
	}

	public static int[][] generate(int n)
	{
		int[][] a=new int[n][n];
		
		for(int j=0;j<n;j++)
		{
			a[0][j]=(j+1);
		}
		
		
		
		for(int i=1;i<n;i++)
		{
			a[i][0]=(i+1);
			int t=i+1;
			for(int j=1;j<n;j++)
			{
				if(t%n==0)
				{
					t=0;
				}
				
				t++;
				a[i][j]=t;
				
				
				
			}
			
			
		}
		
		
		
		return a;
		
		
	}
	
}
