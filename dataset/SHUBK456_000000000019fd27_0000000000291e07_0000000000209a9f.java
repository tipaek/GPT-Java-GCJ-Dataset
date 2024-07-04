import java.util.*;

class Solution {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		int tc = 1;
		while (t-- > 0) {
			String str = s.next();
			int n = str.length();
			String ans = "";
			int a = str.charAt(0) - '0';
			String op1 = "";
			int ta = a;
			while (ta-- > 0) {
				op1 += "(";
			}
			String cl1 = "";
			int tb = a;
			while (tb-- > 0) {
				cl1 += ")";
			}
			ans = op1 + a + cl1;
			for (int i = 1; i < n; i++) {
				int c = str.charAt(i) - '0';
				int sl = ans.length();
				int x = sl - 1;
				while (ans.charAt(x) < '0' || ans.charAt(x) > '9') {
					x--;
				}

				int count = sl - x - 1;
				String temp = "" + c;
				if (c > count) {
					String op2 = "";
					int n1 = c - count;
					while (n1-- > 0) {
						op2 += "(";
					}
					String cl2 = "";
					int m = c - count;
					while (m-- > 0) {
						cl2 += ")";
					}
					temp = op2 + c + cl2;
				}
				int sl3 = ans.length() - Math.min(c, count);
				ans = ans.substring(0, sl3) + temp + ans.substring(sl3);
			}
			System.out.println("Case #" + tc + ": " + ans);
			tc++;
		}
	}
}