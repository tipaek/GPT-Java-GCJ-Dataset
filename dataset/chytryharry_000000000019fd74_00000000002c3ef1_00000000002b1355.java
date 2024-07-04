import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			int rows = in.nextInt();
			int columns = in.nextInt();
			int[][] matrix = new int[rows][columns];
			for (int j = 0; j < rows; j++) {
				for (int k = 0; k < columns; k++) {
					matrix[j][k] = in.nextInt();
				}
			}
			System.out.println("Case #" + i + ": " + play(matrix, rows, columns));
		}
	}

	private static int play(int[][] matrix, int rows, int columns) {
		int[][] tempTable = new int[rows][columns];
		for (int j = 0; j < rows; j++) {
			for (int k = 0; k < columns; k++) {
				tempTable[j][k] = matrix[j][k];
			}
		}

		boolean endOfGame = false;
		int intrestedLevel = 0;
		while (!endOfGame) {
			boolean temp = true;
			boolean[] checks = new boolean[rows*columns];
			for (int i = 0; i < rows*columns;i++) {
				checks[i] = true;
			}
			for (int j = 0; j < rows; j++) {
				for (int k = 0; k < columns; k++) {
					int tempIdx = k;
					if (matrix[j][k] == -1) {
						continue;
					} else {
						int neigh = 0;
						int sum = 0;
						while (true) {
							if (tempIdx + 1 < columns && matrix[j][tempIdx + 1] != -1) {
								sum+=matrix[j][tempIdx+1];
								neigh++;
								break;
							} else if (tempIdx + 1 < columns && matrix[j][tempIdx + 1] == -1) {
								tempIdx++;
							} else {
								break;
							}
						}
						tempIdx = k;
						while (true) {
							if (tempIdx - 1 >= 0 && matrix[j][tempIdx -1] != -1) {
								sum+=matrix[j][tempIdx-1];
								neigh++;
								break;
							} else if (tempIdx - 1 >= 0 && matrix[j][tempIdx -1] == -1) {
								tempIdx--;
							} else {
								break;
							}
						}
						tempIdx = j;
						while (true) {
							if (tempIdx - 1 >= 0 && matrix[tempIdx - 1][k] != -1) {
								sum+=matrix[tempIdx-1][k];
								neigh++;
								break;
							} else if (tempIdx - 1 >= 0 && matrix[tempIdx -1][k] == -1) {
								tempIdx--;
							} else {
								break;
							}
						}
						tempIdx = j;
						while (true) {
							if (tempIdx + 1 < rows && matrix[tempIdx+1][k] != -1) {
								sum+=matrix[tempIdx+1][k];
								neigh++;
								break;
							} else if (tempIdx + 1 < rows && matrix[tempIdx+1][k] == -1) {
								tempIdx++;
							} else {
								break;
							}
						}

						double average = 0;
						if (neigh != 0) {
							average = (double)sum/(double)neigh;
						}

						intrestedLevel+=matrix[j][k];
						if ((double)matrix[j][k] < average) {
							tempTable[j][k] = -1;
							checks[j*k] = false;
						}
					}
				}
			}
			for (int i = 0; i < rows*columns;i++) {
				if (!checks[i]) {
					temp=false;
				}
			}
			matrix = tempTable;
			endOfGame = temp;
		}
		return intrestedLevel;
	}
}
