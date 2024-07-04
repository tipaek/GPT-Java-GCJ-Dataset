import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution
{
	public static boolean[] CBusy;
	public static boolean[] JBusy;

	// Hopefully OK since only 1440 time slots
	public static boolean assignAct(Activity next)
	{
		boolean giveToC = true;
		boolean giveToJ = true;
		for (int time = next.start; time < next.end && (giveToC || giveToJ); time++)
		{
			if (CBusy[time])
				giveToC = false;
			if (JBusy[time])
				giveToJ = false;
		}
		// First priority just give to C
		if (giveToC)
		{
			for (int time = next.start; time < next.end; time++)
				CBusy[time] = true;
			next.whoDoes = 'C';
			return true;
		}
		else if (giveToJ)
		{
			for (int time = next.start; time < next.end; time++)
				JBusy[time] = true;
			next.whoDoes = 'J';
			return true;
		}
		else
			return false;
	}

	public static void main(String[] args) throws IOException
	{

		BufferedReader in = new BufferedReader(new InputStreamReader
		(System.in));

		int noOfCases = Integer.parseInt(in.readLine());

		for (int caseNo = 1; caseNo <= noOfCases; caseNo++)
		{
			int N = Integer.parseInt(in.readLine());
			CBusy = new boolean[1440];
			JBusy = new boolean[1440];

			Activity[] activities = new Activity[N];
			for (int activity = 0; activity < N; activity++)
			{
				StringTokenizer data = new StringTokenizer(in.readLine());
				activities[activity] = new Activity(Integer.parseInt(data
						.nextToken()), Integer.parseInt(data.nextToken()),
						activity);
			}

			Arrays.sort(activities);

			boolean stillPossible = true;
			for (int activity = 0; activity < N && stillPossible; activity++)
				stillPossible = assignAct(activities[activity]);

			if (stillPossible)
			{
				Arrays.sort(activities, Activity.ORIGINAL_ORDER);
				StringBuilder answer = new StringBuilder();
				for (int activity = 0; activity < N; activity++)
					answer.append(activities[activity].whoDoes);

				System.out.printf("Case #%d: %S%n", caseNo, answer);
			}
			else
				System.out.printf("Case #%d: IMPOSSIBLE%n", caseNo);
		}
		in.close();
	
	}
}

class Activity implements Comparable<Activity>
{
	int start, end;
	int order;
	char whoDoes;

	public Activity(int start, int end, int order)
	{
		this.start = start;
		this.end = end;
		this.order = order;
	}

	public String toString()
	{
		return String.format("(%d, %d) %d %c", start, end, order, whoDoes);
	}

	@Override
	public int compareTo(Activity other)
	{
		if (this.start == other.start)
			return this.end - other.end;

		return this.start - other.start;
	}

	public static final Comparator<Activity> ORIGINAL_ORDER = new OriginalOrder();
	private static class OriginalOrder implements Comparator<Activity>
	{
		public int compare(Activity first, Activity second)
		{
			return first.order - second.order;
		}
	}
}