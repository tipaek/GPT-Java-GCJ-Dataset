import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		int testCase = 1;
		t: while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			StringBuilder sb = new StringBuilder();
			char[] todos = new char[n];
			int[][] times = new int[n][2];
			int max = 0;
			List<Integer> crits = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				times[i][0] = Integer.parseInt(st.nextToken());
				times[i][1] = Integer.parseInt(st.nextToken());
				crits.add(times[i][0]);
				max = Math.max(max, times[i][1]);
			}
			Arrays.sort(times, (a, b) -> a[0] - b[0]);
			List<Integer>[] freq = new List[max];
			for (int i = 0; i < freq.length; i++) {
				freq[i] = new ArrayList<>();
			}
			for (int i = 0; i < n; i++) {
				if (!iterate(freq, times[i], i)) {
					System.out.printf("Case #%d: IMPOSSIBLE\n", testCase);
					testCase++;
					continue t;
				}
			}
			Collections.sort(crits);
//			for (int val : crits) {
//				System.out.println(freq[val].toString());
//			}
			int C = 0;
			int J = -1;
			int curr = 0;
			while (curr < crits.size() && freq[crits.get(curr)].size() == 1) {
				sb.append('C');
				C = freq[crits.get(curr)].get(0);
				curr++;
			}

			while (curr < crits.size()) {
//				System.out.println(freq[crits.get(curr)].toString());
				if (freq[crits.get(curr)].size() == 1) {
					C = freq[crits.get(curr)].get(0);
					sb.append('C');
					J = -1;
					curr++;
					continue;
				}
				if (freq[crits.get(curr)].contains(C)) {
					sb.append('J');
					J = freq[crits.get(curr)].get(1 - freq[crits.get(curr)].indexOf(C));
				} else {
					if (freq[crits.get(curr)].contains(J)) {
						sb.append('C');
						C = freq[crits.get(curr)].get(1 - freq[crits.get(curr)].indexOf(J));
					} else {
						sb.append("CJ");
						C = freq[crits.get(curr)].get(0);
						J = freq[crits.get(curr)].get(1);
					}
				}
				curr++;
			}
			System.out.printf("Case #%d: %s\n", testCase, sb.toString());
			testCase++;
		}
	}

	public static boolean iterate(List<Integer>[] freq, int[] times, int val) {
		for (int i = times[0]; i < times[1]; i++) {
			freq[i].add(val);
			if (freq[i].size() > 2) {
				return false;
			}
		}
		return true;
	}
}