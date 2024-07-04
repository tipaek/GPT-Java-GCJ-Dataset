import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for (int j = 1; j <= t; ++j) {
			int N = in.nextInt();

			int[][] activities = new int[N][2];
			for(int i = 0; i < N; i++) {
				int start = in.nextInt();
				int end = in.nextInt();
				activities[i][0] = start;
				activities[i][1] = end;
			}

			char[] assignments = new char[N];
			Arrays.fill(assignments, '0');

			List<int[]> freetimeC = new ArrayList<int[]>();
			List<int[]> freetimeJ = new ArrayList<int[]>();

			freetimeC.add(new int[]{0, 1440});
			freetimeJ.add(new int[]{0, 1440});


			if(! assign(activities, assignments, 0, freetimeC, freetimeJ)) {
				System.out.println("Case #" + j + ": IMPOSSIBLE");
			} else {
				String ret = "";
				for(int i = 0; i < assignments.length; i++) {
					ret += assignments[i];
				}
				System.out.println("Case #" + j + ": " + ret);
			}

			// System.out.println("Case #" + i + ": OK");
 			// NumberFormat formatter = new DecimalFormat("#0.000000");   
			// System.out.println("Case #" + i + ": " + formatter.format(D/max));
		}
		in.close();
	}

	private static boolean assign(int[][] activities, char[] assignments, int i, List<int[]> freetimeC, List<int[]> freetimeJ) {
		if(i == assignments.length) return true;

		int start = activities[i][0];
		int end = activities[i][1];

		List<int[]> free = findFreeAndAssign(freetimeC, start, end);
		if(free != null) {
			assignments[i] = 'C';
			if(assign(activities, assignments, i+1, freetimeC, freetimeJ))
				return true;
			releaseFreeTime(freetimeC, free);
		}

		free = findFreeAndAssign(freetimeJ, start, end);
		if(free != null) {
			assignments[i] = 'J';
			if(assign(activities, assignments, i+1, freetimeC, freetimeJ))
				return true;
			releaseFreeTime(freetimeJ, free);
		}

		return false;
	}

	private static void releaseFreeTime(List<int[]> freetime, List<int[]> free) {
		freetime.add(free.get(0));
		if(free.size() > 1) {
			freetime.remove(free.get(1));
		}
		if(free.size() > 2) {
			freetime.remove(free.get(2));
		}
	}

	private static List<int[]> findFreeAndAssign( List<int[]> freetime, int start, int end) {
		List<int[]> ret = new ArrayList<>();
		for(int i = 0; i < freetime.size(); i++) {
			int[] slot = freetime.get(i);
			if(start >= slot[0] && slot[1] >= end) {
				ret.add(slot);
				freetime.remove(i);
				if(slot[1] > end) {
					int[] add = new int[]{end, slot[1]};
					freetime.add(i, add);
					ret.add(add);
				}
				if(slot[0] < start) {
					int[] add = new int[]{slot[0], start};
					freetime.add(i, add);
					ret.add(add);
				}

				return ret;
			}
		}
		return null;
	}
}
