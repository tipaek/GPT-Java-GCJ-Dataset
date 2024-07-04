import java.util.Scanner;
public class Solution {
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		int i,j,sum=0;
		int case1=1;
		while(t-->0)
		{
			int size=sc.nextInt();
			int a[][]=new int[size][size];
			for(i=0;i<size;i++)
			{
				for(j=0;j<size;j++)
				{
					a[i][j]=sc.nextInt();
				}
			}
			
			
			
			for(i=0;i<size;i++)
			{
				for(j=0;j<size;j++)
				{
					if(i==j)
					{
						sum=sum+a[i][j];
					}
				}
			}
			
		    
		int count=0;
		for(i=0;i<size;i++)
		{
			for(j=1;j<i;j++)
			{
				if(a[i][i]==a[j][i])
				{
					count++;
					
				}
			}
		}
		
		int count1=0;
		for(j=0;j<size;j++)
		{
			for(i=1;i<size;i++)
			{
				if(a[i][i]==a[i][j])
				{
					count1++;
					
				}
			}
		}
		
		System.out.println("Case #"+case1+":"+sum+" "+count+" "+count1);
			case1++;
			sum=0;
		}
	}
}
