
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

class Solution {
	public static void main(String ar[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt(), counter = 1;
		
		while (t-- > 0) {
			int trace = 0;

			int n = sc.nextInt();
			ArrayList<TreeSet<Integer>> row = new ArrayList<TreeSet<Integer>>();
			ArrayList<TreeSet<Integer>> col = new ArrayList<TreeSet<Integer>>();
			for (int i = 0; i < n; i++) {
				TreeSet< Integer > x  = new TreeSet< Integer>();
				TreeSet< Integer > y  = new TreeSet< Integer>();
				
				row.add(x);
				col.add(y);

			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int num = sc.nextInt();
					row.get(i).add(num);
					col.get(j).add(num);

					if (i == j)
						trace += num;
				}
			}
			int r = getCount(row, n);
			int c = getCount(col, n);
			System.out.println("Case #" + counter + ": " + trace + " " + r + " " + c);
			counter++;
		}
	}

	private static int getCount(ArrayList<TreeSet<Integer>> t, int n) {
		int count = 0;

		for (int i = 0; i < t.size(); i++) {
			if (!(t.get(i).size() == n))
				count++;
		}
		return count;
	}
}
