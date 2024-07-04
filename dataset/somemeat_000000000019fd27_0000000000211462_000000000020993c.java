import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int[][] mat;
		StringTokenizer st;
		Set<Integer> dupsrow = new HashSet<Integer>();
		Set<Integer> dupscol = new HashSet<Integer>();
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			mat = new int[n][n];
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < n; k++) {
					mat[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			int trace = 0;
			for (int j = 0; j < n; j++) {
				trace += mat[j][j];
			}
			// check rows
			int numrows = 0;
			int numcols = 0;
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					dupsrow.add(mat[j][k]);
					dupscol.add(mat[k][j]);
				}
				if (dupsrow.size() != n) {
					numrows++;
				}
				if (dupscol.size() != n) {
					numcols++;
				}
				dupsrow.clear();
				dupscol.clear();
			}
			System.out.println("Case #" + (i + 1) + ": " + trace + " " + numrows + " " + numcols);
		}
	}

}
