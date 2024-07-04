
import java.util.*;
class Vestigium {
	public static void main(String[] args) {
	Scanner input=new Scanner(System.in);
	int t=input.nextInt();
	for(int i=1;i<=t;i++)
	{
		int n=input.nextInt();
		int[][] a=new int[n][n];
		for(int j=0;j<n;j++)
		{
			for(int k=0;k<n;k++)
			{
				a[j][k]=input.nextInt();
			}
				
		}
		trace(a,n,i);
	}
	}
	static void trace(int[][] a,int n,int t)
	{
		System.out.print("Case #"+t+": ");
		int sum=0;
		for(int i=0;i<n;i++)
			sum+=a[i][i];
		int c=0,r=0;
		int flag=0;
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n-1;j++)
			{
				flag=0;
				for(int k=j+1;k<n;k++)
					if(a[i][j]==a[i][k])
					{
						r++;
						flag=1;
						break;
					}
				if(flag==1)
					break;
			}
		}
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n-1;j++)
			{
				flag=0;
				for(int k=j+1;k<n;k++)
					if(a[j][i]==a[k][i])
					{
						c++;
						flag=1;
						break;
					}
				if(flag==1)
					break;
			}
		}
		System.out.print(sum+" "+r+" "+c);
	}

}
