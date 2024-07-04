import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Solution
{

	public static void main(String[] args) throws Exception
	{
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		int n = input.nextInt();
		if (n == 10)
		{
			for (int tt = 0; tt < t; tt++)
			{
				int b[] = new int[n];
				for (int i = 0; i < n; i++)
				{
					System.out.println(i + 1);
					b[i] = input.nextInt();
				}
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < n; i++)
				{
					sb.append(b[i]);
				}
				System.out.println(sb.toString());
				if (input.next().equals("N"))
					return;
			}

		} else if (n == 20)
		{
			for (int tt = 0; tt < t; tt++)
			{
				int samePos = -1;
				int same[] = new int[2];
				int diffPos = -1;
				int diff[] = new int[2];
				int b[] = new int[n];
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < 5; i++)
				{
					System.out.println(i + 1);
					b[i] = input.nextInt();
				}
				for (int i = 15; i < 20; i++)
				{
					System.out.println(i + 1);
					b[i] = input.nextInt();
					if (samePos == -1)
					{
						if (b[i] == b[19 - i])
						{
							samePos = i;
							same[0] = b[i];
						}
					}
					if (diffPos == -1)
					{
						if (b[i] != b[19 - i])
						{
							diffPos = i;
							diff[0] = b[i];
						}
					}
				}
				if (diffPos != -1 && samePos != -1)
				{
					int newsame[] = new int[2];
					int newdiff[] = new int[2];
					compute(input, newsame, newdiff, b, samePos, diffPos, same, diff);

					for (int i = 5; i < 13; i++)
					{
						System.out.println(i + 1);
						b[i] = input.nextInt();
					}
					compute(input, newsame, newdiff, b, samePos, diffPos, same, diff);
					for (int i = 13; i < 17; i++)
					{
						System.out.println(i + 1);
						b[i] = input.nextInt();
					}

				}
				else // first few didn't match
				{
					int oldsamePos=samePos;
					int olddiffPod=diffPos;
					samePos = -1;
					same = new int[2];
					diffPos = -1;
					diff = new int[2];
					//b= new int[n];
					sb = new StringBuilder();
					for (int i = 5; i < 10; i++)
					{
						System.out.println(i + 1);
						b[i] = input.nextInt();
					}
					for (int i = 10; i < 15; i++)
					{
						System.out.println(i + 1);
						b[i] = input.nextInt();
						if (samePos == -1)
						{
							if (b[i] == b[19 - i])
							{
								samePos = i;
								same[0] = b[i];
							}
						}
						if (diffPos == -1)
						{
							if (b[i] != b[19 - i])
							{
								diffPos = i;
								diff[0] = b[i];
							}
						}
					}
					if (diffPos != -1 && samePos != -1)
					{
						int newsame[] = new int[2];
						int newdiff[] = new int[2];
						compute(input, newsame, newdiff, b, samePos, diffPos, same, diff);

						for (int i = 0; i < 9; i++)
						{
							System.out.println(i + 1);
							b[i] = input.nextInt();
						}
						compute(input, newsame, newdiff, b, samePos, diffPos, same, diff);
						for (int i = 9; i < 10; i++)
						{
							System.out.println(i + 1);
							b[i] = input.nextInt();
						}

					}
				}
				for (int i = 0; i < n; i++)
				{
					sb.append(b[i]);
				}
				System.out.println(sb.toString());
				if (input.next().equals("N"))
					return;

			}
		}
		input.close();
	}

	private static void compute(Scanner input, int[] newsame, int[] newdiff, int[] b, int samePos, int diffPos, int[] same, int[] diff)
	{

		System.out.println(samePos + 1);
		newsame[0] = input.nextInt();

		System.out.println(diffPos + 1);
		newdiff[0] = input.nextInt();

		int x = compare(newsame, same);
		int y = compare(newdiff, diff);
		if (x == 0 && y == 0)
		{
			// case d

		} else if (x == 1 && y == 0)
		{
			b = compliment(b);
			b = reverse(b);

		} else if (x == 0 && y == 1)
		{
			b = compliment(b);
		} else
		{
			b = reverse(b);
		}
		b[samePos] = newsame[0];
		b[diffPos] = newdiff[0];

		same[0] = newsame[0];
		diff[0] = newdiff[0];

	}

	private static int compare(int[] newsame, int[] same)
	{
		if (newsame[0] == same[0])
		{
			return 0;
		}
		return 1;
	}

	public static int[] reverse(int a[])
	{
		Collections.reverse(Arrays.asList(a));
		return a;
	}

	public static int[] compliment(int a[])
	{
		for (int i = 0; i < a.length; i++)
		{
			if (a[i] == 0)
				a[i] = 1;
			else
				a[i] = 0;
		}
		return a;
	}

}
