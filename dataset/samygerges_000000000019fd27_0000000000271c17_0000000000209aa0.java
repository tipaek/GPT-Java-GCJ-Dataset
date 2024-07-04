import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution
{
	private static List<List<Integer>> correct;

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
		int[] num = new int[n];
		for (int i = 1; i <= n; i++)
		{
			num[i - 1] = i;
		}
		List<List<Integer>> all = permute(num);
		boolean[] taken = new boolean[all.size()];
		List<List<Integer>> matrix = new ArrayList<>();
		boolean result = permuteMatrix(n, k, all, matrix, taken);
		if (result)
		{
			System.out.println("Case #" + t + ": " + "POSSIBLE");
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < correct.size(); i++)
			{
				for (int j = 0; j < correct.size(); j++)
				{
					sb.append(correct.get(i).get(j));
					if (j + 1 < correct.size())
					{
						sb.append(" ");
					}
				}
				if (i + 1 < correct.size())
				{
					sb.append("\n");
				}
			}
			System.out.println(sb);
		}
		else
		{
			System.out.println("Case #" + t + ": IMPOSSIBLE");
		}
	}

	private static boolean compute(int k, List<List<Integer>> arr)
	{

		int[] res = new int[3];
		for (int i = 0; i < arr.size(); i++)
		{
			res[0] += arr.get(i).get(i);
		}

		for (int i = 0; i < arr.size(); i++)
		{
			Set<Integer> seen = new HashSet<>();
			for (int j = 0; j < arr.size(); j++)
			{
				if (!seen.add(arr.get(i).get(j)))
				{
					res[1]++;
					break;
				}
			}
		}

		for (int i = 0; i < arr.size(); i++)
		{
			Set<Integer> seen = new HashSet<>();
			for (int j = 0; j < arr.size(); j++)
			{
				if (!seen.add(arr.get(j).get(i)))
				{
					res[2]++;
					break;
				}
			}
		}
		if (res[0] == k && res[1] == 0 && res[2] == 0)
		{
			return true;
		}

		return false;
	}

	private static boolean permuteMatrix(int n, int k, List<List<Integer>> all, List<List<Integer>> current, boolean[] taken)
	{
		if (current.size() == n)
		{
			if (compute(k, current))
			{
				correct = new ArrayList<>(current);
				return true;
			}
			return false;
		}

		List<List<Integer>> prefix = new ArrayList<>(current);
		for (int i = 0; i < all.size(); i++)
		{
			if (!taken[i])
			{
				prefix.add(all.get(i));
				taken[i] = true;
				if (permuteMatrix(n, k, all, prefix, taken))
				{
					return true;
				}
				prefix.remove(prefix.size() - 1);
				taken[i] = false;
			}
		}
		return false;
	}

	private static List<List<Integer>> permute(int[] num)
	{
		List<List<Integer>> result = new ArrayList<>();
		result.add(new ArrayList<>());

		for (int i = 0; i < num.length; i++)
		{
			ArrayList<ArrayList<Integer>> current = new ArrayList<>();

			for (List<Integer> l : result)
			{
				for (int j = 0; j < l.size() + 1; j++)
				{
					l.add(j, num[i]);

					ArrayList<Integer> temp = new ArrayList<>(l);
					current.add(temp);
					l.remove(j);
				}
			}
			result = new ArrayList<>(current);
		}
		return result;
	}
}
