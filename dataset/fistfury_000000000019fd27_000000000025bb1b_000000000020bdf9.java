import java.util.*;
import java.io.*;
import java.lang.Math;

public class Solution {
	public static void main (String[] args) {
		boolean debug = false;
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for (int i = 1; i <= t; ++i) {
			int[][] Sched = new int[1440][2];
			boolean impossible = false;
			
			int w = in.nextInt();
			int[][] answerKey = new int[w][2];
			int Count = 0;

			int[][] kList = new int[w][3];
			for (int j = 0; j < w; j++) {
				kList[j][0] = in.nextInt();
				kList[j][1] = in.nextInt();
				kList[j][2] = Count++;
				
			}

			Arrays.sort(kList, new java.util.Comparator<int[]>() {
				public int compare(int[] a, int[] b) {
					return Integer.compare(a[0], b[0]);
				}
			});

			for (int j = 0; j < w; j++) {
				int startTime = kList[j][0];
				int endTime = kList[j][1];
				int activityReference = kList[j][2];
				boolean cameronAvailable = true;
				boolean jamieAvailable = true;

				for (int k = startTime; k < endTime; k++) {
					if (Sched[k][0] == 1) {
						cameronAvailable = false;
					}
				}

				
				if (cameronAvailable) {
					for (int k = startTime; k < endTime; k++) {
						Sched[k][0] = 1;
					}

					answerKey[j] = new int[] {activityReference, 1};
				} else {
					for (int k = startTime; k < endTime; k++) {
						if (Sched[k][1] == 1) {
							jamieAvailable = false;
						}
					}

					if (jamieAvailable) {
						for (int k = startTime; k < endTime; k++) {
							Sched[k][1] = 1;
						}
						answerKey[j] = new int[] {activityReference, 2};
					} else {
						impossible = true;
					}
				}	}
			String ans = "";
			if (impossible) {
				ans = "IMPOSSIBLE";
			} 
			else {
				Arrays.sort(answerKey, new java.util.Comparator<int[]>() {
					public int compare(int[] a, int[] b) {
						return Integer.compare(a[0], b[0]);
					}
				});
				for (int j = 0; j < answerKey.length; j++) {
					if (answerKey[j][1] == 1) {
						ans=ans+ "C";
					} else if (answerKey[j][1] == 2) {
						ans =ans+ "J";
					}
				}
			}
			System.out.println("Case #" + i + ": " + ans);
		}
	}
}