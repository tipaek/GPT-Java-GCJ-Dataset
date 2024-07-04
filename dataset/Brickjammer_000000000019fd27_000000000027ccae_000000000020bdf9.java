import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.stream.Collectors;

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

		Comparator<Interval> byStart = Comparator.comparingInt(v -> v.start);
		Comparator<Interval> byEnd = Comparator.comparingInt(v -> v.end);
		Interval[] copy = Arrays.copyOf(intervals, intervals.length);
		Arrays.sort(copy, byStart.thenComparing(byEnd));

		for (Interval interval : copy)
		{
			if (isFree(jamieSchedule, interval))
			{
				book(jamieSchedule, interval);
				interval.who = "J";
			}
			else if (isFree(cameronSchedule, interval))
			{
				book(cameronSchedule, interval);
				interval.who = "C";
			}
			else
			{
				return "IMPOSSIBLE";
			}
		}

		String who = Arrays.stream(intervals)
						.map(v -> v.who)
						.collect(Collectors.joining());

		return who;
	}

	private void book(int[] schedule, Interval interval)
	{
		for (int i = interval.start; i <= interval.end; i++)
			schedule[i] = 1;
	}

	private boolean isFree(int[] schedule, Interval interval)
	{
		for (int i = interval.start; i <= interval.end; i++)
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
				intervals[j].end = scanner.nextInt() - 1;
			}

			test(i, intervals);
		}
	}

	public static class Interval
	{
		int end;
		int start;
		String who;

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
