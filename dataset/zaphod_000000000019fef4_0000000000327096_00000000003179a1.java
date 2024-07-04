import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution
{
	public static void addAllToSet(Set<Character> set, String str)
	{
		for (int i = 0; i < str.length(); i++)
			set.add(str.charAt(i));
	}

	public static void addChToSet(Set<Character> set, char ch)
	{
		set.add(ch);
	}

	public static void main(String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader
		(System.in));

		int noOfCases = Integer.parseInt(in.readLine());

		for (int caseNo = 1; caseNo <= noOfCases; caseNo++)
		{
			int U = Integer.parseInt(in.readLine());

			Set<Character> allCh = new HashSet<Character>();
			Set<Character>[] nonNumber = new HashSet[10];
			for (int i = 0; i < 10; i++)
				nonNumber[i] = new HashSet<Character>();

			for (int i = 0; i < 1000; i++)
			{
				StringTokenizer data = new StringTokenizer(in.readLine());
				String Q = data.nextToken();
				String R = data.nextToken();
				addAllToSet(allCh, R);
				addChToSet(nonNumber[0], R.charAt(0));
				if (Q.length() == R.length())
				{
					int lower = Q.charAt(0) - '0' + 1;
					for (int next = lower; next < 10; next++)
						addChToSet(nonNumber[next], R.charAt(0));
				}

			}


			StringBuilder D = new StringBuilder("0000000000");
			for (char next : allCh)
				if (!nonNumber[0].contains(next))
					D.setCharAt(0, next);
			allCh.remove(D.charAt(0));
			
			for (int i = 9; i >= 1; i--)
			{
				char charToRemove = '0';
				for (char next : allCh)
					if (!nonNumber[i].contains(next))
					{
						D.setCharAt(i, next);
						charToRemove = next;
					}
				allCh.remove(charToRemove);
			}

			System.out.printf("Case #%d: %s%n", caseNo, D);
		}
		in.close();
	}
}