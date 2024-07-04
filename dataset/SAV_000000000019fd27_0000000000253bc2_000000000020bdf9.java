import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			int N = sc.nextInt();
			int[][] mat = new int[N][2];
			String str = sc.nextLine();
			for (int j = 0; j < N; j++){
				String st = sc.nextLine();
				String[] strs = st.split("\\s+");
				for (int k = 0; k < 2; k++) {
					mat[j][k] = Integer.parseInt(strs[k]);
				}
			}
			Arrays.sort(mat, new java.util.Comparator<int[]>() {
				public int compare(int[] a, int[] b) {
					return (a[0] - b[0]);
				}
			});
			StringBuilder ans = new StringBuilder();
			Stack<Integer> c = new Stack<Integer>();
			Stack<Integer> j = new Stack<Integer>();
			c.push(mat[0][1]);
			ans.append("C");
			int flag = 0;
			for (int k = 1 ; k < N; k++) {
				int time = mat[k][0];
				int cTime = c.isEmpty() ? 0 : c.peek();
				int jTime = j.isEmpty() ? 0 : j.peek();
				if (time < cTime && time < jTime) {
					flag = 1;
					break;
				}
				if (time < cTime) {
					ans.append("J");
					j.push(mat[k][1]);
				} else {
					ans.append("C");
					c.push(mat[k][1]);
				}
			}
			if (flag == 1)
				System.out.println("Case #" + i + ": IMPOSSIBLE");
			else {
				System.out.println("Case #" + i + ": " + ans.toString());
			}
		}
	}
}
