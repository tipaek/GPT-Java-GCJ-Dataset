import java.util.Scanner;

public class Solution {

	String fnc(String s) {
		StringBuilder sb = new StringBuilder();
		for (char c : s.toCharArray()) {
			sb.append(modifyStr(c - 48));
		}

		String str = sb.toString();
		while (str.indexOf(")(") != -1) {
			str = str.replace(")(", "");
		}

		return str;
	}

	String modifyStr(int n) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			sb.append("(");
		}
		sb.append(n);
		for (int i = 0; i < n; i++) {
			sb.append(")");
		}

		return sb.toString();
	}

	void run() {
		try (Scanner sc = new Scanner(System.in)) {
			int testNum = sc.nextInt();
			for (int t = 1; t <= testNum; t++) {
				System.out.println("Case #" + t + ": " + fnc(sc.next()));
			}
		}
	}

	public static void main(String[] args) {
		new Solution().run();
	}
}
