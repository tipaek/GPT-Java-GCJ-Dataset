import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			int activities = in.nextInt();
			char[] result = new char[activities];
			boolean[] cameron = new boolean[1441];
			boolean[] jamie = new boolean[1441];
			boolean impossible = false;
			for (int x = 0; x < activities; x++) {
				int start = in.nextInt();
				int end = in.nextInt();
				if (time_available(cameron, start, end)) {
					for (int y = start; y <= end; y++)
						cameron[y] = true;
					result[x] = 'C';
				} else if (time_available(jamie, start, end)) {
					for (int z = start; z <= end; z++)
						jamie[z] = true;
					result[x] = 'J';
				} else {
					impossible = true;
				}
			}
			if (impossible) {
				System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
				impossible = false;
			} else {
				System.out.println("Case #" + i + ": " + String.valueOf(result));
			}
		}
	}

	public static boolean time_available(boolean[] schedule, int s, int e) {
		for (int i = (s + 1); i < e; i++) {
			if (schedule[i])
				return false;
		}
		return true;
	}
}