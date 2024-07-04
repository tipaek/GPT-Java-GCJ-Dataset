

import java.io.BufferedReader;
import java.io.InputStreamReader;


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
