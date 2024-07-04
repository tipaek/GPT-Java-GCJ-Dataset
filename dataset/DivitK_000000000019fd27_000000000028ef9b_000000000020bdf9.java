import java.util.*;
import java.io.*;
import java.lang.Math;

public class Solution {
	public static void main (String[] args) {
		boolean debug = false;
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i = 1; i <= t; ++i)
		{
			int[][] master = new int[1440][2];
			boolean imp = false;
			
			int w = in.nextInt();
			int[][] answerKey = new int[w][2];
			int activityCount = 0;

			int[][] activitiesList = new int[w][3];
			for (int j = 0; j < w; j++) {
				activitiesList[j][0] = in.nextInt();
				activitiesList[j][1] = in.nextInt();
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
				boolean camAvailable = true;
				boolean jamieAvailable = true;

				for (int k = startTime; k < endTime; k++) {
					if (master[k][0] == 1) {
						camAvailable = false;
					}
				}

				
				if (camAvailable) {
					for (int k = startTime; k < endTime; k++) {
						master[k][0] = 1;
					}

					answerKey[j] = new int[] {activityReference, 1};
				} else {
					for (int k = startTime; k < endTime; k++) {
						if (master[k][1] == 1) {
							jamieAvailable = false;
						}
					}

					if (jamieAvailable) {
						for (int k = startTime; k < endTime; k++) {
							master[k][1] = 1;
						}
						answerKey[j] = new int[] {activityReference, 2};
					} else {
						imp = true;
					}
				}
			}

			String answer = "";
			if (imp) {
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

			System.out.println("Case #" + i + ": " + answer);
		}
	}
}