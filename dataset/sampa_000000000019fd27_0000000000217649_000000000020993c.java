import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Set<Integer> set = new HashSet();

		int T = s.nextInt();
		for(int i = 1; i <= T; i++) {
			int N = s.nextInt();
			int[][] mat = new int[N][N];
			int dsum = 0, rdc = 0, cdc = 0;
			boolean df;

			for (int j = 0; j < N; j++) {
				set.clear();
				df = false;
				
				for (int k = 0; k < N; k++) {
					mat[j][k] = s.nextInt();
					if (set.contains(mat[j][k])) {
						df = true;
					}
					set.add(mat[j][k]);
				}

				dsum += mat[j][j];
				if (df) {
					rdc++;
				}
			}

			for (int j = 0; j < N; j++) {
				set.clear();
				df = false;

				for (int k = 0; k < N; k++) {
					if (set.contains(mat[k][j])) {
						df = true;
						break;
					}
					set.add(mat[k][j]);
				}

				if (df) {
					cdc++;
				}
			}

			System.out.println("Case #" + i + ": " + dsum + " " + rdc + " " + cdc);
		}

		s.close();
	}
}