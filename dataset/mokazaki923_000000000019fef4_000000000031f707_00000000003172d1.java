
import java.awt.RenderingHints.Key;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.DirectoryStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		in.nextLine();

		for (int i = 1; i <= t; ++i) {
			System.out.println("Case #" + i + ": " + solve(in));
		}

	}

	private static String solve(Scanner in) {
		int n = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		int d = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		Map<Long, Integer> values = new HashMap<>();
		for (int i = 0; i < n; i++) {
			long value = in.nextLong();
			if(!values.containsKey(value))
				values.put(value,0);
			int count = values.get(value) + 1;
			values.put(value, count);
		}
		in.nextLine();

		if (d == 2) {
			for (int i : values.values()) {
				if (i >= 2)
					return "0";
			}
			return "1";
		} else {
			for (int i : values.values()) {
				if (i >= 3)
					return "0";
			}
			
			for(long key : values.keySet()) {
				int count = values.get(key);
				if (count < 2)
					continue;
				for (long key2 : values.keySet()) {
					if (key2 <= key)
						continue;
					return "1";
					
				}
				
			}

			
			for(long key : values.keySet()) {
				if (values.containsKey(key * 2))
					return "1";
			}
			return "2";
		}
	}

	private static int getIndex(char ch) {
		if (ch == 'N')
			return 2;
		if (ch == 'S')
			return 3;
		if (ch == 'E')
			return 0;
		return 1;
	}

	static int distance(int x, int y) {
		return Math.abs(x) + Math.abs(y);
	}

}

class TurnPos {
	int turn;
	int x;
	int y;

	TurnPos(int turn, int x, int y) {
		this.turn = turn;
		this.x = x;
		this.y = y;

	}
}