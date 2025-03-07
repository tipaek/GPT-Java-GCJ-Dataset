import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		for (int i = 1; i <= cases; i++) {
			int size = sc.nextInt();
			int[][] matrix = new int[size][size];

			sc.nextLine();
			int rowCount = 0, colCount = 0, trace = 0;
			for (int row = 0; row < size; row++) {
				String[] inputs = sc.nextLine().split(" ");
				boolean rowDuplicate = true;
				for (int col = 0; col < size; col++) {
					Set<Integer> set = new HashSet<>();
					matrix[row][col] = Integer.parseInt(inputs[col]);
					if (row == col)
						trace += matrix[row][col];
					boolean duplicate = set.add(matrix[row][col]);
					if (!duplicate)
						rowDuplicate = duplicate;
				}
				if (!rowDuplicate)
					rowCount++;

			}
			for(int col=0;col<size;col++) {
				boolean colDuplicate = true;
				for (int row = 0; row < size; row++) {
					Set<Integer> set = new HashSet<>();
					boolean duplicate = set.add(matrix[row][col]);
					if (!duplicate)
						colDuplicate = duplicate;
				}
				if (!colDuplicate)
					colCount++;
			}
			System.out.print("Case #" + cases + ": " + trace + " " + rowCount + " " + colCount);
		}

	}
}