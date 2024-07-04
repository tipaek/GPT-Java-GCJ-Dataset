import java.util.*;
import java.io.*;
import java.lang.Math;

public class Solution {
	public static void main (String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int input = in.nextInt();
		for (int i = 0; i < input; i++) {
			int[][] masterSched = new int[1440][2];
			boolean impossible = false;
			String answer = "";
			int activitiesLength = in.nextInt();
			int[][] answerKey = new int[activitiesLength][2];
			int activityCount = 0;

			int[][] activitiesList = new int[activitiesLength][3];
			for (int j = 0; j < activitiesLength; j++) {
				activitiesList[j][0] = in.nextInt();
				activitiesList[j][1] = in.nextInt();
				activitiesList[j][2] = activityCount++;
			}

			Arrays.sort(activitiesList, new java.util.Comparator<int[]>() {
				public int compare(int[] a, int[] b) {
					return Integer.compare(a[0], b[0]);
				}
			});

			for (int j = 0; j < activitiesLength; j++) {
				int startTime = activitiesList[j][0];
				int endTime = activitiesList[j][1];
				int activityReference = activitiesList[j][2];
				boolean cameronAvailable = true;
				boolean jamieAvailable = true;
				for (int k = startTime; k < endTime; k++) {
					if (masterSched[k][0] == 1) {
						// Cameron is busy this minute
						cameronAvailable = false;
					}
				}

				
				if (cameronAvailable) {
					for (int k = startTime; k < endTime; k++) {
						masterSched[k][0] = 1;
					}
					answerKey[j] = new int[] {activityReference, 1};
				} else {
					for (int k = startTime; k < endTime; k++) {
						if (masterSched[k][1] == 1) {
							jamieAvailable = false;
						}
					}

					if (jamieAvailable) {
						for (int k = startTime; k < endTime; k++) {
							masterSched[k][1] = 1;
						}
						answerKey[j] = new int[] {activityReference, 2};
					} else {
						impossible = true;
					}
				}
			}

			if (impossible) {
				answer = "IMPOSSIBLE";
			} else {
				Arrays.sort(answerKey, new java.util.Comparator<int[]>() {
					public int compare(int[] a, int[] b) {
						return Integer.compare(a[0], b[0]);
					}
				});

				for (int j = 0; j < answerKey.length; j++) {
					if (answerKey[j][1] == 1) {
						answer += "C";
					} else if (answerKey[j][1] == 2) {
						answer += "J";
					}
				}
			}
			System.out.println("Case #" + (i + 1) + ": " + answer);
		}
	}
}