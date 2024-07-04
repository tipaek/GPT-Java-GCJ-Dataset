

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
Inputs:::
5
2 2
3 2
2 3
3 4
5 3

Output:::
Case #1: 2 2
2 1
Case #2: 3 2
3 2
2 1
Case #3: 2 3
4 1
3 1

*/
public class Solution
{
	public static void main (String arg[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcases = Integer.parseInt(br.readLine()), r, s;
		String in[];
		
		for (int testcase = 0; testcase < testcases; testcase++)
		{
			in = br.readLine().split(" ");
			r = Integer.parseInt(in[0]);
			s = Integer.parseInt(in[1]);
			
			System.out.println("Case #" + (testcase + 1) + ": " + r + " " + s);
			jump(r, s, r * (s - 1), r - 1, s - 1);
		}
	}
	
	private static void jump(int r, int s, int a, int b, int bCount)
	{
		if(bCount == 0)
		{
			b--;
			bCount = s - 1;
		}
		
		System.out.println(a + " " + b);
		if(a != s)
			jump(r, s, a - 1, b, --bCount);
	}
}
