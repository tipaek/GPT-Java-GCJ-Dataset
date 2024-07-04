import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {

		try {

			int[][] dataArray = null;
			int k, r, c;
			Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
			int testcases = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
			int casevalue = 1;
			for (int i = 1; i <= testcases; i++) {
				k = 0;
				r = 0;
				c = 0;
				int matrix = in.nextInt();
				dataArray = new int[matrix][matrix];
				// datafilled in matrix
				for (int j = 0; j < dataArray.length; ++j) {
					for (int j2 = 0; j2 < dataArray.length; ++j2) {
						dataArray[j][j2] = in.nextInt();
					}
				}
				// calculation K
				for (int j = 0; j < dataArray.length; ++j) {
					for (int j2 = 0; j2 < dataArray.length; ++j2) {
						if (j == j2) {
							k = (k + dataArray[j][j2]);
						}
					}
				} // calculation row
				for (int j = 0; j < dataArray.length; ++j) {
					row: for (int j2 = 0; j2 < dataArray.length; ++j2) {
						for (int l = 0; l < dataArray.length; l++) {
							if (j2 != l) {
								if (dataArray[j][j2] == dataArray[j][l]) {
									r++;
									break row;
								}
							}
						}
					}
				}
				// calculation column
				for (int j = 0; j < dataArray.length; ++j) {
					row: for (int j2 = 0; j2 < dataArray.length; ++j2) {
						for (int l = 0; l < dataArray.length; l++) {
							if (j2 != l) {
								if (dataArray[j2][j] == dataArray[l][j]) {
									c++;
									break row;
								}
							}
						}
					}
				}
				System.out.print("Case #" + casevalue + ": " + k + " " + r + " " + c + "\n");
				++casevalue;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}