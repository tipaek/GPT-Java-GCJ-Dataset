import java.util.Arrays;
import java.util.Scanner;
 class Solution
{
	public static void main (String[] args)
	 {
		Scanner sc=new Scanner(System.in);
		int i;
		int t=sc.nextInt();
		int p=t;
		while(t>0)
		{
			t--;
			int j;
			int n=sc.nextInt();
			int a[][]=new int[n][n];
			int trace=0;
			for(i=0;i<n;i++)
				for(j=0;j<n;j++)
				{
					a[i][j]=sc.nextInt();
					if(i==j)
						trace+=a[i][j];
				}
			int row=0,col=0,flag=0;
			for(i=0;i<n;i++)
			{
				flag=0;
				for(j=0;j<n-1;j++)
				{
					
					for(int k=j+1;k<n;k++)
					{
						if(a[i][k]==a[i][j])
						{
							row++;
							flag=1;
							break;
						}
					}
					if(flag==1)
						break;
				}
			}
			for(j=0;j<n;j++)
			{
				flag=0;
				for(i=0;i<n-1;i++)
				{
					
					for(int k=i+1;k<n;k++)
					{
						if(a[k][j]==a[i][j])
						{
							col++;
							flag=1;
							break;
						}
					}
					if(flag==1)
						break;
				}
			}
			System.out.println("Case #"+(p-t)+": "+trace+" "+row+" "+col);
		}
		
	 }
} 