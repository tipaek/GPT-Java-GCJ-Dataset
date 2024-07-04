import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		try (Scanner in = new Scanner((System.in))) {
			int t = in.nextInt();
			in.nextLine();
			String vs = "";
			StringBuilder result = null;
			for (int i = 1; i <= t; ++i) {
				result = new StringBuilder();
				String n = in.nextLine();
				for (int j = 0; j < n.length(); j++) {
					vs = Solution.appender(n.substring(j, j + 1));
					result = result.append(vs);
				}
				String v = result.toString();
				do {
					v = v.replace(")(", "");
				} while (v.indexOf(")(") >= 0);
				System.out.println("Case #" + i + ": " + v);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static String appender(String n) {
		StringBuilder s = new StringBuilder(new String(new char[Byte.parseByte(n)]).replace("\0", "("));
		s = s.append(Byte.parseByte(n));
		s = s.append(new String(new char[Byte.parseByte(n)]).replace("\0", ")"));
		return s.toString();
	}
}