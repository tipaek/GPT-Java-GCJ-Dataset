
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

		}
		input.close();
	}

	public int[] reverse(int a[])
	{
		Collections.reverse(Arrays.asList(a));
		return a;
	}

	public int[] compliment(int a[])
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
