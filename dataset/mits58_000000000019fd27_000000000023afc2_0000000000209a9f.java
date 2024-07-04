import java.util.Scanner;

class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			String S = sc.next();
			String ans = "";
			for(int i = 0; i < S.length(); i++) {
				int s = S.charAt(i) - '0';
				for(int j = 0; j < s; j++) ans += "(";
				ans += S.charAt(i);
				for(int j = 0; j < s; j++) ans += ")";
			}
			boolean updated = true;
			while(updated) {
				updated = false;
				if(ans.contains(")(")) {
					ans = ans.replace(")(", "");
					updated = true;
				}
			}
			System.out.println("Case #" + t + ": " + ans);
		}
	}
}