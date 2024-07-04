import java.util.Arrays;
import java.util.Scanner;

class Activity {
	int start;
	int end;
	int index;
	String assignee;

	Activity(int start, int end, int index) {
		this.start = start;
		this.end = end;
		this.index = index;
	}
}

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			int N = sc.nextInt();
			Activity[] arr = new Activity[N];
			for (int j = 0; j < N; j++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				arr[j] = new Activity(start, end, j);
			}

			Arrays.sort(arr, (a, b) -> {
				if (a.start == b.start)
					return Integer.compare(a.end, b.end);
				return Integer.compare(a.start, b.start);
			});
			boolean isImpossible = false;
			Activity activityC = new Activity(-1, -1, 0);
			Activity activityJ = new Activity(-1, -1, 0);
			for (Activity a : arr) {
				if (a.start >= activityC.end) {
					a.assignee = "C";
					activityC = a;
				} else if (a.start >= activityJ.end) {
					a.assignee = "J";
					activityJ = a;
				} else {
					isImpossible = true;
					break;
				}
			}
			if (isImpossible) {
				System.out.printf("Case #%s: IMPOSSIBLE%n", i);
				continue;
			}
			Arrays.sort(arr, (a, b) -> Integer.compare(a.index, b.index));
			StringBuilder sb = new StringBuilder();
			for (Activity a : arr) {
				sb.append(a.assignee);
			}
			System.out.printf("Case #%s: %s%n", i, sb.toString());
		}
		sc.close();
	}

}
