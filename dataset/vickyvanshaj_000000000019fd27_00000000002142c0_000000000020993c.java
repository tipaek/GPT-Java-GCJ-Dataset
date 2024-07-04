import java.util.*;
import java.io.*;

public class Solution
{

	public static void main(String[] args)
	{
		
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		int m=1;
		while(t-->0)
		{
			int n=sc.nextInt();
			int arr[][]=new int[n][n];
			int trace=0;
			int r=0,c=0;
			for(int i=0;i<n;i++)
			{
				HashSet<Integer> set=new HashSet<>();
				boolean flag=true;
				for(int j=0;j<n;j++)
				{
					arr[i][j]=sc.nextInt();
					if(set.contains(arr[i][j]) && flag)
					{
						flag=false;
						r++;
					}
					set.add(arr[i][j]);
					if(i==j)
					{
						trace+=arr[i][j];
					}
				}
			}
			for(int i=0;i<n;i++)
			{
				HashSet<Integer> set=new HashSet<>();
				boolean flag=true;
				for(int j=0;j<n;j++)
				{
					if(set.contains(arr[j][i]) && flag)
					{
						flag=false;
						c++;
					}
					set.add(arr[j][i]);
				}
			}
			System.out.println("Case #"+m+": "+trace+" "+r+" "+c);
			m++;
		}


	}
}