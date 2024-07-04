
import java.util.Arrays;
import java.util.Scanner;

public class Vestigium {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num_test_cases = in.nextInt();
		int trace, rows, cols, size;
		int[][] matrix;
		int[] row, col;
		
		for (int i = 1; i<=num_test_cases; i++) {
			trace = rows = cols = 0;
			size = in.nextInt();
			matrix = new int[size][size];
			for (int x = 0; x<size; x++) {
				for (int y = 0; y<size; y++) {
					matrix[x][y] = in.nextInt();
					if (x == y)
						trace += matrix[x][y];
				}
				row = Arrays.copyOf(matrix[x], size);
				Arrays.sort(row);
				for (int y = 1; y<size; y++) {
					if (row[y] == row[y-1]) {
						rows++;
						break;
					}
				}
			}
			col = new int[size];
			for (int y = 0; y<size; y++) {
				for (int x = 0; x<size; x++) {
					col[x] = matrix[x][y];
				}
				Arrays.sort(col);
				for (int x = 1; x<size; x++) {
					if (col[x] == col[x-1]) {
						cols++;
						break;
					}
				}
			}
			System.out.printf("Case #%d: %d %d %d\n", i, trace, rows, cols);
		}
		
		in.close();
	}

}
