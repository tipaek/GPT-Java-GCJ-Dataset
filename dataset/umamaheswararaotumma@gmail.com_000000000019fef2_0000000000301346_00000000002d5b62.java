import java.util.Scanner;

class Solution {
	public static void main(String[] args) {
		print();
	}

	public static void print() {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 1; i <= t; i++) {
			System.out.print("Case #" + i + ": ");
			solve(sc.nextInt(), sc.nextInt());
			System.out.println();
		}
	}

	private static void solve(int i, int j) {
		String answer = solveHelper(0, 0, i, j, 1.0, "");
		if (answer != null) {
			System.out.print(answer);
		} else {
			System.out.print("IMPOSSIBLE");
		}
	}

	private static String solveHelper(int i, int j, int x, int y, double turn, String ans) {
		if (i == x && j == y) {
			return ans;
		}
		if (Math.abs(i) > Math.abs(x) || Math.abs(j) > Math.abs(y)) {
			return null;
		}
		String es = solveHelper(i + (int) (Math.pow(2, turn - 1) * 1), j, x, y, turn + 1, ans + "E");
		String ws = solveHelper(i + (int) (Math.pow(2, turn - 1) * (-1)), j, x, y, turn + 1, ans + "W");
		String ns = solveHelper(i, j + (int) (Math.pow(2, turn - 1) * 1), x, y, turn + 1, ans + "N");
		String ss = solveHelper(i, j + (int) (Math.pow(2, turn - 1) * -1), x, y, turn + 1, ans + "S");
		if (es != null) {
			if (ws != null && es.length() > ws.length()) {
				es = ws;
			}
			if (ns != null && ns.length() < es.length()) {
				es = ns;
			}
			if (ss != null && ss.length() < es.length()) {
				es = ss;
			}
			return es;
		} else if (ws != null) {
			if (ns != null && ns.length() < ws.length()) {
				ws = ns;
			}
			if (ss != null && ss.length() < ws.length()) {
				ws = ss;
			}
			return ws;
		} else if (ns != null) {
			if (ss != null && ss.length() < ns.length()) {
				ns = ss;
			}
			return ns;
		} else if (ss != null) {
			return ss;
		} else {
			return null;
		}
	}
}