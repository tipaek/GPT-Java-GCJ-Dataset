import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	static class Interval {
		int a;
		int b;
		int i;
		String e = "";
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=1;i<=t;i++)
		{
			int n = sc.nextInt();
			Interval[] arr = new Interval[n];
			for(int j=0;j<n;j++)
			{
				arr[j] = new Interval();
				arr[j].a = sc.nextInt();
				arr[j].b = sc.nextInt();
				arr[j].i = j;
			}
			System.out.println("Case #"+i+": "+solve(n, arr));
		}
		sc.close();
	}

	public static String solve(int n, Interval[] arr)
	{
		Arrays.sort(arr, (i1, i2) -> i1.a - i2.a);
		int j = 0;
		int c = 0;
		for(int x=0;x<n;x++)
		{
			Interval interval = arr[x];
			if(interval.a >= j)
			{
				j = interval.b;
				interval.e = "J";
			}
			else if(interval.a >= c)
			{
				c = interval.b;
				interval.e = "C";
			}
			else
			{
				return "IMPOSSIBLE";
			}
		}
		
		Arrays.sort(arr, (i1, i2) -> i1.i - i2.i);
		String res = "";
		for(int x=0;x<n;x++)
		{
			res += arr[x].e;
		}
		
		return res;
	}
}
