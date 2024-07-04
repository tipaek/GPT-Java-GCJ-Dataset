
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		int t;
		int diff = 0, cnt = 0;
		for (int i = 1; i <= tc; i++) {
			String s = sc.next();
			String ans = "";
			cnt = 0;
			char ch[] = s.toCharArray();
			t = ch[0];
			t = t -'0';
			
			if (t > 0) {
				for (int j = 1; j <= t; j++) {
					ans += '(';
					cnt++;
				}
			}
			ans += t;

			for (int k = 1; k < s.length(); k++) {
				t = ch[k]- '0';
				int t1 = ch[k - 1] -'0';
				if (t1  < t) {
					diff = t - t1 ;
					for (int j = 1; j <= diff; j++) {
						ans += '(';
						cnt++;
					}
				} else if ( t1  > t) {
					diff = t1  - t;
					for (int j = 1; j <= diff; j++) {
						ans += ')';
						cnt--;
					}
				}	
				ans += t;
			}
			for (int j =1; j<=cnt; j++) {
				ans += ')';
			}
			System.out.println("Case #" + i + ": " + ans);
		}
	}
}