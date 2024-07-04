import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int t1 = 1; t1 <= t; t1++) {
			int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int n = a[0];
			int k = a[1];
			if (n >= 2 && k>=n && k<=(n*n) && k % n == 0 && (k / n) <= n) {
				System.out.println(("Case #" + t1 + ": " + "POSSIBLE"));
				int m = k / n;
				ArrayList<Integer> al = new ArrayList<>();
				al.add(m);
				for (int i = 1; i <= n; i++) {
					if (i != m) {
						al.add(i);
					}
				}
				print(al, n);
			} else {
				System.out.println(("Case #" + t1 + ": " + "IMPOSSIBLE"));
			}

		}
	}

	public static void print(ArrayList<Integer> al, int n) {
		for (int k = 0; k < n; k++) {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < al.size(); i++) {
				int x = (i - k + n) % n;
				sb.append(al.get(x));
				if (i != al.size() - 1)
					sb.append(" ");
			}
			System.out.println(sb);
		}
	}
}
