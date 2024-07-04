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

			int targetRow = (int) (Math.log(N) / Math.log(2));
			int difference = (int) (N - Math.round(Math.pow(2, targetRow)) + 1);

			System.out.printf("Case #%d:%n", caseNo);
			boolean leftToRight = true;
			if (targetRow % 2 == 1)
				leftToRight = false;
			for (int row = 1; row <= targetRow; row++)
			{
				if (leftToRight)
					for (int col = 1; col <= row; col++)
						System.out.printf("%d %d%n", row, col);
				else
					for (int col = row; col >= 1; col--)
						System.out.printf("%d %d%n", row, col);
				leftToRight = !leftToRight;
			}

			while (difference > 50)
			{
				targetRow++;
				for (int col = 1; col <= 2; col++)
					System.out.printf("%d %d%n", targetRow, col);
				difference -= targetRow;
				targetRow++;
				for (int col = 2; col >= 1; col--)
					System.out.printf("%d %d%n", targetRow, col);
				difference -= targetRow;
			}
			while (difference > 0)
			{
				targetRow++;
				System.out.printf("%d 1%n", targetRow);
				difference--;
			}

		}
		in.close();

	}
}
