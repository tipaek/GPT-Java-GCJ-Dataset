import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		Solution nestingdepth = new Solution(System.in, System.out);
		nestingdepth.go();
	}

	public void test(int testNum, String input)
	{
		for (int i = 1; i <= 9; i++)
		{
			input = surroundNumber(input, i);
		}

		out.println("Case #" + testNum + ": " + input);
	}

	public String surroundNumber(String input, int number)
	{
		List<Match> matches = find(input, number);
		StringBuilder sb = new StringBuilder(input);

		for (Match m : matches)
		{
			if (sb.charAt(m.from) != '(' || sb.charAt(m.to) != ')')
			{
				sb.insert(m.to + 1, ')');
				sb.insert(m.from, '(');
			}
		}

		return sb.toString();
	}

	public List<Match> find(String input, int numberToFind)
	{
		char ch = Character.forDigit(numberToFind, 10);
		int startAt = input.length() - 1;
		List<Match> matches = new ArrayList<>();

		input = replaceBracketed(input, numberToFind);
		int endLocation = input.lastIndexOf(ch, startAt);

		while (endLocation >= 0)
		{
			int startLocation = endLocation - 1;
			while (startLocation >= 0 && input.charAt(startLocation) == ch)
			{
				startLocation--;
			}

			Match match = new Match(startLocation + 1, endLocation);
			matches.add(match);

			endLocation = input.lastIndexOf(ch, startLocation);
		}

		return matches;
	}

	public String replaceBracketed(String input, int numberToFind)
	{
		for (int i = 1; i < numberToFind; i++)
		{
			char[] inputArray = input.toCharArray();
			char replaceChar = Character.forDigit(i + 1, 10);

			String regex = "\\(" + i + "+\\)";
			Matcher m = Pattern.compile(regex).matcher(input);
			while (m.find())
			{
				int s = m.start();
				int e = m.end();
				for (int j = s; j < e; j++)
					inputArray[j] = replaceChar;
			}

			input = new String(inputArray);
		}
		return input;
	}

	void go()
	{
		int tests = scanner.nextInt();

		for (int i = 1; i <= tests; i++)
		{
			String input = scanner.next();
			test(i, input);
		}
	}

	static class Match
	{
		int from;
		int to;

		public Match(int from, int to)
		{
			this.from = from;
			this.to = to;
		}

		@Override
		public boolean equals(Object o)
		{
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;
			Match match = (Match) o;
			return from == match.from &&
							to == match.to;
		}

		@Override
		public int hashCode()
		{
			return Objects.hash(from, to);
		}

		@Override
		public String toString()
		{
			return new StringJoiner(", ", Match.class.getSimpleName() + "[", "]")
							.add("from=" + from)
							.add("to=" + to)
							.toString();
		}
	}
}
