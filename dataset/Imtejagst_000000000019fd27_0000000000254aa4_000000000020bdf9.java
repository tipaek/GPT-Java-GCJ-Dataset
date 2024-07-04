import java.util.*;
import java.io.*;
import java.lang.Math;



public class Solution {
	public static void main (String[] args) {
		boolean debug = false;
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();	// Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			int[][] masterSched = new int[1440][2]; // [[cameron, jamie], [cameron, jamie], ...] so [1, 0] means cameron is busy, [0, 1] means jamie is busy
			boolean impossible = false;
			

			
			int w = in.nextInt();
			int[][] answerKey = new int[w][2]; // [[activityRef, person]] so [[0, 1], [1, 2], [2, 1]] means Cameron does activity #0 and #2, Jamie does activity #1
			int activityCount = 0;

			
			int[][] activitiesList = new int[w][3]; // [[startTime, endTime, activityReference]]
			for (int j = 0; j < w; j++) {
				activitiesList[j][0] = in.nextInt();
				activitiesList[j][1] = in.nextInt();
				activitiesList[j][2] = activityCount++; // keep track of activity reference, aka activity #1 or #2, to correspond to correct "CJ" or "JC"
				
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
				boolean cameronAvailable = true;
				boolean jamieAvailable = true;

				
				for (int k = startTime; k < endTime; k++) {
					if (masterSched[k][0] == 1) {
					
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

				if (debug) {
				
				}
			}

			
			String answer = "";
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

			System.out.println("Case #" + i + ": " + answer);
		}
	}
}