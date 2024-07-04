//package java_p;

import java.util.*;



public class Solution {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
	
	
		
		int t=sc.nextInt();
		int T=t;
		while(t-->0){
			
			int n=sc.nextInt();
			int a[][]=new int[n][n];
			int dig=0;
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
				{
					a[i][j]=sc.nextInt();
					if(i==j)
						dig+=a[i][j];
				}
			int r=0,c=0;
			for(int i=0;i<n;i++)
			{
				int row[]=new int[n];
				int col[]=new int[n];
				for(int j=0;j<n;j++)
				{
					row[a[i][j]-1]++;
					if(row[a[i][j]-1]>1)
					{
						r++;
						break;
					}
						
				}
				for(int j=0;j<n;j++)
				{
					col[a[j][i]-1]++;
					if(col[a[j][i]-1]>1)
					{
						c++;
						break;
					}
						
				}
			}
			System.out.print("Case #"+(T-t)+": ");
			System.out.println(dig+" "+r+" "+c);
		}
	}
}