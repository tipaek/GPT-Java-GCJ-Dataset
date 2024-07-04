import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			int t = sc.nextInt();
			for (int k = 1; k <= t; k++) {
				int n = sc.nextInt();
				int m[][] = new int[n][3];
				for (int i = 0; i < n; i++) {
					m[i][0] = sc.nextInt();
					m[i][1] = sc.nextInt();
					m[i][2] = i;
				}
				Arrays.sort(m, (o1, o2) -> Integer.compare(o1[0], o2[0]));
				int cEnd = 0;
				int jEnd = 0;
				char[] result = new char[n];
				for (int i = 0; i < n; i++) {
					int startTime = m[i][0];
					int endTime = m[i][1];
					int index = m[i][2];
					if (cEnd <= startTime) {
						cEnd = endTime;
						result[index] = 'C';
					} else if (jEnd <= startTime) {
						jEnd = endTime;
						result[index] = 'J';
					} else {
						result = null;
						break;
					}

				}

				System.out.printf("Case #%d: %s%n", k, result == null ? "IMPOSSIBLE" : String.copyValueOf(result));

			}
		}
	}
}