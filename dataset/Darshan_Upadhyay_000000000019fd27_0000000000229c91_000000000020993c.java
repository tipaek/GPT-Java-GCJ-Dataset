

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
			int[] indr=new int[n+1];
			int[] indc=new int[n+1];
			Arrays.fill(indr,0);
			Arrays.fill(indc,0);
			for(int j=0;j<n;j++)
			{
			
				for(int k=0;k<n;k++)
				{
					indr[a[j][k]]++;
					indc[a[k][j]]++;
				}
				boolean f1=true,f2=true;
				for(int l=1;l<=n;l++)
				{
				    if(indr[l]>1 && f1)
				    {
				        r++;
				        f1=false;
				    }
				    if(indc[l]>1 && f2)
				    {
				        c++;
				        f2=false;
				    }
				    indr[l]=0;
				    indc[l]=0;
				}
			}
		
			
			System.out.println("Case #"+(i+1)+": "+sum+" "+r+" "+c);
			
		}
		

	}

}
