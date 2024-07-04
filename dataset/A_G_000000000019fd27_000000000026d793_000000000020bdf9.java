//AG
import java.util.*;
import java.lang.Math;

import java.io.*;

//

public class Solution {
	public static void main (String[] args) {
		boolean deg = false;
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for (int i = 1; i <= t; ++i) {
			int[][] mastersa = new int[1440][2];
			boolean impossizx = false;


  //		
			int w = in.nextInt();
			int[][] answerqw = new int[w][2];
			int activityCount = 0;

			int[][] activitiesList = new int[w][3];
			for (int j = 0; j < w; j++) {
				activitiesList[j][0] = in.nextInt();
				activitiesList[j][1] = in.nextInt();
				activitiesList[j][2] = activityCount++;
				
				if (deg) {
					System.out.println("" + activitiesList[j][0] + " " + activitiesList[j][1]);
				}
			}
//


			Arrays.sort(activitiesList, new java.util.Comparator<int[]>() {
				public int compare(int[] a, int[] b) {
					return Integer.compare(a[0], b[0]);
				}
			});

			for (int j = 0; j < w; j++) {
				int startTime = activitiesList[j][0];
				int endTime = activitiesList[j][1];
				int activityReference = activitiesList[j][2];
				boolean cameronAvailable = true;
				boolean jamieAvailable = true;

				for (int k = startTime; k < endTime; k++) {
					if (mastersa[k][0] == 1) {
						cameronAvailable = false;
					}
				}
// 

				
				if (cameronAvailable) {
					for (int k = startTime; k < endTime; k++) {
						mastersa[k][0] = 1;
					}

					answerqw[j] = new int[] {activityReference, 1};
				} else {
					for (int k = startTime; k < endTime; k++) {
						if (mastersa[k][1] == 1) {
							jamieAvailable = false;
						}
					}

					if (jamieAvailable) {
						for (int k = startTime; k < endTime; k++) {
							mastersa[k][1] = 1;
						}
						answerqw[j] = new int[] {activityReference, 2};
					} else {
						impossizx = true;
					}
				}
			}

			String answer = "";
			if (impossizx) {
				answer = "impossizx";
			} else {
				Arrays.sort(answerqw, new java.util.Comparator<int[]>() {
					public int compare(int[] a, int[] b) {
						return Integer.compare(a[0], b[0]);
					}
				});

				for (int j = 0; j < answerqw.length; j++) {
					if (answerqw[j][1] == 1) {
						answer += "C";
					} else if (answerqw[j][1] == 2) {
						answer += "J";
					}
				}
			}

			System.out.println("Case #" + i + ": " + answer);
		}
	}
}