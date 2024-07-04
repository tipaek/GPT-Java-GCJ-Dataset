import java.util.*;

public class Solution {
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int t=1;t<=T;t++) {
			int r=sc.nextInt();
			int c=sc.nextInt();
			int a[][]=new int[r][c];
			for(int i=0;i<r;i++)
				for(int j=0;j<c;j++)
					a[i][j]=sc.nextInt();
			
			System.out.println("Case #"+t+": "+sum(a,r,c));
		}
	}
	public static long sum(int a[][],int r,int c) {
		long ans=0;
		
		while(true)
		{
			int row[]=new int[r];
			int col[]=new int[c];
			int R[]=new int[r];
			int C[]=new int[c];
			for(int i=0;i<r;i++)
				for(int j=0;j<c;j++)
				{
					row[i]+=a[i][j];
					if(a[i][j]==0)
						{
						R[i]++;
						C[j]++;
						}
				}
			for(int i=0;i<c;i++)
				for(int j=0;j<r;j++)
					col[i]+=a[j][i];
			int count=0;
			for(int i=0;i<r;i++)
				for(int j=0;j<c;j++) {
					if(a[i][j]==0)
						continue;
					//System.out.println(row[i]/(double)(c-R[i]));
					//System.out.println(col[j]/(double)(r-C[j]));
					
					if(a[i][j]<row[i]/(double)(c-R[i])||a[i][j]<col[j]/(double)(r-C[j]))
					{
						a[i][j]=0;
						count++;
					}
				}
					
						
				
			
			for(int i=0;i<r;i++)
				ans+=row[i];
			if(count==0)
				break;
			
		}
		return ans;
		
	}

}