import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution
{
	static class Schedule implements Comparable<Schedule>
	{
		int st;
		int end;
		char c;
		int index;

		public Schedule()
		{
		}

		@Override
		public int compareTo(Schedule o)
		{
			return st - o.st;
		}
	}

	public static void main(String[] args)
	{
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for (int i = 1; i <= t; ++i)
		{
			int n = in.nextInt();
			Schedule[] arr = new Schedule[n];
			for (int j = 0; j < n; j++)
			{
				arr[j] = new Schedule();
				arr[j].index = j;
				arr[j].st = in.nextInt();
				arr[j].end = in.nextInt();
			}
			String res = compute(arr);
			System.out.println("Case #" + i + ": " + res.trim());
		}
		in.close();
	}

	private static String compute(Schedule[] matrix)
	{
		Arrays.sort(matrix);
		Map<Integer, Schedule> map = new HashMap<>();
		boolean[][] arr = new boolean[2][1441];
		char[] cj = { 'C', 'J' };
		StringBuilder res = new StringBuilder();
		boolean impossible = false;
		for (int j = 0; j < matrix.length; j++)
		{
			int st = matrix[j].st;
			int end = matrix[j].end;
			map.put(matrix[j].index, matrix[j]);
			int tmp = 0;
			if (st > end)
			{
				tmp = end;
				end = 1441;
			}
			int tryOne = tryOne(st, end, tmp, arr);
			if (tryOne == -1)
			{
				return "IMPOSSIBLE";
			}
			else
			{
				for (int k = st; k < end; k++)
				{
					arr[tryOne][k] = true;
				}
				if (tmp > 0)
				{
					for (int k = 0; k < tmp; k++)
					{
						arr[tryOne][k] = true;
					}
				}
				matrix[j].c = cj[tryOne];
			}
		}
		for (int i = 0; i < matrix.length; i++)
		{
			res.append(map.get(i).c);
		}
		return res.toString();
	}

	private static int tryOne(int st, int end, int tmp, boolean[][] arr)
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
		if (tmp > 0)
		{
			for (int i = 0; i < tmp; i++)
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
