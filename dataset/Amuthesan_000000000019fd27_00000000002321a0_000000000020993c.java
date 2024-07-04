import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			int length = in.nextInt();
			int[][] array = new int[length][length];
			int dupRows = 0, dupCol = 0, trace = 0;
			for (int j = 0; j < length; j++) {
				for (int k = 0; k < length; k++) {
					array[j][k] = in.nextInt();
					if (j == k) {
						trace += array[j][k];
					}
				}
				if (hasDuplicate(array[j])) {
					dupRows++;
				}
			}

			for (int j = 0; j < length; j++) {
				if (hasDuplicate(getColumn(array, j))) {
					dupCol++;
				}
			}
			System.out.println("Case #" + i + ": " + trace + " " + dupRows + " " + dupCol);
		}
	}

	private static boolean hasDuplicate(int[] sample) {
		for (int i = 0; i < sample.length; i++) {
			for (int j = i + 1; j < sample.length; j++) {
				if (sample[i] == (sample[j])) {
					return true;
				}
			}
		}
		return false;

	}

	public static int[] getColumn(int[][] array, int index) {
		int[] column = new int[array[0].length];
		for (int i = 0; i < column.length; i++) {
			column[i] = array[i][index];
		}
		return column;
	}

}
