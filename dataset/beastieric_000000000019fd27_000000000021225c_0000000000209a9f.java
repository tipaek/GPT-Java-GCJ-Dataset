import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 0; i < t; i++) {
			StringBuilder ans = new StringBuilder();
			String s = sc.next();
			int left = 0;
			for(int j = 0; j < s.length(); j++) {
				int curr = Integer.parseInt(s.substring(j,j+1));
				while(curr>left) {
					ans.append("(");
					left++;
				}
				while(curr<left) {
					ans.append(")");
					left--;
				}
				ans.append(curr);
			}
			for(int j = 0; j < left; j++) {
				ans.append(")");
			}
			System.out.println("Case #" + (i+1) + ": " + ans.toString());
		}
		sc.close();
	}
	
}
