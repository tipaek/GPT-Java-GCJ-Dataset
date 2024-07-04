import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		int testCase = 1;
		t: while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			char[] who = new char[n];
			int[][] times = new int[n][2];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				times[i][0] = Integer.parseInt(st.nextToken());
				times[i][1] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(times, (a, b) -> a[0] - b[0]);
			int[] freq = new int[1440];
//			for (int[] time : times) {
//				System.out.println(Arrays.toString(time));
//			}
			for (int i = 0; i < n; i++) {
				if (!iterate(freq, times[i], i)) {
					System.out.printf("Case #%d: IMPOSSIBLE\n", testCase);
					testCase++;
					continue t;
				}
			}
			who[0] = 'C';
			int C = times[0][1];
			int J = 0;
			for (int i = 1; i < n; i++) {
				if (times[i][0] >= C) {
					who[i] = 'C';
					C = times[i][1];
				}
			}
			for (int i = 0; i < n; i++) {
				if (who[i] != 'C') {
					who[i] = 'J';
				}
			}
			System.out.printf("Case #%d: %s\n", testCase, new StringBuilder().append(who).toString());
			testCase++;
		}
	}

	public static boolean iterate(int[] freq, int[] times, int val) {
		for (int i = times[0]; i < times[1]; i++) {
			freq[i]++;
			if (freq[i] > 2) {
				return false;
			}
		}
		return true;
	}
}
