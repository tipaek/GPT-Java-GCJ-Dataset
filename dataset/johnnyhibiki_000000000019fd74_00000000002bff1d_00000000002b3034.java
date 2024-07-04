import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

	String fnc(int n, String[] strs) {

		String left = "";
		String right = "";

		String[] lefts = new String[n];
		String[] rights = new String[n];
		for (int i = 0; i < n; i++) {
			String[] t = strs[i].split("\\*");
			lefts[i] = t[0];
			if (t.length >= 2) {
				rights[i] = t[1];
			} else {
				rights[i] = "";
			}
		}

		Arrays.sort(lefts, new Comparator<String>() {
			public int compare(String o1, String o2) {
				return o2.length() - o1.length();
			}
		});

		Arrays.sort(rights, new Comparator<String>() {
			public int compare(String o1, String o2) {
				return o2.length() - o1.length();
			}
		});

		left = lefts[0];
		right = rights[0];

		boolean check = true;

		for (int i = 0; i < n; i++) {
			if (!left.isEmpty() && !lefts[i].isEmpty() && !left.startsWith(lefts[i])) {
				check = false;
				break;
			}

			if (!right.isEmpty() && !rights[i].isEmpty() && !right.endsWith(rights[i])) {
				check = false;
				break;
			}
		}

		String ans = left + right;
		if (ans.length() > 10000) {
			check = false;
		}

		return check ? ans : "*";
	}

	void run() {
		try (Scanner sc = new Scanner(System.in)) {
			int testNum = sc.nextInt();
			for (int t = 1; t <= testNum; t++) {
				int n = sc.nextInt();
				String[] strs = new String[n];
				for (int i = 0; i < n; i++) {
					strs[i] = sc.next();
				}
				System.out.println("Case #" + t + ": " + fnc(n, strs));
			}
		}
	}

	public static void main(String[] args) {
		new Solution().run();
	}
}
