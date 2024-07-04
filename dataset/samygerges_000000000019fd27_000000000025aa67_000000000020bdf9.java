import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for (int i = 1; i <= t; ++i)
		{
			int n = in.nextInt();
			boolean[][] arr = new boolean[2][1441];
			char[] cj = new char[] { 'C', 'J' };
			String res = "";
			boolean impossible = false;
			for (int j = 0; j < n; j++)
			{
				int st = in.nextInt();
				int end = in.nextInt();

				int tryOne = tryOne(st, end, arr);
				if (tryOne == -1)
				{
					impossible = true;
				}
				else
				{
					for (int k = st; k < end; k++)
					{
						arr[tryOne][k] = true;
					}
					res += cj[tryOne];
				}
			}
			if (impossible)
			{
				res = "IMPOSSIBLE";
			}

			System.out.println("Case #" + i + ": " + res);
		}
		in.close();
	}

	private static int tryOne(int st, int end, boolean[][] arr)
	{
		boolean checkOne = false;
		boolean checkTwo = false;
		for (int i = st; i < end; i++)
		{
			if (arr[0][i])
			{
				checkOne = true;
			}
			if (arr[1][i])
			{
				checkTwo = true;
			}
		}
		if (checkOne && checkTwo)
		{
			return -1;
		}
		if (checkOne)
		{
			return 1;
		}
		return 0;
	}
}
