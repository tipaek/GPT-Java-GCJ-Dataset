import java.io.*;
import java.util.StringTokenizer;

public class Solution
{
	public static void main(String[] args) throws IOException
	{

		BufferedReader in = new BufferedReader(new InputStreamReader
		(System.in));

		int noOfCases = Integer.parseInt(in.readLine());

		for (int caseNo = 1; caseNo <= noOfCases; caseNo++)
		{
			StringTokenizer data = new StringTokenizer(in.readLine());
			int X = Integer.parseInt(data.nextToken());
			int Y = Integer.parseInt(data.nextToken());
			String M = data.nextToken();

			boolean found = false;
			int minute = 0;
			for (minute = 0; minute < M.length() && !found; minute++)
			{
				char move = M.charAt(minute);
				if (move == 'N')
					Y++;
				else if (move == 'S')
					Y--;
				else if (move == 'E')
					X++;
				else
					X--;
				int distance = Math.abs(X) + Math.abs(Y);
				if (distance <= minute + 1)
					found = true;
			}
			if (found)
				System.out.printf("Case #%d: %d%n", caseNo, minute);
			else
				System.out.printf("Case #%d: IMPOSSIBLE%n", caseNo);
		}
		in.close();
	}
}
