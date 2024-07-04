
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.DirectoryStream;
import java.util.ArrayList;
import java.util.List;
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
		int x = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		int y = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		String path = in.nextLine().trim();
		
		int [] dys = {0,0,1,-1};
		int[] dxs = {1,-1,0,0};
		List<TurnPos> posList = new ArrayList<>();
		for (int i = 0; i < path.length(); i++) {
			char ch = path.charAt(i);
			posList.add(new TurnPos(i, x, y));
			int distance = distance(x, y);
			if (distance <= i)
				return "" + i;
			int index = getIndex(ch);
			x += dxs[index];
			y += dys[index];
		}
		if (distance(x, y) <= path.length())
			return "" + path.length();

		return "IMPOSSIBLE";
	}

	private static int getIndex(char ch) {
		if (ch == 'N')
			return 2;
		if (ch == 'S')
			return 3;
		if (ch == 'E')
			return 1;
		return 0;
	}

	static int distance (int x, int y) {
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