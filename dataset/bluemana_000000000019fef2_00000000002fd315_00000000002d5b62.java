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
        long x = Long.parseLong(tokens[0]);
        long y = Long.parseLong(tokens[1]);
        String solution = findPath(x, y);
        writer.write(String.format("Case #%d: %s\n", t + 1, solution == null ? "IMPOSSIBLE" : solution));
        writer.flush();
    }

	private static String findPath(long x, long y) {
		long distance = Math.abs(x) + Math.abs(y);
		long i = (int) (Math.log(distance * 2) / Math.log(2));
		StringBuffer solution = new StringBuffer();
		while (i > 0) {
			long jump = (long) Math.pow(2, i - 1);
			if (Math.abs(y) >= Math.abs(x)) {
				if (y >= 0) {
					y = y - jump;
					solution.append("N");
				} else {
					y = y + jump;
					solution.append("S");
				}
			} else {
				if (x >= 0) {
					x = x - jump;
					solution.append("E");
				} else {
					x = x + jump;
					solution.append("W");
				}
			}
			i--;
		}
		if (x == 0 && y == 0 && solution.length() > 0) {
			return solution.reverse().toString();
		} else {
			return "IMPOSSIBLE";
		}
	}
}