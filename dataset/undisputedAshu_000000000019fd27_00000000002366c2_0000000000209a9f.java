import java.io.IOException;
import java.util.Scanner;

 class Solution {

	private static final String NEWLINE = "\n";
	private static final String SPACE = " ";
	private static final String COLON = ":";
	private static final String CASE = "Case #";

	public static void main(String args[]) throws IOException {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		int t = 1;
		StringBuilder sb = new StringBuilder();
		while (t<=T) {
			String s = in.next();
			String res = get(s);
			sb.append(CASE).append(t).append(COLON).append(SPACE).append(res)
			  .append(NEWLINE);
			t++;
		}
		System.out.println(sb);
		in.close();
	}
	
	private static String get(String s) {
		int n = s.length();
		int a[] = new int[n];
		for (int i=0;i<n;i++) {
			if (s.charAt(i) == '0') a[i] = 0;
			else a[i] = 1;
		}
		
		StringBuilder sb = new StringBuilder();
		int l = 0;
		while (l<n) {
			if (a[l] == 0) {
				while (l<n && a[l] == 0) {
					sb.append(0);
					l++;
				}
			} else {
				sb.append("(");
				while (l<n && a[l] == 1) {
					sb.append(1);
					l++;
				}
				sb.append(")");
			}
		}
		return sb.toString();
	}
	
}