import java.io.*;
import java.util.StringTokenizer;

public class Parenting
{
	public static boolean[] CBusy;
	public static boolean[] JBusy;

	// Hopefully OK since only 1440 time slots
	public static char assignAct(int start, int end)
	{
		boolean giveToC = true;
		boolean giveToJ = true;
		for (int time = start; time < end && (giveToC || giveToJ); time++)
		{
			if (CBusy[time])
				giveToC = false;
			if (JBusy[time])
				giveToJ = false;
		}
		// First priority just give to C
		if (giveToC)
		{
			for (int time = start; time < end; time++)
				CBusy[time] = true;
			return 'C';
		}
		else if (giveToJ)
		{
			for (int time = start; time < end; time++)
				JBusy[time] = true;
			return 'J';
		}
		else
			return 'X';
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

			StringBuilder answer = new StringBuilder();
			boolean stillPossible = true;
			for (int activity = 0; activity < N; activity++)
			{
				StringTokenizer data = new StringTokenizer(in.readLine());
				int start = Integer.parseInt(data.nextToken());
				int end = Integer.parseInt(data.nextToken());
				if (stillPossible)
				{
					char assignToWho = assignAct(start, end);
					if (assignToWho == 'X')
					{
						stillPossible = false;
						answer = new StringBuilder("IMPOSSIBLE");
					}
					else
						answer.append(assignToWho);
				}
			}

			System.out.printf("Case #%d: %S%n", caseNo, answer);
		}
		in.close();

	}
}
