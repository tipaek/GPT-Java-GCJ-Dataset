import java.util.*;
import java.io.*;

public class Solution
{
	private static BufferedReader infile = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer tokens;
	
	public static void main(String[] args) throws IOException
	{
		int numTestCases = Integer.parseInt(infile.readLine());
		for(int t = 1; t <= numTestCases; t++)
		{
			tokens = new StringTokenizer(infile.readLine());
			int numRanks = Integer.parseInt(tokens.nextToken());
			int numSuits = Integer.parseInt(tokens.nextToken());
			ArrayList<String> answers = new ArrayList<String>();
			for(int j = 1; j < numSuits; j++)
			{
				for(int i = 1; i < numRanks; i++)
					answers.add(i + " " + j);
				for(int i = numRanks - 1; i > 0; i--)
					answers.add(i + " " + (j + 1));
			}
			System.out.println("Case #" + t + ": " + answers.size());
			for(int i = 0; i < answers.size(); i++)
				System.out.println(answers.get(i));
		}
	}
}
