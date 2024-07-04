import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.StringJoiner;

public class Solution
{
	private Scanner scanner;
	private InputStream in;
	private PrintStream out;

	public Solution(InputStream in, PrintStream out)
	{
		this.in = in;
		this.out = out;
		this.scanner = new Scanner(in);
	}

	public static void main(String args[])
	{
		Solution parentingproblem = new Solution(System.in, System.out);
		parentingproblem.go();
	}

	public void test(int testNum, Interval intervals[])
	{
		String answer = doTest(intervals);
		out.println("Case #" + testNum + ": " + answer);
	}

	public String doTest(Interval intervals[])
	{
		int[] cameronSchedule = new int[24 * 60 + 1];
		int[] jamieSchedule = new int[24 * 60 + 1];
		String who = "";

		for (Interval interval : intervals)
		{
			if (isFree(jamieSchedule, interval))
			{
				book(jamieSchedule, interval);
				who += "J";
			}
			else if (isFree(cameronSchedule, interval))
			{
				book(cameronSchedule, interval);
				who += "C";
			}
			else
			{
				who = "IMPOSSIBLE";
				break;
			}
		}

		return who;
	}

	private void book(int[] schedule, Interval interval)
	{
		for (int i = interval.start; i < interval.end; i++)
			schedule[i] = 1;
	}

	private boolean isFree(int[] schedule, Interval interval)
	{
		for (int i = interval.start; i < interval.end; i++)
		{
			if (schedule[i] == 1)
				return false;
		}

		return true;
	}

	void go()
	{
		int tests = scanner.nextInt();

		for (int i = 1; i <= tests; i++)
		{
			int activityNumber = scanner.nextInt();
			Interval[] intervals = new Interval[activityNumber];
			for (int j = 0; j < activityNumber; j++)
			{
				intervals[j] = new Interval();
				intervals[j].start = scanner.nextInt();
				intervals[j].end = scanner.nextInt();
			}

			test(i, intervals);
		}
	}

	public static class Interval
	{
		int end;
		int start;

		@Override
		public String toString()
		{
			return new StringJoiner(", ", Interval.class.getSimpleName() + "[", "]")
							.add("end=" + end)
							.add("start=" + start)
							.toString();
		}
	}
}
