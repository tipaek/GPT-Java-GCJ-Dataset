import java.util.*;
class Solution {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int numCases = in.nextInt();
		for (int curCase = 1; curCase <= numCases; curCase++) {
			int size = in.nextInt();
			ArrayList<Set<Integer>> rows = new ArrayList<Set<Integer>>();
			ArrayList<Set<Integer>> cols = new ArrayList<Set<Integer>>();
			for (int i = 0; i < size; i++) {
				Set<Integer> newRow = new HashSet<Integer>();
				Set<Integer> newCol = new HashSet<Integer>();
				rows.add(newRow);
				cols.add(newCol);
			}
			long trace = 0;
			for (int row = 0; row < size; row++) {
				for (int col = 0; col < size; col++) {
					int curNum = in.nextInt();
					if (row == col) 
						trace += curNum;
					rows.get(row).add(curNum);
					cols.get(col).add(curNum);
				}
			}
			int r = 0;
			for (Set<Integer> row: rows) {
				if (row.size() != size)
					r++;
			}
			int c = 0;
			for (Set<Integer> col: cols) {
				if (col.size() != size)
					c++;
			}
			System.out.println("Case #" + curCase + ": " + trace + " " + r + " " + c);
		}
	}
}
