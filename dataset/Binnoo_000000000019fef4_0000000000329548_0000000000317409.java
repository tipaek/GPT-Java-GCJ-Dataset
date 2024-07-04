
import java.util.Scanner;

public class Solution {

	int t;
	Scanner s;
	String peppurMoves;
	int x;
	int y;
	int px;
	int py;

	public Solution(int t, Scanner s) {
		super();
		this.t = t;
		this.s = s;
	}

	public void solve() {
		// read input and solve
		px = s.nextInt();
		py = s.nextInt();
		peppurMoves = s.next();
		int tourLenght = peppurMoves.length();
		StringBuilder sb = new StringBuilder("IMPOSSIBLE");
		for (int i = 0; i <= tourLenght; i++) {
			// try to reach at minute i
			int pfx = getFinalPx(px, peppurMoves, i);
			int pfy = getFinalPy(py, peppurMoves, i);
			if(Math.abs(pfx)+Math.abs(pfy) <= i) {
				sb = new StringBuilder(""+i);
				break;
			}
		}
		System.out.println("Case #" + t + ": "+sb);
	}

	private int getFinalPy(int py, String peppurMoves, int i) {
		for(int j=0;j<i;j++) {
			switch (peppurMoves.charAt(j)) {
			case 'N':
				py++;
				break;
			case 'S':
				py--;
				break;

			default:
				break;
			}
		}
		return py;
	}

	private int getFinalPx(int px, String peppurMoves, int i) {
		for(int j=0;j<i;j++) {
			switch (peppurMoves.charAt(j)) {
			case 'E':
				px++;
				break;
			case 'W':
				px--;
				break;

			default:
				break;
			}
		}
		return px;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int testCases = s.nextInt();
		for (int i = 0; i < testCases; i++) {
			new Solution(i + 1, s).solve();
		}

		s.close();
	}

}
