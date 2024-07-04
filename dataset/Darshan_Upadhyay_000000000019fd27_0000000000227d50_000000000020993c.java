package problem;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int i=0;i<t;i++)
		{
		
			int n=sc.nextInt();
			int[][] a=new int[n][n];
			int r=0,c=0,sum=0;
			for(int j=0;j<n;j++)
			{
				for(int k=0;k<n;k++)
				{
					a[j][k]=sc.nextInt();
					if(j==k)
					{
						sum+=a[j][k];
					}
				}
			}
			int[] ind=new int[101];
			for(int j=0;j<n;j++)
			{
				Arrays.fill(ind, 0);
				for(int k=0;k<n;k++)
				{
					ind[a[j][k]]++;
					if(ind[a[j][k]]>1)
					{
						r++;
						break;
					}
				}
			}
			int[] ind1=new int[101];
			for(int j=0;j<n;j++)
			{
				Arrays.fill(ind1, 0);
				for(int k=0;k<n;k++)
				{
					ind1[a[k][j]]++;
					if(ind1[a[k][j]]>1)
					{
						c++;
						break;
					}
				}
			}
			
			System.out.println("Case "+(i+1)+"#:"+sum+" "+r+" "+c);
			
		}
		

	}

}
