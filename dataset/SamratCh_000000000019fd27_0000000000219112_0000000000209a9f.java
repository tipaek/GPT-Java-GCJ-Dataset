
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for(int t = 1 ; t <= T ; t++) {
			String str = sc.nextLine(), ans = "";
			int l = 0, n = str.length();
			int temp = 0;
			for(int i = 0 ; i < n ; i++) {
				int num = str.charAt(i) - '0';
				temp = num - l;
				while(temp > 0) {
					ans += '(';
					l++;temp--;
				}
				while(temp < 0) {
					ans += ')';
					l--;temp++;					
				}
				ans+=num;
			}
			while(l>0) {
				ans += ')';
				l--;temp++;					
			}
			System.out.println(String.format("Case #1: %s", ans));
		}
	}

}
