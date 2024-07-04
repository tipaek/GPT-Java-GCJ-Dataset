import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	public static void main(String args[]) 
	{	
		
		Scanner sc = new Scanner(System.in);
		
		int test = sc.nextInt();
		for(int t=1;t<=test;t++)
		{
			int n = sc.nextInt();
			int a[][] = new int[n][n];
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
					a[i][j] = sc.nextInt();
			int k = 0;
			int c = 0;
			int tr = 0;
			for(int i=0;i<a.length;i++)
				tr = tr + a[i][i];
			Set<Integer>  s;
			for(int i=0;i<a.length;i++)
			{
				s = new HashSet<>();
				for(int j=0;j<a.length;j++)
				{
					if(!s.add(a[i][j]))
					{
						k++;
						break;
					}
				}
			}
			for(int i=0;i<a.length;i++)
			{
				s = new HashSet<>();
				for(int j=0;j<a.length;j++)
				{
					if(!s.add(a[j][i]))
					{
						c++;
						break;
					}
				}
			}
			
			System.out.println("Case #"+(t)+": "+tr+" "+k+" "+c);
			
		}
	}
	
}
