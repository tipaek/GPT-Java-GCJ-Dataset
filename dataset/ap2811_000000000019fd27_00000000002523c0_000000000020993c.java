import java.io.*;
import java.util.*;

public class Solution
{
	public static void main(String args[])throws IOException
	{
		Scanner sc=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t=sc.nextInt();
		for(int o=1;o<=t;o++)
		{
			int n=sc.nextInt();
			int mat[][]=new int[n][n];
			int sum=0;
			int r=0,c=0;
			int rflag=0,cflag=0;
			int i=0,j=0;
			for(i=0;i<n;i++)
			{
				for(j=0;j<n;j++)
				{
					mat[i][j]=sc.nextInt();
					if(i==j) sum=sum+mat[i][j];
				}
			}
			HashSet<Integer> hs1=new HashSet<Integer>();
			HashSet<Integer> hs2=new HashSet<Integer>();
			for(i=0;i<n;i++)
			{
				hs1.add(mat[i][0]);
				hs2.add(mat[0][i]);
				for(j=1;j<n;j++)
				{
					if(hs1.contains(mat[i][j])) rflag=1;
					else hs1.add(mat[i][j]);
					
					if(hs2.contains(mat[j][i])) cflag=1;
					else hs2.add(mat[j][i]);
				}
				if(rflag==1) r++;
				hs1.clear();
				rflag=0;
				
				if(cflag==1) c++;
				hs2.clear();
				cflag=0;
			}
			System.out.println("Case #"+o+": "+sum+" "+r+" "+c);
		}
	}
}