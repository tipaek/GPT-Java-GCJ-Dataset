import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int caseCount = 1;

		while (t > 0) {
			t--;
			int n = sc.nextInt();
			int[] start = new int[n];
			int[] end = new int[n];
			Map<Integer, Integer> mapping = new HashMap<Integer, Integer>();

			for (int i = 0; i < n; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				mapping.put(y, x);
				start[i] = x;
				end[i] = y;
			}

			StringBuilder result = new StringBuilder();
			result.append("");
			boolean isPossible = true;
			// boolean isCameroon = false;

			boolean isCBusy = false;
			boolean isJBusy = false;

			int cStartTime = 0;
			int jStartTime = 0;

//			int minStart = Integer.MAX_VALUE;
//			int maxEnd = Integer.MIN_VALUE;
//			int currentScore = 0;
			int startIndex = 0, endIndex = 0;

			Arrays.sort(start);
			Arrays.sort(end);

//			minStart = start[0];
//			maxEnd = end[n - 1];

			for (int i = start[0]; i <= end[n - 1]; i++) {
				if ((endIndex < n) && (i == end[endIndex])) {
					// currentScore--;
					endIndex++;

					if (mapping.get(i) == cStartTime) {
						isCBusy = false;
					} else {
						isJBusy = false;
					}

//					if (currentScore == 0) {
//						isCameroon = false;
//					}
				}

				if ((startIndex < n) && (i == start[startIndex])) {
					// currentScore++;
					startIndex++;

					if (isCBusy && isJBusy) {
						isPossible = false;
						break;
					} else if (!isCBusy) {
						result.append('C');
						cStartTime = i;
						isCBusy = true;
					} else {
						result.append('J');
						jStartTime = i;
						isJBusy = true;
					}

//					if (currentScore > 2) {
//						isPossible = false;
//						break;
//					}
//
//					if (isCameroon) {
//						result.append('J');
//						isCameroon = false;
//					} else {
//						result.append('C');
//						isCameroon = true;
//					}
				}

			}

			if (!isPossible)
				result = new StringBuilder("IMPOSSIBLE");

			System.out.println("Case #" + caseCount + ": " + result.toString());
			caseCount++;
		}
	}
}
