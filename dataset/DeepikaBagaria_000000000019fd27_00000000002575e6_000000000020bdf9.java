import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution
{

	public class TimeObj
	{
		Integer time;
		boolean isStart;
		int id;
		char alloc;

		TimeObj(int time, boolean isStart, int id)
		{
			this.time = time;
			this.isStart = isStart;
			this.id = id;

		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException
	{
		Solution sol = new Solution();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		final StringBuilder impossible = new StringBuilder("IMPOSSIBLE");

		for (int tt = 0; tt < t; tt++)
		{
			StringBuilder sb = new StringBuilder();
			int n = Integer.parseInt(br.readLine());
			// int arr[] = new int[1441];
			TimeObj startTime[] = new TimeObj[2 * n];
			char allocation[] = new char[n];
			for (int i = 0; i < n; i++)
			{
				StringTokenizer str = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(str.nextToken());
				int end = Integer.parseInt(str.nextToken());
				startTime[i * 2] = sol.new TimeObj(start, true, i);
				startTime[(i * 2) + 1] = sol.new TimeObj(end, false, i);

			}
			Comparator<TimeObj> comp = new Comparator<TimeObj>() {

				@Override
				public int compare(TimeObj o1, TimeObj o2)
				{
					int val = o1.time.compareTo(o2.time);
					if (val != 0)
					{
						return val;
					}
					if (!o1.isStart)
					{
						return -1;
					}
					return 1;
				}

			};
			Arrays.sort(startTime, comp);
			boolean cam = true;
			int camId = -1;
			boolean jam = true;
			int jamId = -1;
			for (int i = 0; i < 2 * n; i++)
			{
				TimeObj temp = startTime[i];
				if (temp.isStart)
				{
					if (jam)
					{
						temp.alloc = 'J';
						// sb.append("J");
						jam = false;
						jamId = temp.id;
						allocation[jamId] = 'J';
					} else if (cam)
					{
						temp.alloc = 'C';
						// sb.append("C");
						cam = false;
						camId = temp.id;
						allocation[camId] = 'C';
					} else
					{
						sb = impossible;
						break;
					}
				} else
				{
					int id = temp.id;
					if (!cam && camId == id)
					{
						cam = true;
					} else if (!jam && jamId == id)
					{
						jam = true;
					}
				}

			}
			if (sb.equals(impossible))
			{
				System.out.println("Case #" + (tt + 1) + ": " + sb.toString());
			} else
			{
				System.out.println("Case #" + (tt + 1) + ": " + new String(allocation));
			}
		}

	}

}
