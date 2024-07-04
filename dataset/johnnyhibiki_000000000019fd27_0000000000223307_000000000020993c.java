import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class GCJ2020Q_A {

	String fnc(int n, int[][] map) {
		int k = 0;
		int r = 0;
		int c = 0;

		for (int i = 0; i < n; i++) {
			k += map[i][i];
		}

		Set<Integer> s = new HashSet<Integer>();

		for (int i = 0; i < n; i++) {
			s.clear();
			for (int j = 0; j < n; j++) {
				s.add(map[i][j]);
			}
			if (s.size() != n) {
				r++;
			}
		}

		for (int j = 0; j < n; j++) {
			s.clear();
			for (int i = 0; i < n; i++) {
				s.add(map[i][j]);
			}
			if (s.size() != n) {
				c++;
			}
		}

		return k + " " + r + " " + c;
	}

	void run() {
		try (Scanner sc = new Scanner(System.in)) {
			int testNum = sc.nextInt();
			for (int t = 1; t <= testNum; t++) {
				int n = sc.nextInt();
				int[][] map = new int[n][n];
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						map[i][j] = sc.nextInt();
					}
				}

				System.out.println("Case #" + t + ": " + fnc(n, map));
			}
		}
	}

	public static void main(String[] args) {
		new GCJ2020Q_A().run();
	}
}
