

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
Case #4: 3 4
9 2
8 2
7 2
6 1
5 1
4 1
Case #5: 5 3
10 4
9 4
8 3
7 3
6 2
5 2
4 1
3 1

*/
public class Solution
{
	private static int count = 0;
	
	public static void main (String arg[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcases = Integer.parseInt(br.readLine()), r, s;
		String in[];
		
		String output;
		for (int testcase = 0; testcase < testcases; testcase++)
		{
			in = br.readLine().split(" ");
			r = Integer.parseInt(in[0]);
			s = Integer.parseInt(in[1]);
			
			count = 0;
			
			output = jump(r, s, r * (s - 1), r - 1, s - 1);
			System.out.println("Case #" + (testcase + 1) + ": " + count);
			System.out.println(output);
		}
	}
	
	private static String jump(int r, int s, int a, int b, int bCount)
	{
		if(bCount == 0)
		{
			b--;
			bCount = s - 1;
		}
		
		count++;
		
		if(a != s)
			return a + " " + b + "\n" + jump(r, s, a - 1, b, --bCount);
		
		return a + " " + b;
	}
}
