import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for (int i = 1; i <= t; ++i)
		{
			int x = in.nextInt();
			int d = in.nextInt();
			long[] arr = new long[x];
			for (int j = 0; j < x; j++)
			{
				arr[j] = in.nextLong();
			}
			int n = calculate(i, d, arr);
			System.out.println("Case #" + t + ": " + n);
		}
		in.close();
	}

	private static int calculate(int t, int d, long[] arr)
	{
		int min = d - 1;
		Map<Long, Slice> slices = new HashMap<>();
		for (long i : arr)
		{
			Slice s = slices.getOrDefault(i, new Slice(i, 0));
			s.count++;
			slices.put(i, s);
		}

		for (Long l : slices.keySet())
		{
			if (slices.get(l).count >= d)
			{
				return 0;
			}
			else
			{
				// can cut others to similar cuts
				List<Slice> list = new ArrayList<>(slices.values());
				Collections.sort(list);
				int cuts = 0;
				boolean hasCut = false;
				for (int i = 0; i < list.size(); i++)
				{
					if (slices.get(l).size == list.get(i).size)
					{
						continue;
					}
					else
					{
						while (list.get(i).size > 0 && list.get(i).size > slices.get(l).size && cuts < d - 1)
						{
							list.get(i).size -= slices.get(l).size;
							cuts++;
							hasCut = true;
						}
					}
				}
				if (hasCut)
				{
					min = Math.min(cuts, min);
				}
			}
		}

		return min;
	}

	static class Slice implements Comparable<Slice>
	{
		long size;
		int count;

		public Slice(long size, int count)
		{
			this.size = size;
			this.count = count;
		}

		@Override
		public int compareTo(Slice o)
		{
			return size > o.size ? -1 : size < o.size ? 1 : 0;
		}
	}
}

