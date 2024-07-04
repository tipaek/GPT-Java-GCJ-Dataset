import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		int min_per_day = (60 * 24) + 1;
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			char[] array = new char[n];
			int[] jamie = new int[min_per_day];
			int[] cameron = new int[min_per_day];
			boolean impossible = false;
			for (int x = 0; x < n; ++x) {
				int start = in.nextInt();
				int end = in.nextInt();
				if (check_overlapping(cameron, start, end)) {
					for (int z = start; z <= end; z++)
						cameron[z] = n;
					array[x] = 'C';
				} else if (check_overlapping(jamie, start, end)) {
					for (int z = start; z <= end; z++)
						jamie[z] = n;
					array[x] = 'J';
				} else {
					impossible = true;
					break;
				}
				;

			}
			if (impossible == true) {
				System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
				impossible = false;
			} else
				System.out.println("Case #" + i + ": " + new String(array));
		}
	}

	public static boolean check_overlapping(int[] array, int start, int end) {
		for (int i = start; i <= end; i++) {
			if ( i == start || i == end )
				;
			else if (array[i] != 0)
				return false;
		}
		return true;
	}
}