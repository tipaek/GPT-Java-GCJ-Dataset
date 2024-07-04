import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for (int j = 1; j <= t; ++j) {
			int size = in.nextInt();

			List<Set<Integer>> rows = new ArrayList<>();
			List<Set<Integer>> cols = new ArrayList<>();

			for(int row = 0; row < size; row++) {
				rows.add(new HashSet<>());
				cols.add(new HashSet<>());
			}
			int trace = 0;
			for(int row = 0; row < size; row++) {
				for(int col = 0; col < size; col++) {
					int item = in.nextInt();
					rows.get(row).add(item);
					cols.get(col).add(item);
					if(row == col) {
						trace += item;
					}
				}
			}

			int badrows = 0;
			int badcols = 0;
			for(int row = 0; row < size; row++) {
				if(rows.get(row).size() != size) {
					badrows++;
				}
				if(cols.get(row).size() != size) {
					badcols++;
				}
			}

			System.out.println("Case #" + j + ": " + trace + " " + badrows + " " + badcols);

			// System.out.println("Case #" + i + ": OK");
			// NumberFormat formatter = new DecimalFormat("#0.000000");
			// System.out.println("Case #" + i + ": " + formatter.format(D/max));
		}
		in.close();
	}
}