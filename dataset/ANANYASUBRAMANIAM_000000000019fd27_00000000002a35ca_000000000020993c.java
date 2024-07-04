
import java.util.Scanner;

class LatinSquares
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);

		int times = s.nextInt();
		int cases = 0;
		for (cases = 0; cases < times; cases++)
		{
			int n = s.nextInt();
			// s.next();
			String[][] square = new String[n][n];
			for (int i = 0; i < n; i++)
			{
				for (int ii = 0; ii < n; ii++)
				{
					square[i][ii] = s.next();

				}

			}
			int diagonalsum = 0;
			for (int i = 0; i < n; i++)
			{
				diagonalsum += Integer.parseInt(square[i][i]);
			}

			int repeatcol = 0;
			String word = "";
			for (int i = 0; i < n; i++)
			{

				for (int ii = 0; ii < n; ii++)
				{
					if (word.contains(square[ii][i]))
					{
						repeatcol++;
						ii = n;
						word = "";
					} else
					{
						word += square[ii][i];
					}
				}
			}
			int repeatrow = 0;
			word = "";
			for (int i = 0; i < n; i++)
			{
				word = "";
				for (int ii = 0; ii < n; ii++)
				{
					if (word.contains(square[i][ii]))
					{
						repeatrow++;
						ii = n;
						word = "";
					} else
					{
						word += square[i][ii];
					}
				}
			}

			System.out.println("Case #" + (cases + 1) + ": " + diagonalsum + " " + repeatrow + " " + repeatcol);
		}

		s.close();
	}
}
