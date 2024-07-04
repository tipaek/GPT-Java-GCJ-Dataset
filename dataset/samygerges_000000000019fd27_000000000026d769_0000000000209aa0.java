import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

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
			compute(n, k, i);
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
		List<List<List<Integer>>> result = new ArrayList<>();
		permuteMatrix(n, all, new ArrayList<>(), result, taken);
		compute(t, k, result);
	}

	private static void compute(int t, int kk, List<List<List<Integer>>> arr)
	{
		for (int k = 0; k < arr.size(); k++)
		{
			int[] res = new int[3];
			for (int i = 0; i < arr.get(k).size(); i++)
			{
				res[0] += arr.get(k).get(i).get(i);
			}

			for (int i = 0; i < arr.get(k).size(); i++)
			{
				Set<Integer> seen = new HashSet<>();
				for (int j = 0; j < arr.get(k).size(); j++)
				{
					if (!seen.add(arr.get(k).get(i).get(j)))
					{
						res[1]++;
						break;
					}
				}
			}

			for (int i = 0; i < arr.get(k).size(); i++)
			{
				Set<Integer> seen = new HashSet<>();
				for (int j = 0; j < arr.get(k).size(); j++)
				{
					if (!seen.add(arr.get(k).get(j).get(i)))
					{
						res[2]++;
						break;
					}
				}
			}
			if (res[0] == kk && res[1] == 0 && res[2] == 0)
			{
				System.out.println("Case #" + t + ": " + "POSSIBLE");
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < arr.get(k).size(); i++)
				{
					for (int j = 0; j < arr.get(k).size(); j++)
					{
						sb.append(arr.get(k).get(i).get(j));
						if (j + 1 < arr.get(k).size())
						{
							sb.append(" ");
						}
					}
					if (i + 1 < arr.get(k).size())
					{
						sb.append("\n");
					}
				}
				System.out.println(sb.toString());
				return;
			}
		}
		System.out.println("Case #" + t + ": IMPOSSIBLE");
	}

	private static void permuteMatrix(int n, List<List<Integer>> all, List<List<Integer>> current, List<List<List<Integer>>> result, boolean[] taken)
	{
		if (current.size() == n)
		{
			result.add(new ArrayList<>(current));
			return;
		}

		List<List<Integer>> prefix = new ArrayList<>(current);
		for (int i = 0; i < all.size(); i++)
		{
			if (!taken[i])
			{
				prefix.add(all.get(i));
				taken[i] = true;
				permuteMatrix(n, all, prefix, result, taken);
				prefix.remove(prefix.size() - 1);
				taken[i] = false;
			}
		}
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
