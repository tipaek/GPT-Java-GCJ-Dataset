import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int ca = 1;
		while (t-- > 0) {
			char[] nums = br.readLine().trim().toCharArray();
			int op = 0;
			StringBuilder sb = new StringBuilder();
			int prev = nums[0] - '0';
			if (prev > 0) {
				int rep = prev;
				op = prev;
				while (rep-- > 0) {
					sb.append("(");
				}
			}
			sb.append(prev);

			for (int i = 1; i < nums.length; i++) {
				int cur = nums[i] - '0';
				if (cur > prev) {
					int diff = cur - prev;
					while (diff-- > 0) {
						op++;
						sb.append("(");
					}
				} else {
					int diff = prev - cur;
					while (diff-- > 0) {
						op--;
						sb.append(")");
					}
				}
				sb.append(cur);
				prev = cur;
			}
			while (op-- > 0) {
				sb.append(")");
			}
			System.out.println("Case #" + ca + ": " + sb.toString());
			ca++;
		}
	}
}