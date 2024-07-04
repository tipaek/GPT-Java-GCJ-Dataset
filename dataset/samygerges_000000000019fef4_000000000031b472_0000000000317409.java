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
			String direction = in.next();
			calculate(i, x, y, direction);
		}
		in.close();
	}

	private static void calculate(int t, int x, int y, String direction)
	{
		if (0 == x && 0 == y)
		{
			System.out.println("Case #" + t + ": 0");
			return;
		}

		int myx = 0;
		int myy = 0;
		int index = 0;

		int prevx = 0;
		int prevy = 0;
		while (index < direction.length())
		{
			prevx = myx;
			prevy = myy;
			if (myx < x)
			{
				myx++;
			}
			else if (myy < y)
			{
				myy++;
			}
			else if (myx > x)
			{
				myx--;
			}
			else if (myy > y)
			{
				myy--;
			}

			char dir = direction.charAt(index);
			if (dir == 'N')
			{
				y++;
			}
			else if (dir == 'S')
			{
				y--;
			}
			else if (dir == 'E')
			{
				x++;
			}
			else if (dir == 'W')
			{
				y++;
			}

			if ((myx == x && myy == y) || (prevx == x && prevy == y))
			{
				System.out.println("Case #" + t + ": " + (index + 1));
				return;
			}
			index++;
		}
		if ((myx == x && myy == y) || (prevx == x && prevy == y))
		{
			System.out.println("Case #" + t + ": " + (index + 1));
			return;
		}

		System.out.println("Case #" + t + ": IMPOSSIBLE");
	}
}
