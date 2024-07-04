import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(scan.readLine());

		for (int i = 1; i <= t; i++) {
			String S = scan.readLine();
			StringBuilder sb = new StringBuilder();
			int cd = 0;

			for (int j = 0; j < S.length(); j++) {

				int n = Integer.parseInt(S.substring(j, j + 1));

				if (n == cd) {
					sb.append(n);
					continue;
				}

				int v = n - cd;

				if (v < 0) {
					v = Math.abs(v);
					for (int z = 0; z < v; z++) {
						sb.append(")");
					}
				} else {
					for (int z = 0; z < v; z++) {
						sb.append("(");
					}
				}

				sb.append(n);
				cd = n;
			}

			if (cd > 0) {
				for (int k = 0; k < cd; k++) {
					sb.append(")");
				}
			}

			System.out.println("Case #" + i + ": " + sb.toString());
		}
	}
}
