import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	
	static class Q
	{
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=1;i<=t;i++)
		{
			long l = sc.nextLong();	
			long r = sc.nextLong();
			System.out.println("Case #"+i+": "+solve(l, r));
		}
		sc.close();
	}

	public static String solve(long l, long r)
	{
		long i = Math.round(Math.sqrt(2 * Math.abs(l - r))) - 1;
		i = Math.max(i, 1);
		long d = i * (i + 1) / 2;
		if(l>=r)
		{
			l -= d;
		}
		else
		{
			r -= d;
		}
		i++;
		
		while(i<=Math.abs(l - r))
		{
			if(l>=r)
			{
				l -= i;
			}
			else
			{
				r -= i;
			}
			i++;
		}
		
		
		while(i<= Math.max(l, r))
		{
			long n = 50;
			long d1 = (n + 1) * (n + i);
			long d2 = n * (n + i);
			if(d1>Math.max(l, r) || d2>Math.min(l, r))
			{
				break;
			}
			if(l>=r)
			{
				l -= d1;
				r -= d2;
			}
			else
			{
				l -= d2;
				r -= d1;
			}
			i+=2*n+1;
		}
		
		while(i<= Math.max(l, r))
		{
			if(l>=r)
			{
				l -= i;
			}
			else
			{
				r -= i;
			}
			i++;
		}
		
		
		return (i-1)+" "+l+" "+r;
	}

}
