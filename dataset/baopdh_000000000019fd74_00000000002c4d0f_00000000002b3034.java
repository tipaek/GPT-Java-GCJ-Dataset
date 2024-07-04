import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt(), tmp;
		for (int k = 1; k <= t; ++k) {
			int n = scanner.nextInt();

			String[] s = new String[n];
			String max = "";
			for (int i = 0; i < n; ++i) {
				s[i] = scanner.next();
				if (s[i].length() > max.length())
					max = s[i];
			}
			boolean result = true;
			for (int i = 0; i < n; ++i) {
				if (!max.endsWith(s[i].substring(1))) {
					result = false;
					break;
				}
			}

			System.out.println("Case #" + k + ": " + (result ? max.substring(1) : "*"));
		}
		scanner.close();
	}
}