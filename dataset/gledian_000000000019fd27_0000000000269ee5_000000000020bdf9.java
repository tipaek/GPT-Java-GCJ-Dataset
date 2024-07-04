import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; i++) {
			int n = in.nextInt();
			String result = new String();
			boolean[] jamie = new boolean[1441];
			boolean[] cameron = new boolean[1441];
			boolean impossible = false;
			for (int x = 0; x < n; x++) {
				int start = in.nextInt();
				int end = in.nextInt();
				if (check_overlapping(cameron, start, end)) {
					for (int z = start; z <= end; z++)
						cameron[z] = true;
					result = result + 'C';
				} else if (check_overlapping(jamie, start, end)) {
					for (int z = start; z <= end; z++)
						jamie[z] = true;
					result = result + 'J';
				} else {
					impossible = true;
					break;
				};
			}
			if (impossible == true) {
				System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
				impossible = false;
			} else if( i == t)
				System.out.print("Case #" + i + ": " + result);
			else
				System.out.println("Case #" + i + ": " + result);
		}
	}

	public static boolean check_overlapping(boolean[] array, int start, int end) {
		for (int i = start; i <= end; i++) {
			if ( i == start || i == end )
				continue;
			else if (array[i])
				return false;
		}
		return true;
	}
}