import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		
		for(int l=1;l<=t;l++)
		{
			
			int n=sc.nextInt();
			int[][] arr=new int[n][n];
			int i,j,k=0,r=0,c=0;

			
		for(i=0;i<n;i++)
		{
			for(j=0;j<n;j++)
			{
				arr[i][j]=sc.nextInt();
				
			}
			k+=arr[i][i];
		}
		
	
		for(i=0;i<n;i++)
		{
			for(j=0;j<n;j++)
			{
				int index=Math.abs(arr[i][j])-1;
				if(arr[i][index]<0)
				{
					r++;
					break;
				}
				arr[i][index]=-arr[i][index];
		
			}
			
		}
		for(i=0;i<n;i++)
		{
			for(j=0;j<n;j++)
			{
				if(arr[i][j]<0)
					arr[i][j]*=-1;
			}
		}
		for(i=0;i<n;i++)
		{
			for(j=0;j<n;j++)
			{
				
				int jindex=Math.abs(arr[j][i])-1;
				if(arr[jindex][i]<0)
				{
					c++;
					break;
				}
				arr[jindex][i]=-arr[jindex][i];
		
			}
		}
		System.out.println("Case #"+l+": "+k+" "+r+" "+c);
	}
	}		

}