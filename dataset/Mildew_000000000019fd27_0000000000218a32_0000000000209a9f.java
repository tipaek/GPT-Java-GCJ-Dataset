import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		int testCase = 1;
		while (t-- > 0) {
			StringBuilder sb = new StringBuilder();
			String s = br.readLine();
			int parenCount = 0;
			for (int i = 0; i < s.length(); i++) {
				int currInt = Character.getNumericValue(s.charAt(i));
				if (parenCount >= currInt) {
					while (parenCount != currInt) {
						sb.append(')');
						parenCount--;
					}
					sb.append(currInt);
				} else {
					while (parenCount != currInt) {
						sb.append('(');
						parenCount++;
					}
					sb.append(currInt);
				}
			}
			while (parenCount-- > 0) {
				sb.append(')');
			}
			System.out.printf("Case #%d: %s\n", testCase, sb.toString());
			testCase++;
		}
	}
}