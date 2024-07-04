import java.util.*;
public class Solution {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		for (int i = 1; i <= t; i++) {
			String s = scn.next();
			StringBuilder sb = new StringBuilder();
			int dive = 0;
			for (int j = 0; j < s.length(); j++) {
				int val = s.charAt(j) - '0';
				while (val > dive) {
					++dive;
					sb.append("(");
				}
				while (val < dive) {
					--dive;
					sb.append(")");
				}
				sb.append(s.charAt(j));
			}
			while (dive > 0) {
				
				sb.append(")");
				dive--;
			}
			System.out.println("Case #" + i + ": " + sb);

	}

}
}
