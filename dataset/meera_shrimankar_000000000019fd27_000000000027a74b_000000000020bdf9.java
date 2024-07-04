import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();
			int[] ending = new int[N];
			TreeMap<Integer, Integer> starting = new TreeMap<>();
			for (int j = 0; j < N; j++) {
				int a[] = new int[2];
				a[0] = sc.nextInt();
				ending[j] = sc.nextInt();
				starting.put(a[0], j);
			}
			String output = getScheduledActivities1(starting, ending);
			int index = i + 1;
		}
	}

	public static String getScheduledActivities1(TreeMap<Integer, Integer> starting, int[] ending) {
		char[] ansArray = new char[ending.length];
		int previousCompletionC = -1;
		int previousCompletionJ = -1;
		for (Map.Entry<Integer, Integer> entry : starting.entrySet()) {
			if (previousCompletionC <= entry.getKey()) {
				ansArray[entry.getValue()] = 'C';
				previousCompletionC = ending[entry.getValue()];
			} else if (previousCompletionJ <= entry.getKey()) {
				ansArray[entry.getValue()] = 'J';
				previousCompletionJ = ending[entry.getValue()];
			} else {
				return "IMPOSSIBLE";
			}
		}
		return String.valueOf(ansArray);
	}
}
