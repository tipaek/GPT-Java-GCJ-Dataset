import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int noOfTestCases = Integer.parseInt(in.nextLine());

		for (int a = 1; a <= noOfTestCases; a++) {
			int matrixSize = Integer.parseInt(in.nextLine());
			int[][] matrix = new int[matrixSize][matrixSize];

			for (int i = 0; i < matrixSize; i++) {
				String line = in.nextLine();
				String[] elements = line.split(" ");
				int[] arrayInt = Arrays.asList(elements).stream().mapToInt(Integer::parseInt).toArray();
				matrix[i] = arrayInt;
			}

			int k = 0;
			int r = 0;
			int c = 0;
			for (int i = 0; i < matrixSize; i++) {

				Set<Integer> rowSet = new HashSet<>();
				Set<Integer> colSet = new HashSet<>();
				Boolean rowFlag = false;
				Boolean colFlag = false;
				for (int j = 0; j < matrixSize; j++) {

					if (i == j) {
						k = k + matrix[i][j];
					}

					if (rowSet.contains(matrix[i][j])) 
						rowFlag = true;
					 else
						 rowSet.add(matrix[i][j]);

					if (colSet.contains(matrix[j][i])) 
						colFlag = true;
					 else
						 colSet.add(matrix[j][i]);

				}
				if (rowFlag)
					r++;
				if (colFlag)
					c++;

			}
			System.out.println("Case #" + a + ": " + k + " " + r + " " + c);

		}
		in.close();
	}
}
