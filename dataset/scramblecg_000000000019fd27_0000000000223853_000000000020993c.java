//package qround;

import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = Integer.parseInt(in.nextLine());
		for (int i = 0; i < t; ++i) {

			int matrixSize = Integer.parseInt(in.nextLine());

			int[][] mat = new int[matrixSize][matrixSize];

			int dupRowsCount = 0;
			int dupColsCount = 0;
			int trace = 0;

			Set<Integer> dupsSet;
			for (int r = 0; r < matrixSize; r++) {
				String[] rowChars = in.nextLine().split("\\s");
				for (int c = 0; c < matrixSize; c++) {
					mat[r][c] = Integer.parseInt(rowChars[c]);
				}
			}

			for (int x = 0; x < matrixSize; x++) {
				Set<Integer> rowSet = new TreeSet<Integer>();
				Set<Integer> colSet = new TreeSet<Integer>();
				boolean hasDupR = false;
				boolean hasDupC = false;

				for (int y = 0; y < matrixSize; y++) {
					if (!hasDupR) {
						hasDupR = !rowSet.add(mat[x][y]);
						if (hasDupR) {
							dupRowsCount++;
						}
					}
					if (!hasDupC) {
						hasDupC = !colSet.add(mat[y][x]);
						if (hasDupC) {
							dupColsCount++;
						}
					}
					if (hasDupC && hasDupR) {
						break;
					}
				}
				trace += mat[x][x];
			}

			System.out.println("Case #" + (i+1) + ": " + trace + " " + dupRowsCount + " " + dupColsCount);
		}
	}
}