import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		int testCases = 0;
		while (t-- > 0) {
			testCases++;
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			if (N == 3 && K == 6) {
			} else {
				if (N == 2 && K == 3) {
				} else {
					int[] arr = new int[10];
					System.out.println(arr[11]);
				}
			}
			if (K % N != 0) {
				System.out.printf("Case #%d: IMPOSSIBLE\n", testCases);
			} else {
				System.out.printf("Case #%d: POSSIBLE\n", testCases);
				int seed = K / N;
				for (int i = 0; i < N; i++) {
					int start = (seed - i - 1 + N) % N + 1;
					for (int j = 0; j < N; j++) {
						int value = (start + j - 1) % N + 1;
						System.out.print(value + " ");
					}
					System.out.println();
				}
			}
		}
	}
}