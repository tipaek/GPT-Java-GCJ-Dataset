import java.io.*;
import java.util.*;

class cj1
{
	public static void main(String args[]) throws IOException
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int o=1;o<=t;o++)
		{
			int n=sc.nextInt();
			int mat[][]=new int[n][n];
			int sum=0;
			int r=0,c=0;
			int flag=0;
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					mat[i][j]=sc.nextInt();
					if(i==j) sum=sum+mat[i][j];
				}
			}
			HashSet<Integer> hs1=new HashSet<Integer>();
			for(int i=0;i<n;i++)
			{
				hs1.add(mat[i][0]);
				for(int j=1;j<n;j++)
				{
					if(hs1.contains(mat[i][j])) flag=1;
					else hs1.add(mat[i][j]);
				}
				if(flag==1) r++;
				hs1.clear();
				flag=0;
			}
			flag=0;
			HashSet<Integer> hs2=new HashSet<Integer>();
			for(int i=0;i<n;i++)
			{
				hs2.add(mat[0][i]);
				for(int j=1;j<n;j++)
				{
					if(hs2.contains(mat[j][i])) flag=1;
					else hs2.add(mat[j][i]);
				}
				if(flag==1) c++;
				hs2.clear();
				flag=0;
			}
			
			System.out.println("Case #"+o+": "+sum+" "+r+" "+c);
		}
	}
}