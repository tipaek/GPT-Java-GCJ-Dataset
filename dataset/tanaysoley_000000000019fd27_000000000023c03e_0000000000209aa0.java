import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= testCases; tc++) {
			List<Integer> input = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
			int n = input.get(0);
			int k = input.get(1);
			if (k >= n && k <= n * n && k % n == 0) {
				System.out.println("Case #" + tc + ": POSSIBLE");
				print(n, k);
			} else {
				System.out.println("Case #" + tc + ": IMPOSSIBLE");
			}
		}
	}

	public static void print(int n, int k) {
		int a = k / n - 1;
		for (int i = 0; i < n; i++) {
			List<Integer> row = new ArrayList();
			for (int j = 0; j < n; j++) {
				row.add(((j - i) + n + a) % n + 1);
			}
			System.out.println(String.join(" ", row.stream().map((b) -> "" + b).collect(Collectors.toList())));
		}
	}
}
