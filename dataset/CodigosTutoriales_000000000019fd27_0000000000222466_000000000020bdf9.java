import java.util.*;

/**
 * Made and solved successfully by the Prodigy Programmer
 * @author Julian Paniagua
 */
public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testCases = scanner.nextInt();
		for (int t = 1; t <= testCases; t++) {
			int numberOfActivities = scanner.nextInt();
			int[][] activities = new int[numberOfActivities][1];
			int start = 0;
			int end = 0;
			char[] result = new char[numberOfActivities];
			for (int i = 0; i < numberOfActivities; i++) {
				result[i] = '@';
				int myStart = scanner.nextInt();
				int myEnd = scanner.nextInt();
				activities[i] = new int[] {myStart, myEnd};
				if (i == 0 || myStart >= end || myEnd <= start) {
					start = activities[i][0];
					end = activities[i][1];
					result[i] = 'C';
				}
			}
			start = 0;
			end = 0;
			for (int i = 1; i < numberOfActivities; i++) {
				int myStart = activities[i][0];
				int myEnd = activities[i][1];
				activities[i] = new int[] {myStart, myEnd};
				if (result[i] != 'C' && ((start == 0 || end == 0) || myStart >= end || myEnd <= start)) {
					start = activities[i][0];
					end = activities[i][1];
					result[i] = 'J';
				}
			}
			String strResult = new String(result);
			if (strResult.contains("@"))
				System.out.println("Case #" + t + ": IMPOSSIBLE");
			else {
				System.out.println("Case #" + t + ": " + strResult);
			}
		}
	}

}