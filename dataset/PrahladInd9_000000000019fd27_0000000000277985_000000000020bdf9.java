import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main (String[] args) {
		boolean debug = false;
		Scanner inputValue = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int vals2Loop = inputValue.nextInt();
		for (int i = 1; i <= vals2Loop; ++i) {
			int[][] main2DArray = new int[1440][2];
			boolean impossibleFlag = false;
			
			int w = inputValue.nextInt();
			int[][] solution2DArray = new int[w][2];
			int activityCount = 0;

			int[][] activitiesList = new int[w][3];
			for (int j = 0; j < w; j++) {
				activitiesList[j][0] = inputValue.nextInt();
				activitiesList[j][1] = inputValue.nextInt();
				activitiesList[j][2] = activityCount++;
				
				if (debug) {
					System.out.println("" + activitiesList[j][0] + " " + activitiesList[j][1]);
				}
			}

			Arrays.sort(activitiesList, new java.util.Comparator<int[]>() {
				public int compare(int[] a, int[] b) {
					return Integer.compare(a[0], b[0]);
				}
			});

			for (int j = 0; j < w; j++) {
				int startTime = activitiesList[j][0];
				int endTime = activitiesList[j][1];
				int activityReference = activitiesList[j][2];
				boolean cameronFlag = true;
				boolean jamieFlag = true;

				for (int k = startTime; k < endTime; k++) {
					if (main2DArray[k][0] == 1) {
						cameronFlag = false;
					}
				}

				
				if (cameronFlag) {
					for (int k = startTime; k < endTime; k++) {
						main2DArray[k][0] = 1;
					}

					solution2DArray[j] = new int[] {activityReference, 1};
				} else {
					for (int k = startTime; k < endTime; k++) {
						if (main2DArray[k][1] == 1) {
							jamieFlag = false;
						}
					}

					if (jamieFlag) {
						for (int k = startTime; k < endTime; k++) {
							main2DArray[k][1] = 1;
						}
						solution2DArray[j] = new int[] {activityReference, 2};
					} else {
						impossibleFlag = true;
					}
				}
			}

			String solution = "";
			if (impossibleFlag) {
				solution = "IMPOSSIBLE";
			} else {
				//Sort the Array
				Arrays.sort(solution2DArray, new java.util.Comparator<int[]>() {
					public int compare(int[] a, int[] b) {
						return Integer.compare(a[0], b[0]);
					}
				});

				for (int j = 0; j < solution2DArray.length; j++) {
					if (solution2DArray[j][1] == 1) {
						solution += "C";
					} else if (solution2DArray[j][1] == 2) {
						solution += "J";
					}
				}
			}

			System.out.println("Case #" + i + ": " + solution);
		}
	}
}