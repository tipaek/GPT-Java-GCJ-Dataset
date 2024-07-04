import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		
		for(int x=1;x<=t;x++)
		{
			
			int n=sc.nextInt();
			int[][] a=new int[n][n];
			int i,j,k=0,r=0,c=0;

			
		for(i=0;i<n;i++)
		{
			for(j=0;j<n;j++)
			{
				a[i][j]=sc.nextInt();
				
			}
			k+=a[i][i];
		}
		
	
		for(i=0;i<n;i++)
		{
			for(j=0;j<n;j++)
			{
				int index=Math.abs(a[i][j])-1;
				if(a[i][index]<0)
				{
					r++;
					break;
				}
				a[i][index]=-a[i][index];
		
			}
			
		}
		for(i=0;i<n;i++)
		{
			for(j=0;j<n;j++)
			{
				if(a[i][j]<0)
					a[i][j]*=-1;
			}
		}
		for(i=0;i<n;i++)
		{
			for(j=0;j<n;j++)
			{
				
				int jindex=Math.abs(a[j][i])-1;
				if(a[jindex][i]<0)
				{
					c++;
					break;
				}
				a[jindex][i]=-a[jindex][i];
		
			}
		}
		System.out.println("Case #"+x+": "+k+" "+r+" "+c);
	}
	}		

}