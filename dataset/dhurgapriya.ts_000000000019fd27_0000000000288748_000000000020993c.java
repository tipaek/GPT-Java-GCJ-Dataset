import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Vestigium {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		for (int i = 0; i < t; i++) {
			// K -> trace of the matrix
			// R -> no. of rows with duplicates
			// C -> no. of columns with duplicates
			calculateKRC(i);
		}

	}

	@SuppressWarnings("resource")
	private static void calculateKRC(int caseNumber) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[][] data = new int[n][n];
		for (int row = 0; row < data.length; row++) {
			for (int col = 0; col < data[row].length; col++) {
				data[row][col] = in.nextInt();
			}
		}
		System.out.println(Arrays.deepToString(data));
		int trace = 0;
		for (int row = 0; row < data.length; row++) {
			for (int col = 0; col < data[row].length; col++) {
				if (row == col) {
					trace = trace + data[row][col];
				}
			}
		}
		int row = 0;
		for (int[] r : data) {
			List<Integer> rowList = Arrays.stream(r).boxed().collect(Collectors.toList());
			Set<Integer> rowData = rowList.stream().collect(Collectors.toSet());
			if (n > rowData.size()) {
				row++;
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int temp = data[i][j];
				data[i][j] = data[j][i];
				data[j][i] = temp;
			}
		}
		int col = 0;
		for (int[] c : data) {
			List<Integer> colList = Arrays.stream(c).boxed().collect(Collectors.toList());
			Set<Integer> colData = colList.stream().collect(Collectors.toSet());
			if (n > colData.size()) {
				col++;
			}
		}
		System.out.printf("Case#", caseNumber);
		System.out.print(" ");
		System.out.print(trace);
		System.out.print(" ");
		System.out.print(row);
		System.out.print(" ");
		System.out.print(col);
	}
}
