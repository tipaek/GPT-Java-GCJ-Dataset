import java.util.Scanner;

public class Solution {

	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
	
		int testCases = scanner.nextInt();

		String[] result = new String[testCases];

		for (int i = 0; i < testCases; i++) {
			result[i] = organize();
		}

		for (int i = 0; i < testCases; i++) {
			System.out.println("Case #" + (i + 1) + ": " + result[i]);
		}
	}

	public static String organize() {
		int activities = scanner.nextInt();
		boolean[] activitiesPerMinuteC = new boolean[1440];
		boolean[] activitiesPerMinuteJ = new boolean[1440];
		StringBuilder schedule = new StringBuilder();
		for (int i = 0; i < activities; i++) {
			char parent = 'C';
			int start = scanner.nextInt();
			int end = scanner.nextInt();
			for (int j = start; j < end; j++) {
				if (activitiesPerMinuteC[j]) {
					parent = 'J';
					for (int k = start; k < end; k++) {
					    if (activitiesPerMinuteJ[k]) {
						    return "IMPOSSIBLE";
					    }
					}
					break;
				}
			}
			if (parent == 'C') {
				for (int j = start; j < end; j++) {
					activitiesPerMinuteC[j] = true;
				}
			} else {
				for (int j = start; j < end; j++) {
					activitiesPerMinuteJ[j] = true;
				}
			}
			schedule.append(parent); 
		}
		return schedule.toString();
	}

}