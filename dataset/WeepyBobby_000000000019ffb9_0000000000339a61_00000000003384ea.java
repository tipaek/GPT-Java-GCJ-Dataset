import java.util.*;
import java.math.*;
import java.io.*;
class Solution
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader st = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(st.readLine());
		int curc = 0;
		nextcase:
		while(curc++ < cases)
		{
			StringTokenizer s = new StringTokenizer(st.readLine());
			//int n = Integer.parseInt(st.readLine());
			int a = Integer.parseInt(s.nextToken());
			int b = Integer.parseInt(s.nextToken());
			for(int i = 1; i <= 1000; i++)
			{
				if(Math.max(a, b) < i)
				{
					System.out.println("Case #"+curc+": "+(i-1)+" "+a+" "+b);
					continue nextcase;
				}
				else
				{
					if(a >= b)
					{
						a -= i;
					}
					else
					{
						b -= i;
					}
				}
			}

		}
	}
	public static void print(String str)
	{
		System.out.println(str);
		System.out.flush();
		return;
	}
	public static void print(int str)
	{
		System.out.println(str);
		System.out.flush();
		return;
	}
}
