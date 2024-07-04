import java.util.Scanner;

class Solution {

	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
	
		int testCases = scanner.nextInt();

		String[] result = new String[testCases];

		for (int i = 0; i < testCases; i++) {
			result[i] = organize();
		}

		for (int i = 0; i < testCases - 1; i++) {
			System.out.println("Case #" + (i + 1) + ": " + result[i]);
		}
		System.out.print("Case #" + testCases + ": " + result[testCases - 1]);
	}

	public static boolean[] isJoccupied = new boolean[1440];
	public static boolean[] isCoccupied = new boolean[1440];

	public static boolean isOccupied(char parent, int start, int end) {
		if (parent == 'C') {
			for (int i = start; i < end; i++) {
				if (isCoccupied[i]) {
					return true;
				}
			}
		} else {
			for (int i = start; i < end; i++) {
				if (isJoccupied[i]) {
					return true;
				}
			}
		}
		return false;
	}

	public static void occupy(char parent, int start, int end) {
		if (parent == 'C') {
			for (int i = start; i < end; i++) {
				isCoccupied[i] = true;
			}
		} else {
			for (int i = start; i < end; i++) {
				isJoccupied[i] = true;
			}
		}
	}

	public static String organize() {
		int activities = scanner.nextInt();
		StringBuilder schedule = new StringBuilder();
		boolean impossible = false;
		for (int i = 0; i < activities; i++) {
			int start = scanner.nextInt();
			int end = scanner.nextInt();
			if (isOccupied('C', start, end)) {
				if (isOccupied('J', start, end)) {
					impossible = true;
				} else {
					schedule.append('J');
					occupy('J', start, end);
				}
			} else {
				schedule.append('C');
				occupy('C', start, end);
			}
		}
		isJoccupied = new boolean[1440];
		isCoccupied = new boolean[1440];
		if (impossible) {
			return "IMPOSSIBLE";
		}
		return schedule.toString();
	}

}