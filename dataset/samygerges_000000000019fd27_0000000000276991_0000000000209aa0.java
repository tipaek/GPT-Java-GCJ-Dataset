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
			int k = in.nextInt();
			if (k % n == 0)
			{
				compute(n, k, i);
			}
			else
			{
				System.out.println("Case #" + t + ": IMPOSSIBLE");
			}
		}
		in.close();
	}

	private static void compute(int n, int k, int t)
	{
		int[][] arr = new int[n][n];
		boolean[][] visitedRow = new boolean[n][n + 1];
		boolean[][] visitedCol = new boolean[n][n + 1];

		for (int i = 0; i < n; i++)
		{
			arr[i][i] = k / n;
			visitedCol[i][k / n] = true;
			visitedRow[i][k / n] = true;

		}
		for (int i = 0; i < n; i++)
		{
			boolean check = tryRow(arr, i, n, visitedRow, visitedCol);
			if (!check)
			{
				System.out.println("Case #" + t + ": IMPOSSIBLE");
				return;
			}
		}
		System.out.println("Case #" + t + ": " + "POSSIBLE");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++)
		{
			for (int j = 0; j < arr.length; j++)
			{
				sb.append(arr[i][j]);
				if (j + 1 < arr.length)
				{
					sb.append(" ");
				}
			}
			if (i + 1 < arr.length)
			{
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}

	private static boolean tryRow(int[][] arr, int row, int n, boolean[][] visitedRow, boolean[][] visitedCol)
	{
		return permute(arr[row], 1, row, n, visitedRow, visitedCol);
	}

	private static boolean permute(int[] num, int st, int row, int n, boolean[][] visitedRow, boolean[][] visitedCol)
	{
		if (st == n)
		{
			return true;
		}
		for (int i = 0; i < n; i++)
		{
			if (num[i] == 0)
			{
				for (int j = 1; j <= n; j++)
				{
					if (!visitedRow[row][j] && !visitedCol[i][j])
					{
						num[i] = j;
						visitedRow[row][j] = true;
						visitedCol[i][j] = true;
						if (permute(num, st + 1, row, n, visitedRow, visitedCol))
						{
							return true;
						}
						num[i] = 0;
						visitedRow[row][j] = false;
						visitedCol[i][j] = false;
					}
				}
			}
		}
		return false;
	}
}