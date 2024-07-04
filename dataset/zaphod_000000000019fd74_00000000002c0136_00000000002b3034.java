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
			int N = Integer.parseInt(in.readLine());

			String[] P = new String[N];
			String name = "";
			for (int i = 0; i < N; i++)
			{
				String next = in.readLine();
				P[i] = next;
				if (next.length() > name.length())
					name = next;
			}
			
			// Quick for first test case
			boolean ok = true;
			name = name.substring(1);
			for (int i = 0; i < N && ok; i++)
			{
				if (name.endsWith(P[i].substring(1)))
				{
					ok = false;
					name  = "*";
				}
			}
			


			System.out.printf("Case #%d: %s%n", caseNo, name);
		}
		in.close();

	}
}