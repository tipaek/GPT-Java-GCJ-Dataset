import java.util.Scanner;

public class Solution {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			System.out.println("Case #" + i + ": " + resolv(sc));
		}
	}

	private static String resolv(Scanner sc) {
		String S = sc.next();
		int pre = 0;
		StringBuffer SD = new StringBuffer();
		for (int i = 0; i < S.length(); i++) {
			String s = S.substring(i, i + 1);
			int n = Integer.parseInt(s);
			for (int j = pre; j < n; j++)
				SD.append('(');
			for (int j = n; j < pre; j++)
				SD.append(')');
			SD.append(s);
			pre = n;
		}
		for (int i = 0; i < pre; i++)
			SD.append(')');
		return SD.toString();
	}
}