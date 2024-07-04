import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testNo = scanner.nextInt();
		
		for (int i = 1; i <= testNo; i++) {
			String str = scanner.next();
			String ans = "";
			
			int open = 0;
			int close = 0;
			
			int prev = 0;
			for (int j = 0; j < str.length(); j++) {
				int cur = Integer.parseInt(String.valueOf(str.charAt(j)));
				int sub = prev - cur;
				
				if (sub < 0 ) {
					sub = -sub;
					for (int k = 0; k < sub; k++) {
						ans += "(";
					}
					ans += cur;
				} else {
					for (int k = 0; k < sub; k++) {
						ans += ")";
					}
					ans += cur;
				}
				prev = cur;
			}
			for (int k = 0; k < prev; k++) {
				ans += ")";
			}
			
			System.out.println("Case #" + i + ": " + ans);
		}
		scanner.close();
	}

}
