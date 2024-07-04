import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for(int t = 0; t < T; t++) {
			int N = scan.nextInt();
			int trace = 0;
			boolean[][] cols = new boolean[N][N+1];
			boolean[][] rows = new boolean[N][N+1];
			int dup_r = 0;
			int dup_c = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int v = scan.nextInt();
					if (i == j) {
						trace += v;
					}
					if (rows[i][v]) {
						rows[i][0] = true;
					} else {
						rows[i][v] = true;
					}
					if (cols[j][v]) {
						cols[j][0] = true;
					} else {
						cols[j][v] = true;
					}
					if (i == N-1 && cols[j][0]) {
						dup_c++;
					}
				}
				if (rows[i][0]) dup_r++;
			}
			System.out.println("Case #"+t+": "+trace+" "+dup_r+" "+dup_c);

		}
		scan.close();
		
	}
}