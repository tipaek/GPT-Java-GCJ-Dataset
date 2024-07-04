import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class Solution {

	String fnc(int r, int s) {

		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		
		while (true) {
			for (int k = 1; k <= s - 1; k++) {
				int a = r;
				int b = (s - 1) * r - k;
				sb.append(a).append(" ").append(b).append(System.lineSeparator());
				cnt++;
			}
			r--;
			if (r == 1) {
				break;
			}
		}

		String ans = "" + cnt + System.lineSeparator() + sb.toString();
		
		return ans;
	}

	void run() {
		try (Scanner sc = new Scanner(System.in)) {
			int testNum = sc.nextInt();
			for (int t = 1; t <= testNum; t++) {
				int r = sc.nextInt();
				int s = sc.nextInt();
				System.out.print("Case #" + t + ": " + fnc(r, s));
			}
		}
	}

	public static void main(String[] args) {
		new Solution().run();
	}
}
