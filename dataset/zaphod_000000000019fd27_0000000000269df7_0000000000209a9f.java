import java.io.*;

public class Solution
{
	public static void main(String[] args) throws IOException
	{
		 BufferedReader in = new BufferedReader(new InputStreamReader
		 (System.in));

		int noOfCases = Integer.parseInt(in.readLine());

		for (int caseNo = 1; caseNo <= noOfCases; caseNo++)
		{
			String S = in.readLine();
			StringBuilder result = new StringBuilder();
			int current = 0;
			for (int i=0; i < S.length(); i++)
			{
				char nextCh = S.charAt(i);
				int nextNo = nextCh -'0';
				if (nextNo > current)
				{
					int leftToAdd = nextNo - current;
					for (int left = 0; left < leftToAdd; left++)
						result.append('(');
				}
				else if (nextNo < current)
				{
					int rightToAdd = current - nextNo;
					for (int right = 0; right < rightToAdd; right++)
						result.append(')');
				}
				result.append(nextCh);
				current = nextNo;
			}
			
			// Add in last closing parenthesis
			for (int right = 0; right < current; right++)
				result.append(')');
			
			System.out.printf("Case #%d: %s%n", caseNo, result);
		}
		in.close();
	}
}
