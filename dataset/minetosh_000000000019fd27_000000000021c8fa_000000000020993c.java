import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map.Entry;

public class Solution {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			System.out.println("Case #" + i + ": " + resolv(sc));
		}
	}

	private static String resolv(Scanner sc) {
		int N = sc.nextInt();
		int n;
		int s;
		int S = 0;
		ArrayList<HashMap<Integer, Integer>> rows =
			new ArrayList<HashMap<Integer, Integer>>();
		for (int i = 0; i < N; i++)
			rows.add(new HashMap<Integer, Integer>());
		ArrayList<HashMap<Integer, Integer>> cols =
			new ArrayList<HashMap<Integer, Integer>>();
		for (int i = 0; i < N; i++)
			cols.add(new HashMap<Integer, Integer>());
		HashMap<Integer, Integer> row, col;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				n = sc.nextInt();
				row = rows.get(i);
				if (row.containsKey(n)) {
					s = row.get(n);
					row.put(n, s + 1);
				} else {
					row.put(n, 1);
				}
				col = cols.get(j);
				if (col.containsKey(n)) {
					s = col.get(n);
					col.put(n, s + 1);
				} else {
					col.put(n, 1);
				}
				if (i == j)
					S += n;
			}
		}
		int maxRow = 0;
		for (int i = 0; i < N; i++) {
			row = rows.get(i);
			for (Entry<Integer, Integer> entry : row.entrySet())
				maxRow = Math.max(maxRow, entry.getValue());
		}
		if (maxRow == 1)
			maxRow = 0;
		int maxCol = 0;
		for (int j = 0; j < N; j++) {
			col = cols.get(j);
			for (Entry<Integer, Integer> entry : col.entrySet())
				maxCol = Math.max(maxCol, entry.getValue());
		}
		if (maxCol == 1)
			maxCol = 0;
		return S + " " + maxRow + " " + maxCol;
	}
}