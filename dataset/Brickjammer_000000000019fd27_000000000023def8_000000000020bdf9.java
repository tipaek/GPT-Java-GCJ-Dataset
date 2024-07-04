import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

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
		int[] cameronSchedule = new int[24 * 60 + 1];
		int[] jamieSchedule = new int[24 * 60 + 1];
		String who = "";

		for (Interval interval : intervals)
		{
			if (isFree(cameronSchedule, interval))
			{
				book(cameronSchedule, interval);
				who += "C";
			}
			else if (isFree(jamieSchedule, interval))
			{
				book(jamieSchedule, interval);
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
			Interval intervals[] = new Interval[activityNumber];
			for (int j = 1; j <= activityNumber; j++)
			{
				intervals[j - 1] = new Interval();
				intervals[j - 1].start = scanner.nextInt();
				intervals[j - 1].end = scanner.nextInt();
			}

			test(i, intervals);
		}
	}

	class Interval
	{
		int end;
		int start;
	}
}
