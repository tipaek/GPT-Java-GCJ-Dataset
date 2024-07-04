import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {

		try {

			int[][] dataArray = null;
			int[][] bufferArray = null;
			int cPath, jPath = 0;
			String assignedPath = "";

			Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
			int testcases = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
			for (int i = 1; i <= testcases; i++) {
				assignedPath = "";
				int scheduleCount = in.nextInt();
				dataArray = new int[scheduleCount][3];
				for (int j = 0; j < scheduleCount; j++) {
					for (int j2 = 0; j2 < 2; j2++) {
						dataArray[j][j2] = in.nextInt();
						dataArray[j][2] = 0;
					}
				}

				// sorting the array schedule
				for (int j = 0; j < dataArray.length; j++) {
					for (int j2 = j; j2 < (dataArray.length - 1); j2++) {
						bufferArray = new int[1][2];
						if (dataArray[j2][0] > dataArray[j2 + 1][0]) {

							bufferArray[0][0] = dataArray[j2][0];
							bufferArray[0][1] = dataArray[j2][1];

							dataArray[j2][0] = dataArray[j2 + 1][0];
							dataArray[j2][1] = dataArray[j2 + 1][1];

							dataArray[j2 + 1][0] = bufferArray[0][0];
							dataArray[j2 + 1][1] = bufferArray[0][1];

						}
					}
				}

				// initial assignment
				cPath = dataArray[0][1];
				dataArray[0][2] = 1;
				assignedPath = (assignedPath + "C");
				// calculation
				for (int j = 1; j < dataArray.length; j++) {

					if (dataArray[j][2] == 0) {
						if (dataArray[j][0] >= cPath) {
							dataArray[j][2] = 1;
							cPath = dataArray[j][1];
							assignedPath = (assignedPath + "C");
						} else if (dataArray[j][0] >= jPath) {
							dataArray[j][2] = 1;
							jPath = dataArray[j][1];
							assignedPath = (assignedPath + "J");
						}
					}
				}
				for (int j = 1; j < dataArray.length; j++) {
					if (dataArray[j][2] == 0) {
						assignedPath = "IMPOSSIBLE";
					}

				}

				// print
				for (int j = 0; j < dataArray.length; j++) {
					// System.out.println(dataArray[j][0] + "-" + dataArray[j][1] + "-" +
					// dataArray[j][2]);
				}

				System.out.println("Case #" + i + ": " + assignedPath);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}