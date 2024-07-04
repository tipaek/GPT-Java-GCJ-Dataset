import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
class Solution {
    public static String parentPartening(int[][] durations) {
		int[][] newDurations = new int[durations.length][durations[0].length];
		for (int i = 0; i < durations.length; i++) {
			newDurations[i][0] = durations[i][0];
			newDurations[i][1] = durations[i][1];
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < newDurations.length - 1; i++) {
			for (int j = i + 1; j < newDurations.length; j++) {
				if (newDurations[i][1] > newDurations[j][1]) {
					int start = newDurations[i][0];
					int end = newDurations[i][1];
					newDurations[i][0] = newDurations[j][0];
					newDurations[i][1] = newDurations[j][1];
					newDurations[j][0] = start;
					newDurations[j][1] = end;
				}
			}
		}

		ArrayList<Integer> C = new ArrayList<>();
		ArrayList<Integer> J = new ArrayList<>();
		C.add(0);
		for (int i = 1; i < newDurations.length; i++) {
			if (newDurations[i][0] >= newDurations[C.get(C.size() - 1)][1]) {
				C.add(i);
			} else {
				if (J.isEmpty() || newDurations[i][0] >= newDurations[J.get(J.size() - 1)][1]) {
					J.add(i);
				} else {
					return "IMPOSSIBLE";
				}
			}
		}
		
		for (int i = 0; i < durations.length; i++) {
			int[] duration = durations[i];
			boolean isC = false;
			for (int j = 0; j < C.size(); j++) {
				int[] newDuration = newDurations[C.get(j)];
				if (duration[0] == newDuration[0] && duration[1] == newDuration[1]) {
					isC = true;
					sb.append('C');
					break;
				}
			}
			if (!isC) {
				sb.append('J');
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numTestCases = Integer.parseInt(scanner.nextLine());
		for (int testCase = 1; testCase <= numTestCases; testCase++) {
			int numActivities = Integer.parseInt(scanner.nextLine());
			int[][] durations = new int[numActivities][2];
			for (int i = 0; i < numActivities; i++) {
				String[] line = scanner.nextLine().split(" ");
				durations[i][0] = Integer.parseInt(line[0]);
				durations[i][1] = Integer.parseInt(line[1]);
			}
			System.out.println("Case #" + testCase + ": " + parentPartening(durations));
		}
	}
}