import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for (int i = 1; i <= t; ++i)
		{
			int x = in.nextInt();
			int y = in.nextInt();
			calculate(x, y, i);
		}
		in.close();
	}

	private static void calculate(int x, int y, int t)
	{
		String xs = Integer.toBinaryString(Math.abs(x));
		String ys = Integer.toBinaryString(Math.abs(y));
		int max = Math.max(xs.length(), ys.length());

		int[] arrx = new int[max + 1];
		int[] arry = new int[max + 1];
		int index = 0;
		for (int i = xs.length() - 1; i >= 0; i--)
		{
			arrx[index++] = xs.charAt(i) == '1' ? 1 : 0;
		}
		index = 0;
		for (int i = ys.length() - 1; i >= 0; i--)
		{
			arry[index++] = ys.charAt(i) == '1' ? 1 : 0;
		}

		char[] moves = new char[max + 1];

		for (int i = 0; i < max + 1; i++)
		{
			if (arrx[i] == 1 && arry[i] == 0)
			{
				moves[i] = x > 0 ? 'E' : 'W';
			}
			else if (arrx[i] == 0 && arry[i] == 1)
			{
				moves[i] = x > 0 ? 'N' : 'S';
			}
			else if (arrx[i] == 0 && arry[i] == 0)
			{
				if (i + 1 >= xs.length() && i + 1 >= ys.length())
				{
					break;
				}
				System.out.println("Case #" + t + ": IMPOSSIBLE");
				return;
			}
			else
			{
				if (i - 1 >= 0)
				{
					if (moves[i - 1] == 'S')
					{
						for (int j = i - 1; j >= 0; j--)
						{
							moves[j] = moves[j] == 'S' ? 'N' : moves[j];
						}
						moves[i] = x > 0 ? 'E' : 'W';
						int tmp = i + 1;
						while (tmp < arry.length && arry[tmp] != 0)
						{
							tmp++;
						}
						if (tmp < arry.length)
						{
							arry[tmp] = 1;
						}
						else
						{
							System.out.println("Case #" + t + ": IMPOSSIBLE");
							return;
						}
					}
					else if (moves[i - 1] == 'N')
					{
						for (int j = i - 1; j >= 0; j--)
						{
							moves[j] = moves[j] == 'N' ? 'S' : moves[j];
						}
						moves[i] = x > 0 ? 'E' : 'W';
						int tmp = i + 1;
						while (tmp < arry.length && arry[tmp] != 0)
						{
							tmp++;
						}
						if (tmp < arry.length)
						{
							arry[tmp] = 1;
						}
						else
						{
							System.out.println("Case #" + t + ": IMPOSSIBLE");
							return;
						}
					}
					else if (moves[i - 1] == 'E')
					{
						for (int j = i - 1; j >= 0; j--)
						{
							moves[j] = moves[j] == 'E' ? 'W' : moves[j];
						}
						moves[i] = y > 0 ? 'N' : 'S';
						int tmp = i + 1;
						while (tmp < arrx.length && arrx[tmp] != 0)
						{
							tmp++;
						}
						if (tmp < arrx.length)
						{
							arrx[tmp] = 1;
						}
						else
						{
							System.out.println("Case #" + t + ": IMPOSSIBLE");
							return;
						}
					}
					if (moves[i - 1] == 'W')
					{
						for (int j = i - 1; j >= 0; j--)
						{
							moves[j] = moves[j] == 'W' ? 'E' : moves[j];
						}
						moves[i] = y > 0 ? 'N' : 'S';
						int tmp = i + 1;
						while (tmp < arrx.length && arrx[tmp] != 0)
						{
							tmp++;
						}
						if (tmp < arrx.length)
						{
							arrx[tmp] = 1;
						}
						else
						{
							System.out.println("Case #" + t + ": IMPOSSIBLE");
							return;
						}
					}
				}
				else
				{
					System.out.println("Case #" + t + ": IMPOSSIBLE");
					return;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (char c : moves)
		{
			sb.append(c);
		}
		System.out.println("Case #" + t + ": " + sb);
	}

}
