package codejam2020;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ParentingProblem
{
	private Scanner scanner;
	private InputStream in;
	private PrintStream out;

	public ParentingProblem(InputStream in, PrintStream out)
	{
		this.in = in;
		this.out = out;
		this.scanner = new Scanner(in);
	}

	public static void main(String args[])
	{
		ParentingProblem parentingproblem = new ParentingProblem(System.in, System.out);
		parentingproblem.go();
	}

	public void test(int testNum, Interval intervals[])
	{
		int cameronBusyStart = 0;
		int cameronBusyEnd = 0;
		int jamieBusyStart = 0;
		int jamieBusyEnd = 0;
		String who = "";

		for (int activity = 0; activity < intervals.length; activity++)
		{
			if (intervals[activity].start >= cameronBusyEnd)
			{
				cameronBusyEnd = intervals[activity].end;
				who += "C";
			}
			else if (intervals[activity].start >= jamieBusyEnd)
			{
				jamieBusyEnd = intervals[activity].end;
				who += "J";
			}
			else
			{
				who = "IMPOSSIBLE";
				break;
			}
		}

		out.println("Case #" + testNum + ": " + who);
	}

	void go()
	{
		int tests = scanner.nextInt();

		for (int i = 1; i <= tests; i++)
		{
			int activityNumber = scanner.nextInt();
			Interval intervals[] = new Interval[activityNumber];
			for (int j = 1; j <= activityNumber; j++)
			{
				intervals[j - 1] = new Interval();
				intervals[j - 1].start = scanner.nextInt();
				intervals[j - 1].end = scanner.nextInt();
			}

			Comparator<Interval> compareStart = Comparator.comparingInt(v -> v.start);
			Comparator<Interval> compareEnd = Comparator.comparingInt(v -> v.end);
			Arrays.sort(intervals, compareStart.thenComparing(compareEnd));

			test(i, intervals);
		}
	}

	class Interval
	{
		int end;
		int start;
	}
}
