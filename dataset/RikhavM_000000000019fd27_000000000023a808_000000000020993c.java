import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = null;
		try {
			in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
			int testCases = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
			for (int i = 1; i <= testCases; ++i) {
				int trace = 0;
				int rows = 0;
				int cols = 0;
				int n = in.nextInt();
				List<List<Integer>> matrix = new ArrayList<List<Integer>>();
				for (int i1 = 0; i1 < n; i1++) {
					List<Integer> temp = new ArrayList<Integer>();
					for (int i2 = 0; i2 < n; i2++) {
						temp.add(in.nextInt());
					}
					matrix.add(temp);
					if (isRepeated(temp)) {
						rows++;
					}
				}

				for (int i1 = 0; i1 < n; i1++) {
					if (isRepeated(getColumns(matrix, i1))) {
						cols++;
					}
				}
				trace = getSum(getMainDiagonal(matrix));

				output(i, trace, rows, cols);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (in != null) {
				in.close();
			}
		}
	}

	public static int getSum(List<Integer> input) {
		int sum = 0;
		for (Integer i : input) {
			sum = sum + i;
		}
		return sum;
	}

	public static List<Integer> getMainDiagonal(List<List<Integer>> matrix) {
		List<Integer> temp = new ArrayList<>();
		for (int i = 0; i < matrix.size(); i++) {
			temp.add(matrix.get(i).get(i));
		}
		return temp;
	}

	public static void output(int caseNumber, int trace, int rows, int cols) {
		System.out.println("Case #" + caseNumber + ": " + trace + " " + rows + " " + cols);
	}

	public static List<Integer> getColumns(List<List<Integer>> matrix, int columnNumber) {

		List<Integer> temp = new ArrayList<>();
		for (int i = 0; i < matrix.size(); i++) {
			temp.add(matrix.get(i).get(columnNumber));
		}
		return temp;
	}

	public static boolean isRepeated(List<Integer> input) {

		if (input.size() != new HashSet<Integer>(input).size()) {
			return true;
		}
		return false;
	}
}