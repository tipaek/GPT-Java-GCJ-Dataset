import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		int[][] dataArray = null;
		int[][] bufferArray = null;

		String assignedPath = "";

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testcases = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= testcases; i++) {
			int cPath = 0;
			int jPath = 0;

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
			
			 cPath = 0;
			 jPath = 0;
			 assignedPath="";
			// calculation
			for (int j = 0; j < dataArray.length; j++) {
				if (dataArray[j][2] == 0) {
					if (dataArray[j][0] >= jPath) {
						dataArray[j][2] = 1;
						jPath = dataArray[j][1];
						assignedPath = (assignedPath + "J");
					} else if (dataArray[j][0] >= cPath) {
						dataArray[j][2] = 1;
						cPath = dataArray[j][1];
						assignedPath = (assignedPath + "C");
					}
				}
			}
			for (int j = 1; j < dataArray.length; j++) {
				if (dataArray[j][2] == 0) {
					assignedPath = "IMPOSSIBLE";
				}
			}
			System.out.println("Case #" + i + ": " + assignedPath);
		}

	}
}