import java.io.InputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

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
		Solution vest = new Solution(System.in, System.out);
		vest.go();
	}

	public void test(int testNum, int[][] square)
	{
		int trace = trace(square);
		int wrongRows = 0;
		int wrongCols = 0;

		for (int rowNum = 0; rowNum < square.length; rowNum++)
		{
			Set<Integer> rowValues = new HashSet<>();
			for (int colNum = 0; colNum < square.length; colNum++)
			{
				rowValues.add(square[rowNum][colNum]);
			}

			if (square.length != rowValues.size())
				wrongRows++;
		}

		for (int colNum = 0; colNum < square.length; colNum++)
		{
			Set<Integer> colValues = new HashSet<>();
			for (int rowNum = 0; rowNum < square.length; rowNum++)
			{
				colValues.add(square[rowNum][colNum]);
			}

			if (square.length != colValues.size())
				wrongCols++;
		}

		out.println("Case #" + testNum + ": " + trace + " " + wrongRows + " " + wrongCols);
	}

	public int trace(int[][] square)
	{
		int trace = 0;
		for (int i = 0; i < square.length; i++)
			trace += square[i][i];
		return trace;
	}

	void go()
	{
		int tests = scanner.nextInt();

		for (int i = 1; i <= tests; i++)
		{
			int squareSize = scanner.nextInt();
			int square[][] = new int[squareSize][squareSize];

			for (int line = 0; line < squareSize; line++)
			{
				for (int col = 0; col < squareSize; col++)
				{
					square[line][col] = scanner.nextInt();
				}
			}
			test(i, square);
		}
	}
}
