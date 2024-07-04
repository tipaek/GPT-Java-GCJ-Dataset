import java.util.*;
public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		for (int t = 1; t <= tc; t++) {
			String str = in.next();
			StringBuilder s = new StringBuilder();
			int p = 0;
			for (int i = 0; i < str.length(); i++) {
				while (str.charAt(i) - '0' > p) {
					s.append("(");
					p++;
				}
				while (str.charAt(i) - '0' < p) {
					s.append(")");
					p--;
				}
				s.append(str.charAt(i));
			}
			while (p > 0) {
				s.append(")");
				p--;
			}
			
			System.out.println("Case #" + t + ": " + s.toString());
		}
	}
}
