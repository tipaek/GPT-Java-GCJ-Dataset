import java.util.Scanner;

public class Solution {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++)
			System.out.println("Case #" + i + ": " + resolv(sc));
	}

	private static String resolv(Scanner sc) {
		int N = sc.nextInt();
		String p[] = new String[N];
		int max = 0;
		String maxP = "";
		StringBuffer sb;
		for (int i = 0; i < N; i++) {
			sb = new StringBuffer(sc.next().substring(1));
			p[i] = sb.reverse().toString();
			
			if (p[i].length() > max) {
				max = p[i].length();
				maxP = p[i];
			}
		}
		for (int i = 0; i < N; i++) {
			if (maxP.startsWith(p[i]))
				continue;
			return "*";
		}
		sb = new StringBuffer(maxP);
		return sb.reverse().toString();
	}
}
