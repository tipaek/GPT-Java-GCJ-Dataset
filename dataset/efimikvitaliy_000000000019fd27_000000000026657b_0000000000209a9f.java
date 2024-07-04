import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		
		for (int t = 1; t <= T; ++t) {
			String s = sc.next();
			char[] ch = s.toCharArray();
			
			StringBuilder sb = new StringBuilder();
			
			int prev = 0;
			int cur = 0;
			int diff;
			
			for(int i=0; i<ch.length; ++i) {
				cur = ch[i] - '0';
				
				diff = cur - prev;
				
				if(diff > 0) {
					for(int k=0; k<diff; ++k) {
						sb.append("(");
					}
				}
				else if(diff < 0) {
					for(int k=0; k>diff; --k) {
						sb.append(")");
					}
				}
				sb.append(cur);
				prev = cur;
			}
			
			for(int i=0; i<cur; ++i) {
				sb.append(")");
			}
			
			System.out.println(String.format("Case #%d: %s", t, sb.toString()));
		}
	}

}
