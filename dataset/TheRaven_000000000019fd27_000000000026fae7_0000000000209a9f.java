import java.util.*;
public class Solution {

	public static void main (String [] arg) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for (int ii = 1; ii<=T; ++ii) {
			char [] S = sc.next().toCharArray();
			StringBuilder ans = new StringBuilder(S.length * 2);
			int depth = '0';
			for (int i = 0; i<S.length; ++i) {
				while(depth < S[i]) {
					depth++;
					ans = ans.append('(');
				}
				while (depth > S[i]) {
					depth--;
					ans = ans.append(')');
				}
				ans = ans.append(S[i]);
			}
			while (depth--> '0') ans = ans.append(')');
			System.out.printf("Case #%d: %s\n",ii,ans.toString());
		}
	}

}
