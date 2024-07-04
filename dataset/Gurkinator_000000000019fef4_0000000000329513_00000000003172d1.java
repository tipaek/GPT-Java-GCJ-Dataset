import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	private Scanner scanner = new Scanner(System.in);

	private long solve() throws Exception {
		int		n	= scanner.nextInt();
		int		d	= scanner.nextInt();
		long[]	arr	= new long[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scanner.nextLong();
		}
		long allSmallest = d;
		Arrays.parallelSort(arr);
		for (int i = 0; i < arr.length; i++) {
			int count = 0;
			for (int j = i; j < arr.length; j++) {
				if (arr[i] / arr[j] == 1) count++;
			}
			int need = d - count;
			if (need <= 0) return 0;
			long smallest = 0;
			if (d % 2 == 0) smallest = d / 2;
			else smallest = d / 2 + 1;
			for (int j = i; j < arr.length; j++) {
				if (arr[i] / arr[j] == 1) continue;
				if (arr[j] / arr[i] >= need) {
					if (arr[j] / arr[i] % 2 == 0) {
						if (arr[j] / arr[i] / 2 < smallest) smallest = arr[j] / arr[i] / 2;
					} else {
						if ((arr[j] / arr[i] / 2) + 1 < smallest) smallest = (arr[j] / arr[i] / 2) + 1;
					}
				}
			}
			if (smallest < allSmallest) { allSmallest = smallest; }

			i += count - 1;
		}
		return allSmallest;
	}

	private void run() throws Exception {
		int t = scanner.nextInt();
		for (int i = 0; i < t; i++) {
			System.out.printf("Case #%d: %d%n", i + 1, solve());
		}
	}

	public static void main(String[] args) throws Exception { new Solution().run(); }
}
