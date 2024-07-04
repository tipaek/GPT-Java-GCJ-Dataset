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
			Map<Integer, Character> resMapping = new HashMap<Integer, Character>();

			for (int i = 0; i < n; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				mapping.put(y, x);
				start[i] = x;
				end[i] = y;
			}

			int[] startCopy = start.clone();

			StringBuilder result = new StringBuilder();
			result.append("");
			boolean isPossible = true;
			boolean isCBusy = false;
			boolean isJBusy = false;

			int cStartTime = 0;
			int jStartTime = 0;
			int startIndex = 0, endIndex = 0;

			Arrays.sort(start);
			Arrays.sort(end);

			for (int i = start[0]; i <= end[n - 1]; i++) {
				if ((endIndex < n) && (i == end[endIndex])) {
					endIndex++;

					if (mapping.get(i) == cStartTime) {
						isCBusy = false;
					} else {
						isJBusy = false;
					}

				}

				if ((startIndex < n) && (i == start[startIndex])) {
					startIndex++;

					if (isCBusy && isJBusy) {
						isPossible = false;
						break;
					} else if (!isCBusy) {
						cStartTime = i;
						isCBusy = true;
						resMapping.put(i, 'C');
					} else {
						jStartTime = i;
						isJBusy = true;
						resMapping.put(i, 'J');
					}
				}

			}

			if (!isPossible) {
				result = new StringBuilder("IMPOSSIBLE");
			} else {
				for (Integer i : startCopy) {
					result.append(resMapping.get(i));
				}
			}

			System.out.println("Case #" + caseCount + ": " + result.toString());
			caseCount++;
		}
	}
}