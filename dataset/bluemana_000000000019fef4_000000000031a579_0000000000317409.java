import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class Solution {

	public static void main(String[] args) throws Exception {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				Writer writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
			solve(reader, writer);
		}
	}
	
	private static void solve(BufferedReader reader, Writer writer) throws Exception {
		int testCount = Integer.parseInt(reader.readLine());
		for (int i = 0; i < testCount; i++) {
			solveTestCase(i, reader, writer);
		}
	}

	private static void solveTestCase(int t, BufferedReader reader, Writer writer) throws Exception {
		String[] tokens = reader.readLine().split(" ");
		int x = Integer.parseInt(tokens[0]);
		int y = Integer.parseInt(tokens[1]);
		String peppurMoves = tokens[2];
		int minMinutes = minMinutes(x, y, peppurMoves);
		writer.write(String.format("Case #%d: %s", t + 1, minMinutes == -1 ? "IMPOSSIBLE" : "" + minMinutes));
		writer.write("\n");
		writer.flush();
	}

	private static int minMinutes(int x, int y, String peppurMoves) {
		int result = -1;
		for (int minute = 1; minute <= peppurMoves.length(); minute++) {
			char move = peppurMoves.charAt(minute - 1);
			switch (move) {
				case 'N':
					y++;
					break;
				case 'E':
					x++;
					break;
				case 'S':
					y--;
					break;
				case 'W':
					x--;
					break;
			}
			int manhattanDistance = Math.abs(x) + Math.abs(y);
			if (manhattanDistance <= minute) {
				return minute;
			}
		}
		return result;
	}
}
