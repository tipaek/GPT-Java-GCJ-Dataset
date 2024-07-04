import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

	String fnc(int u, String[][] qr) {

		Arrays.sort(qr, new Comparator<String[]>() {
			public int compare(String[] o1, String[] o2) {
				return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
			}
		});

		String ans = "";
		for (int i = 0; i < 104; i++) {

			for (int j = 0; j < qr[i][1].length(); j++) {
				String x = "" + qr[i][1].charAt(j);

				if (ans.indexOf(x) == -1) {
					ans += x;
				}
			}
		}

		ans = ans.substring(9, 10) + ans.substring(0, 9);

		return ans;
	}

	void run() {
		try (Scanner sc = new Scanner(System.in)) {
			int testNum = sc.nextInt();
			for (int t = 1; t <= testNum; t++) {
				int u = sc.nextInt();
				String[][] qr = new String[104][2];
				for (int i = 0; i < 104; i++) {
					qr[i][0] = sc.next();
					qr[i][1] = sc.next();
				}
				System.out.println("Case #" + t + ": " + fnc(u, qr));
			}
		}
	}

	public static void main(String[] args) {
		new Solution().run();
	}
}
