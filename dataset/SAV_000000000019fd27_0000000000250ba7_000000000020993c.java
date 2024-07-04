import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			int N = sc.nextInt();
			int[][] mat = new int[N][N];
			String str = sc.nextLine();
			int trace = 0;
			for (int j = 0; j < N; j++){
				String st = sc.nextLine();
				String[] strs = st.split("\\s+");
				for (int k = 0; k < N; k++) {
					mat[j][k] = Integer.parseInt(strs[k]);
					if (j == k) {
						trace += mat[j][k];
					}
				}
			}

			//get for rows
			int rowCount = 0;
			for (int j = 0; j < N; j++) {
				Set<Integer> set = new HashSet<>();
				int flag = 0;
				for (int k = 0; k < N; k++){
					if (set.contains(mat[j][k])) {
						flag = 1;
						break;
					} else {
						set.add(mat[j][k]);
					}
				}
				if (flag == 1) {
					rowCount++;
				}
			}
			int colCount = 0;
			for (int j = 0; j < N; j++) {
				Set<Integer> set = new HashSet<>();
				int flag = 0;
				for (int k = 0; k < N; k++){
					if (set.contains(mat[k][j])) {
						flag = 1;
						break;
					} else {
						set.add(mat[k][j]);
					}
				}
				if (flag == 1) {
					colCount++;
				}
			}
			System.out.println("Case #" + i + ": " + trace + " " + rowCount + " " + colCount);
		}
	}
}
