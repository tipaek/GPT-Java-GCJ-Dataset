import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; ++t) {
			String[] str = br.readLine().split(" ");
			int R = Integer.parseInt(str[0]);
			int C = Integer.parseInt(str[1]);
			int[][] map = new int[R][C];
			for (int r = 0; r < R; r++) {
				str = br.readLine().split(" ");
				for (int c = 0; c < C; c++) {
					map[r][c] = Integer.parseInt(str[c]);
				}
			}
			
			long score = 0;
			for (int down = 1; down > 0; ) {
				down = 0;
				int[][] sum = new int[R][C];
				int[][] count = new int[R][C];
				int[] colnbs = new int[C];
				int[] colnbp = new int[C];
				for (int r = 0; r < R; r++) {
					int rownbs = 0;
					int rownbp = 0;
					for (int c = 0; c < C; c++) {
						if (map[r][c] > 0) {
							if (colnbs[c] > 0) {
								sum[colnbp[c]][c] += map[r][c];
								count[colnbp[c]][c]++;
								sum[r][c] += colnbs[c];
								count[r][c]++;
							}
							colnbs[c] = map[r][c];
							colnbp[c] = r;
							if (rownbs > 0) {
								sum[r][rownbp] += map[r][c];
								count[r][rownbp]++;
								sum[r][c] += rownbs;
								count[r][c]++;
							}
							rownbs = map[r][c];
							rownbp = c;
						}
					}
				}
				for (int r = 0; r < R; r++) {
					for (int c = 0; c < C; c++) {
						if (map[r][c] > 0) {
							score += (long)map[r][c];
							if (map[r][c] * count[r][c] < sum[r][c]) {
								map[r][c] = 0;
								down++;
							}
						}
					}
				}
			}
			
			pw.print("Case #" + t + ": "+score);
			pw.println();
			pw.flush();
		}
	}
}
