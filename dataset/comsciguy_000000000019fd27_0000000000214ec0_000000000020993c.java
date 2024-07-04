import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int tci = 0; tci < tc; tci++) {
			int n = Integer.parseInt(br.readLine());
			int[][] mat = new int[n][n];
			StringTokenizer st;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int j = 0;
				while (st.hasMoreTokens())
					mat[i][j++] = Integer.parseInt(st.nextToken());
			}
//			for (int[] k : mat)
//				System.out.println(Arrays.toString(k));
			
			System.out.printf("Case #%d: %d %d %d\n", tci+1, trace(mat), rows(mat), cols(mat));
		}
		br.close();
	}
	
	public static int trace(int[][] mat) {
		int sum = 0;
		for (int i = 0; i < mat.length; i++)
			sum+=mat[i][i];
		return sum;
	}
	public static int rows(int[][] mat) {
		int rc = 0;
		for (int i = 0; i < mat.length; i++) {
			Set<Integer> set = new HashSet<>();
			for (int j = 0; j < mat.length; j++)
				set.add(mat[i][j]);
			if (set.size() != mat.length)
				rc++;
		}
		return rc;
	}
	public static int cols(int[][] mat) {
		int cc = 0;
		for (int j = 0; j < mat.length; j++) {
			Set<Integer> set = new HashSet<>();
			for (int i = 0; i < mat.length; i++)
				set.add(mat[i][j]);
			if (set.size() != mat.length)
				cc++;
		}
		return cc;
	}
}
