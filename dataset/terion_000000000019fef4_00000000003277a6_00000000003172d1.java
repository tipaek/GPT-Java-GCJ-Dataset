import java.util.Arrays;
import java.util.Scanner;
public class Solution {
	
	static int N = 10000;
	
	static class Pair
	{
		char c;
		int x;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=1;i<=t;i++)
		{
			int n = sc.nextInt();
			int d = sc.nextInt();
			long[] a = new long[n];
			for(int j=0;j<n;j++)
			{
				a[j] = sc.nextLong();
			}
			System.out.println("Case #"+i+": "+solve(n, d, a));
		}
		sc.close();
	}

	public static int solve(int n, int d, long[] a)
	{	
		Arrays.sort(a);
		if(d==2)
		{
			return solve2(n, a);
		}
		else if(d==3)
		{
			return solve3(n, a);
		}
		return 0;
	}
	
	public static int solve2(int n, long[] a)
	{
		if(n==1)
		{
			return 1;
		}
		
		for(int i=1;i<n;i++)
		{
			if(a[i-1]==a[i])
			{
				return 0;
			}
		}
		
		return 1;
	}
	
	public static int solve3(int n, long[] a)
	{
		if(n==1)
		{
			return 2;
		}
		
		if(n==2)
		{
			if(a[0]*2==a[1])
			{
				return 1;
			}
			return 2;
		}
		
		for(int i=2;i<n;i++)
		{
			if(a[i-1]==a[i] && a[i-2]==a[i])
			{
				return 0;
			}
		}
		
		for(int i=2;i<n;i++)
		{
			if(a[i-2]==a[i-1])
			{
				return 1;
			}
		}
		
		for(int i=0;i<n-1;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if(a[i]*2==a[j])
				{
					return 1;
				}
			}			
		}
		
		return 2;
	}
}
