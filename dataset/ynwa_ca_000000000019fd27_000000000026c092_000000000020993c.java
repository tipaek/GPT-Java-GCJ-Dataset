
import java.util.*;
import java.io.*;

public class Solution {
	private static boolean debug = false;
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCases = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		if (debug) System.out.println("testCases: " + testCases);
		for (int testCase = 1; testCase <= testCases; testCase++) {
			int size = in.nextInt();
			if (debug) System.out.println("size: " + size);
			int traceCell = 0;
			int traceValue = 0;
			int dupRowValues = 0;
			int dupColValues = 0;
			int[][] matrix = new int[size][size];
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					matrix[i][j] = in.nextInt();
					if (debug) System.out.println("cell[" + i + "][" + j + "]:" + matrix[i][j]);
					if (i == traceCell && j == traceCell) {
						traceValue = traceValue + matrix[i][j];
						traceCell++;
					}
				}
				boolean dupFound = false;
				for (int j = 0; j < size && !dupFound; j++) {
					for (int k = 1; k < size; k++) {
						if (k != j && matrix[i][j] == matrix[i][k]) {
							dupRowValues++;
							dupFound = true;
							if (debug) System.out.println("row dup " + i);
							break;
						}
					}
				}
			}
			for (int col = 0; col < size; col++) {
				if (debug) System.out.println("check column: " + col);
				boolean dupFound = false;
				for (int row=0;row < size && !dupFound; row++) {
					for (int rowCompare = 1; rowCompare < size && !dupFound; rowCompare++) {
						if (debug) System.out.println("matrix[" + row + "][" + col + "]:" + matrix[row][col] + " matrix[" + rowCompare + "][" + col + "]:" +  matrix[rowCompare][col]);
						if (row != rowCompare && matrix[row][col] == matrix[rowCompare][col]) {
							if (debug) System.out.println("col dup " + col);
							dupFound = true;
							dupColValues++;
						}
					}
				}
				if (debug) System.out.println("done checking column: " + col);
			}
			System.out.println("Case #" + testCase + ": " + traceValue + " " + dupRowValues + " " + dupColValues);
		}
	}
}
