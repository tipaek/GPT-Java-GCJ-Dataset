import java.util.Scanner;

class Main {

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
		int[] activitiesPerMinute = new int[1440];
		StringBuilder schedule = new StringBuilder();
		for (int i = 0; i < activities; i++) {
			char parent = 'C';
			int start = scanner.nextInt();
			int end = scanner.nextInt();
			for (int j = start; j < end; j++) {
				activitiesPerMinute[j]++;
				if (activitiesPerMinute[j] == 2) {
					parent = 'J';
				} else if (activitiesPerMinute[j] == 3) {
					return "IMPOSSIBLE";
				}
			}
			schedule.append(parent); 
		}
		return schedule.toString();
	}

}