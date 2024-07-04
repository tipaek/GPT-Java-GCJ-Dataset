
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Code Jam 2020 Round 1C
 */
public class Solution {

	public static void main(String args[]) {
		try (Scanner in = new Scanner(System.in);
				 PrintStream out = System.out;) {
			int t = in.nextInt();
			for (int i = 1; i <= t; i++) {
				String solution = solveNext(in);
				out.println("Case #" + i + ": " + solution);
				out.flush();
			}
		}
		System.exit(0);
	}

	public static String solveNext(Scanner in) {
		int numItems = in.nextInt();
		int target = in.nextInt();
		long[] items = new long[numItems];
		for (int i = 0; i < numItems; i++) {
			items[i] = in.nextLong();
		}
		return new Solution(numItems, target, items).solve();
	}

	int numItems;
	int target;
	long[] items;

	public Solution(int numItems, int target, long[] items) {
		this.numItems = numItems;
		this.target = target;
		this.items = items;
	}

	private int getMax0() {
		Map<Long, Integer> counts = new HashMap<>();
		int maxCount = 1;
		for (int i = 0; i < this.numItems; i++) {
			long curr = this.items[i];
			Integer count = counts.get(curr);
			if (count == null) {
				count = 0;
			}
			count++;
			counts.put(curr, count);
			maxCount = Math.max(maxCount, count);
		}
		return maxCount;
	}

	private int getMax1() {
		Map<Long, Integer> counts = new HashMap<>();

		for (int i = 0; i < this.numItems; i++) {
			long curr = this.items[i];
			Integer count = counts.get(curr);
			if (count == null) {
				count = 0;
			}
			count++;
			counts.put(curr, count);
		}

		int maxCount = 2;
		for (int i = 0; i < this.numItems; i++) {
			long curr1 = this.items[i];
			for (int j = 0; j < this.numItems; j++) {
				if (i == j) {
					continue;
				}
				long curr2 = this.items[j];
				Integer count2 = counts.get(curr2);
				if (curr2 * 2 == curr1) {
					maxCount = Math.max(maxCount, count2 + 2);
				} else if (curr2 < curr1) {
					maxCount = Math.max(maxCount, count2 + 1);
				}
			}
		}
		return maxCount;
	}

	public String solve() {
		if (this.getMax0() >= this.target) {
			return "0";
		}
		if (this.getMax1() >= this.target) {
			return "1";
		}
		return "2";
	}
}
