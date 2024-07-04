import java.util.*;
import java.io.*;
import java.lang.Math;

// java Solution < input.txt > output.txt
// java Solution < input.txt > output.txt; cat output.txt
// https://code.google.com/codejam/resources/quickstart-guide
// https://code.google.com/codejam/resources/faq
// https://github.com/ellengz/CodeJam/tree/master/src/y2018/qualification/A

public class Solution {
	public static void main (String[] args) {
		boolean debug = false;
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();	// Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			int[][] masterSched = new int[1440][2]; // [[cameron, jamie], [cameron, jamie], ...] so [1, 0] means cameron is busy, [0, 1] means jamie is busy
			boolean impossible = false;
			

			// Populate array with [[0, 0], [0, 0], ...]
			// Nvm, it's already filled with zeroes

			int w = in.nextInt();
			int[][] answerKey = new int[w][2]; // [[activityRef, person]] so [[0, 1], [1, 2], [2, 1]] means Cameron does activity #0 and #2, Jamie does activity #1
			int activityCount = 0;

			// Gather activities
			int[][] activitiesList = new int[w][3]; // [[startTime, endTime, activityReference]]
			for (int j = 0; j < w; j++) {
				activitiesList[j][0] = in.nextInt();
				activitiesList[j][1] = in.nextInt();
				activitiesList[j][2] = activityCount++; // keep track of activity reference, aka activity #1 or #2, to correspond to correct "CJ" or "JC"
				
				if (debug) {
					System.out.println("" + activitiesList[j][0] + " " + activitiesList[j][1]);
				}
			}

			// This is what makes solution from wrong to right: sort by startTime, so algorithm is ALWAYS Cameron-biased
			// https://stackoverflow.com/questions/15452429/java-arrays-sort-2d-array
			Arrays.sort(activitiesList, new java.util.Comparator<int[]>() {
				public int compare(int[] a, int[] b) {
					return Integer.compare(a[0], b[0]);
				}
			});

			// Iterate thru each "activity" (w == activitiesList.length)
			for (int j = 0; j < w; j++) {
				int startTime = activitiesList[j][0];
				int endTime = activitiesList[j][1];
				int activityReference = activitiesList[j][2];
				boolean cameronAvailable = true;
				boolean jamieAvailable = true;

				// Loop through masterSched (each 1st degree array in masterSched represents a minute)
				// Check if Cameron's free
				for (int k = startTime; k < endTime; k++) {
					if (masterSched[k][0] == 1) {
						// Cameron is busy this minute
						cameronAvailable = false;
					}
				}

				
				if (cameronAvailable) {
					// Cameron IS free, so populate his schedule from start time to end time with 1's to indicate no longer available during those minutes
					for (int k = startTime; k < endTime; k++) {
						masterSched[k][0] = 1;
					}

					// https://stackoverflow.com/questions/9318113/explicitly-assigning-values-to-a-2d-array
					answerKey[j] = new int[] {activityReference, 1};
				} else {
					// If Cameron's not free, is Jamie free?
					for (int k = startTime; k < endTime; k++) {
						if (masterSched[k][1] == 1) {
							// Jamie is busy this minute
							jamieAvailable = false;
						}
					}

					// Is Jamie available now?
					if (jamieAvailable) {
						// Yes, she's free!
						for (int k = startTime; k < endTime; k++) {
							masterSched[k][1] = 1;
						}
						answerKey[j] = new int[] {activityReference, 2};
					} else {
						// Uh oh, neither of them are free!
						impossible = true;
					}
				}

				if (debug) {
					// System.out.println(Arrays.deepToString(masterSched));
				}
			}

			// Translate the answer key array to the correctly formatted string
			String answer = "";
			if (impossible) {
				answer = "IMPOSSIBLE";
			} else {
				// Fix the order of the formatted answer string to the original order of activities inputted
				Arrays.sort(answerKey, new java.util.Comparator<int[]>() {
					public int compare(int[] a, int[] b) {
						return Integer.compare(a[0], b[0]);
					}
				});

				// Now generate the answer string
				for (int j = 0; j < answerKey.length; j++) {
					if (answerKey[j][1] == 1) {
						// Cameron is doing activity #j
						answer += "C";
					} else if (answerKey[j][1] == 2) {
						// Jamie is doing activity #j
						answer += "J";
					}
				}
			}

			System.out.println("Case #" + i + ": " + answer);
		}
	}
}