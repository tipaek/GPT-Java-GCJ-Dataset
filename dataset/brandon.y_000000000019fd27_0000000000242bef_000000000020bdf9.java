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
			String answer = "";

			// Populate array with [[0, 0], [0, 0], ...]
			// Nvm, it's already filled with zeroes

			int w = in.nextInt();

			// Iterate thru each "activity"
			for (int j = 0; j < w; j++) {
				int startTime = in.nextInt();
				int endTime = in.nextInt();
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
					answer += "C";
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
						answer += "J";
					} else {
						// Uh oh, neither of them are free!
						impossible = true;
					}
				}
				if (debug) {
					System.out.println("" + startTime + " " + endTime);
					// System.out.println(Arrays.deepToString(masterSched));
				}
			}

			if (impossible) {
				answer = "IMPOSSIBLE";
			}

			if (debug) {
				// System.out.println(answer);
			}
			System.out.println("Case #" + i + ": " + answer);
		}
	}
}
