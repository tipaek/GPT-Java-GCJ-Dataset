import java.util.*;
public class CJ2020Q1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		for (int t = 1; t <= tc; t++) {
			int n = in.nextInt();
			int[][] table = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					table[i][j] = in.nextInt();
				}
			}
			int trace = 0;
			for (int i = 0; i < n; i++)
				trace += table[i][i];
			
			int r = 0;
			for (int i = 0; i < n; i++) { // each row
				HashSet<Integer> h = new HashSet<Integer>();
				for (int j = 0; j < n; j++)
					h.add(table[i][j]);
				if (h.size() < n) r++;
			}
			
			int c = 0;
			for (int i = 0; i < n; i++) {
				HashSet<Integer> h = new HashSet<Integer>();
				for (int j = 0; j < n; j++)
					h.add(table[j][i]);
				if (h.size() < n) c++;
			}
			
			System.out.println("Case #" + t + ": " + trace + " " + r + " " + c);
		}
	}
}
