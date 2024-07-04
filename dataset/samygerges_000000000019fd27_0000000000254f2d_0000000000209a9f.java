import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = Integer.parseInt(in.nextLine());
		for (int i = 1; i <= t; ++i)
		{
			String s = in.nextLine();
			String res = compute(s);
			System.out.println("Case #" + i + ": " + res);
		}
		in.close();
	}

	private static String compute(String s)
	{
		StringBuilder sb = new StringBuilder();
		int open = 0;
		int closed = 0;
		for (int i = 0; i < s.length(); i++)
		{
			if (Character.isDigit(s.charAt(i)))
			{
				int n = Integer.valueOf(s.charAt(i) - 48);
				String num = "" + n;
				while (i + 1 < s.length() && (Integer.valueOf(s.charAt(i + 1) - 48) == n))
				{
					num += s.charAt(i + 1);
					i++;
				}
				if (open > n)
				{
					sb.append(getCloseParentheses(open - n));
					open -= (open - n);
					if (n == 0)
					{
						open = 0;
					}
				}
				else if (open < n)
				{
					sb.append(getOpenParentheses(n - open));
					open = n - open;
				}
				sb.append(num);
			}
			else
			{
				sb.append(getCloseParentheses(open));
				open = 0;
				sb.append(s.charAt(i));
			}
		}
		sb.append(getCloseParentheses(open));
		return sb.toString();
	}

	private static String getOpenParentheses(int n)
	{
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++)
		{
			sb.append("(");
		}
		return sb.toString();
	}

	private static String getCloseParentheses(int n)
	{
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++)
		{
			sb.append(")");
		}
		return sb.toString();
	}
}
