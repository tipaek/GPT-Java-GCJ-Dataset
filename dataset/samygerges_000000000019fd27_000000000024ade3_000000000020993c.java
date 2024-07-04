import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Vestigium
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for (int i = 1; i <= t; ++i)
		{
			int n = in.nextInt();
			int[][] arr = new int[n][n];
			for (int j = 0; j < n; j++)
			{
				for (int k = 0; k < n; k++)
				{
					arr[j][k] = in.nextInt();
				}
			}

			int[] res = compute(arr);
			System.out.println("Case #" + i + ": " + res[0] + " " + res[1] + " " + res[2]);
		}
		in.close();
	}

	private static int[] compute(int[][] arr)
	{
		int[] res = new int[3];
		for (int i = 0; i < arr.length; i++)
		{
			res[0] += arr[i][i];
		}

		for (int i = 0; i < arr.length; i++)
		{
			Set<Integer> seen = new HashSet<>();
			for (int j = 0; j < arr.length; j++)
			{
				if (!seen.add(arr[i][j]))
				{
					res[1]++;
					break;
				}
			}
		}

		for (int i = 0; i < arr.length; i++)
		{
			Set<Integer> seen = new HashSet<>();
			for (int j = 0; j < arr.length; j++)
			{
				if (!seen.add(arr[j][i]))
				{
					res[2]++;
					break;
				}
			}
		}
		return res;
	}
}