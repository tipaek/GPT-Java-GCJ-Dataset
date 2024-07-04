import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			int N = sc.nextInt();
			int[][] mat = new int[N][3];
			String str = sc.nextLine();
			for (int j = 0; j < N; j++){
				String st = sc.nextLine();
				String[] strs = st.split("\\s+");
				for (int k = 0; k < 2; k++) {
					mat[j][k] = Integer.parseInt(strs[k]);
				}
				mat[j][2] = j;
			}
			Arrays.sort(mat, new java.util.Comparator<int[]>() {
				public int compare(int[] a, int[] b) {
					return (a[0] - b[0]);
				}
			});
			int c = 0;
			int j = 0;
			char[] ans = new char[N];
			c = mat[0][1];
			ans[mat[0][2]] = 'C';
			int flag = 0;
			for (int k = 1 ; k < N; k++) {
				int time = mat[k][0];
				if (time < c && time < j) {
					flag = 1;
					break;
				}
				if (time < c) {
					ans[mat[k][2]] = 'J';
					j = mat[k][1];
				} else {
					ans[mat[k][2]] = 'C';
					c = mat[k][1];
				}
			}
			if (flag == 1)
				System.out.println("Case #" + i + ": IMPOSSIBLE");
			else {
				String o = new String(ans);
				System.out.println("Case #" + i + ": " + o);
			}
		}
	}
}
