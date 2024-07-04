import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int k = 1; k <= t; k++) {
			String s;
			char c;
			int count = 0;
			char last = '0';
			int diff = 0;
			s = sc.next();
			int len = s.length();
			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < len; i++) {
				c = s.charAt(i);
				if (c > last) {
					count = c - last;
					while (diff < count) {
						sb.append('(');
						diff++;
					}
				} else if (c < last) {
					count = last - c;
					while (diff < count) {
						sb.append(')');
						diff++;
					}
				}
				sb.append(c);
				last = c;
				diff = 0;
			}
			count = last - '0';
			while (diff < count) {
				sb.append(')');
				diff++;
			}
			System.out.println("Case #"+(k)+": "+sb.toString());
		}
		sc.close();
	}

}
