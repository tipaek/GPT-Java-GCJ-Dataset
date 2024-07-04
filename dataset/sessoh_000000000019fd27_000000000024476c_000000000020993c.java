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
			int N = Integer.parseInt(br.readLine());
			int k = 0;
			int[][] ra = new int[N][N];
			int[][] ca = new int[N][N];
			for (int y = 0; y < N; y++) {
				String[] s = br.readLine().split(" ");
				for (int x = 0; x < N; x++) {
					int m = Integer.parseInt(s[x]);
					if (x == y) k += m;
					m--;
					ra[y][m]++;
					ca[x][m]++;
				}
			}
			
			int r = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (ra[i][j] > 1) { r++; break; }
				}
			}
			int c = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (ca[i][j] > 1) { c++; break; }
				}
			}
			
			pw.println("Case #" + t + ": " + k + " " + r + " "+ c);
			pw.flush();
		}
	}
}
