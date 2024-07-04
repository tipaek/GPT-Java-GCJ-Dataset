import java.io.*;
import java.util.*;

/**
 * Vestigium
 * @author: av-sharma
 */

public class Solution {

	public static void main(String[] args) {
		FastReader fr = new FastReader();
		long T = fr.nextLong();
		long t = 0;

		while (t++ < T) {
			int n = fr.nextInt();
			long[][] mat = new long[n][n];
			long diagSum = 0;
			long nCol = 0, nRow = 0;
			ArrayList<HashSet<Long>> colSet = new ArrayList<>();
			HashSet<Long> rowSet = new HashSet<>();

			for (int i = 0; i < n; i++) colSet.add(new HashSet<>());
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					mat[i][j] = fr.nextLong();
					rowSet.add(mat[i][j]);
					colSet.get(j).add(mat[i][j]);
					if (i == j) diagSum += mat[i][j];
				}
				if (rowSet.size() == n) continue;
				else nRow++;
				rowSet.clear();
			}
			for (int i = 0; i < n; i++)
				if (colSet.get(i).size() == n) continue;
				else nCol++;

			System.out.println("Case #" + t + ": " + diagSum + " " + nRow + " " + nCol);
		}
	}
}

// FastReader Util Class
class FastReader {
	BufferedReader br;
	StringTokenizer st;

	public FastReader() {
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	String next() {
		while (st == null || !st.hasMoreElements()) {
			try {
				st = new StringTokenizer(br.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return st.nextToken();
	}

	String nextLine() {
		String str = "";
		try {
			str = br.readLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}

	int nextInt() {
		return Integer.parseInt(next());
	}

	Long nextLong() {
		return Long.parseLong(next());
	}

	Double nextDouble() {
		return Double.parseDouble(next());
	}
}