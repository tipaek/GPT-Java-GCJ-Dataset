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

			int targetRow = (int) (Math.log(N)/Math.log(2));
			int difference = (int) (N - Math.round( Math.pow(2, targetRow))+1);
			
			System.out.printf("Case #%d:%n", caseNo);
			for (int row = 1; row <= targetRow; row++)
			{
				for (int col = 1; col <= row; col++)
					System.out.printf("%d %d%n", row, col);
			}
			while (difference > 0)
			{
				targetRow++;
				System.out.printf("%d 1%n",targetRow);
				difference --;
			}
			
		}
		in.close();
	}
}
