import java.util.*;
public class Solution {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		for (int i = 1; i <= t; i++) {
			String s = scn.next();
			StringBuilder sb = new StringBuilder();
			Stack<Integer> st = new Stack<Integer>();
			int close = 0;
			for (int j = 0; j < s.length(); j++) {
				int val = Character.getNumericValue(s.charAt(j));
				if (val == 0) {
					if (sb.length() == 0) {
						sb.append(val);
						st.push(val);
					} else {
						if (close != 0) {
							sb.append(")");
							close--;
						}
						sb.append(val);
						st.push(val);
					}
				} else {
					if (!st.isEmpty() && st.peek() == val) {
						sb.append(val);
					} else {
						sb.append("(");
						sb.append(val);
						st.push(val);
						close++;
					}
				}
			}
			if (s.charAt(s.length() - 1) == '1') {
				sb.append(")");
			}

			System.out.println("Case #" + i + ": " + sb);

		}
	}

}
