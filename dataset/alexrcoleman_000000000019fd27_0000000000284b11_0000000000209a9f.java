import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int t=1;t<=T;t++) {
			String s = in.next();
			int bal = 0;
			String ans = "";
			for (int i=0;i<s.length();i++) {
				int v = s.charAt(i) - '0';
				while (bal > v) {
					ans += ")";
					bal--;
				}
				while (bal < v) {
					ans += "(";
					bal++;
				}
				ans += v;
				bal = v;
			}
			while(bal > 0) {
				ans += ")";
				bal--;
			}
			System.out.printf("Case #%d: %s\n", t, ans);
		}
	}
}
