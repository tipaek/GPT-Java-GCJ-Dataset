import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

		tc: for (int case_ = 1; case_ <= t; ++case_) {
			int n = in.nextInt();
			StringBuilder sb = new StringBuilder();

			if (n <= 500)
				for (int i = 0; i < n; i++)
					sb.append("" + (i + 1) + " " + 1 + "\n");
			else if (1000 <= n) {
				int r = 1;
				boolean fwd = true;
				while ((1 << r) <= n) {
					if (fwd)
						for (int i = 1; i <= r; i++)
							sb.append("" + r + " " + i + "\n");
					else
						for (int i = r; 1 <= i; i--)
							sb.append("" + r + " " + i + "\n");
					fwd = !fwd;
					r++;
					n -= (1 << r);
				}
				if (fwd)
					for (int i = 1; i <= n / 2; i++) {
						r++;
						sb.append("" + r + " " + r + "\n");
					}
				else
					for (int i = 1; i <= n / 2; i++) {
						r++;
						sb.append("" + r + " " + 1 + "\n");
					}
				// n - 7
			} else if (n % 2 == 0) {
				for (int i = 1; i <= n / 2; i++)
					sb.append("" + i + " " + 1 + "\n");
				sb.append("" + (n / 2 + 1) + " " + 2 + "\n");
			} else {
				for (int i = 1; i <= (n / 2) + 1; i++)
					sb.append("" + i + " " + 1 + "\n");
				sb.append("" + (n / 2 + 1) + " " + 2 + "\n");
			}

			System.out.print("Case #" + case_ + ":\n" + sb);
		}
	}

}
