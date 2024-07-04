
import java.util.Scanner;

class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner S = new Scanner(System.in);
		int T = S.nextInt();
		int case_num = 1;
		while (T > 0) {
			String str = S.next();
			System.out.println("Case #" + case_num + ": " + solve(str));
			T--;
			case_num++;
		}
	}

	static String solve(String s) {
		String ans = "";
		int count = (int) (s.charAt(0) - '0');
		for (int i = 0; i < count; i++) {
			ans += "(";
		}
		ans += count;

		for (int i = 1; i < s.length(); i++) {
			int currcount = (int) (s.charAt(i) - '0');
			if (count > currcount) {
				while (count > currcount) {
					ans += ")";
					count--;
				}
				ans += currcount;
			} else {
				while (count < currcount) {
					ans += "(";
					count++;
				}
				ans+=currcount;
			}
		}
		while(count>0) {
			ans+=")";
			count--;
		}
		
		return ans;
	}

}
