import java.util.Scanner;
import java.util.Arrays;
import java.util.HashSet;
import java.util.HashMap;
import java.util.ArrayList;

public class Solution {

	public static void main(String args[]) {
		preproc();
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++)
			System.out.print("Case #" + i + ": " + resolv(sc));
	}

	static HashMap<Integer, ArrayList<int[][]>> possible =
		new HashMap<Integer, ArrayList<int[][]>>();

	public static void saveTable(int tn, int t[][]) {
		ArrayList<int[][]> list;
		if (possible.containsKey(tn))
			list = possible.get(tn);
		else
			list = new ArrayList<int[][]>();
		list.add(t);
		possible.put(tn, list);
	}

	public static void makeMatrix(int tn, int t[][], int ti, int tj) {
		if (ti >= tn) {
			ti = 0;
			tj++;
		}
		if (tj >= tn) {
			saveTable(tn, t);
			return;
		}

		HashSet<Integer> hs = new HashSet<Integer>();
		for (int i = 0; i < ti; i++)
			hs.add(t[i][tj]);
		for (int j = 0; j < tj; j++)
			hs.add(t[ti][j]);
		for (int n = 1; n <= tn; n++) {
			if (hs.contains(n))
				continue;
			int copy[][] = new int[tn][tn];
			for (int i = 0; i < tn; i++)
				for (int j = 0; j < tn; j++)
					copy[i][j] = t[i][j];
			copy[ti][tj] = n;
			makeMatrix(tn, copy, ti + 1, tj);
		}
	}

	public static void preproc() {
		makeMatrix(2, new int[2][2], 0, 0);
		makeMatrix(3, new int[3][3], 0, 0);
		makeMatrix(4, new int[4][4], 0, 0);
		makeMatrix(5, new int[5][5], 0, 0);
	}

	private static String resolv(Scanner sc) {
		int N = sc.nextInt();
		int K = sc.nextInt();

		ArrayList<int[][]> list = possible.get(N);
		for (int n = 0; n < list.size(); n++) {
			int matrix[][] = list.get(n);
			int sum = 0;
			for (int i = 0; i < N; i++)
				sum += matrix[i][i];
			if (sum == K) {
				StringBuffer sb = new StringBuffer();
				sb.append("POSSIBLE\n");
				for (int j = 0; j < N; j++) {
					for (int i = 0; i < N; i++) {
						sb.append(matrix[i][j]);
						if (i == N - 1)
							sb.append('\n');
						else
							sb.append(' ');
					}
				}
				return sb.toString();
			}
		}
		return "IMPOSSIBLE\n";
	}
}
