import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(scan.readLine());

		for (int i = 1; i <= t; i++) {
			int k = 0;
			int r = 0;
			int c = 0;

			int N = Integer.parseInt(scan.readLine());
			int[][] arr = new int[N][N];

			for (int p = 0; p < N; p++) {
				boolean foundRow = false;
				Set<Integer> rowSet = new HashSet<>();
				String[] row = scan.readLine().split(" ");

				for (int q = 0; q < N; q++) {
					arr[p][q] = Integer.parseInt(row[q]);
					if (!foundRow) {
						if (!rowSet.add(arr[p][q])) {
							foundRow = true;
							r++;
						}
					}
				}
				k += arr[p][p];
			}

			for(int _c = 0; _c < N; _c++) {
				Set<Integer> colSet = new HashSet<>();
				boolean foundCol = false;
				for(int _r=0; _r < N; _r++) {
					if (!foundCol) {
						if (!colSet.add(arr[_r][_c])) {
							foundCol = true;
							c++;
						}
					}
				}
			}


			System.out.println("Case #"+i+": "+k+" "+r+" "+c);
		}
	}


}
