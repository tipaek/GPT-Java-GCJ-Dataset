import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		OutputStream outputStream = System.out;
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		OutputStreamWriter w = new OutputStreamWriter(outputStream, "UTF-8");
		int testCount = Integer.parseInt(reader.readLine());
		for (int i = 1; i <= testCount; i++) {
			solve(i, reader, w);
		}
		w.close();
	}

	public static void solve(int i, BufferedReader reader,
			OutputStreamWriter writer) throws NumberFormatException,
			IOException {
		int[] line = Arrays.stream(reader.readLine().split(" "))
				.mapToInt(Integer::parseInt).toArray();
		int x = line[0];
		int y = line[1];

		int iterations = 0;
		ArrayList<String> basket = new ArrayList<String>();
		jump("", 0, 0, 1, x, y, basket, iterations);

		int minLength = Integer.MAX_VALUE;
		String ret = "IMPOSSIBLE";
		for (int k = 0; k < basket.size(); k++) {
			if (basket.get(k).length() < minLength) {
				minLength = basket.get(k).length();
				ret = basket.get(k);
			}
		}

		writer.write("Case #" + i + ": " + ret + "\r\n");
	}

	public static void jump(String path, int x, int y, int dist, int goal_x,
			int goal_y, ArrayList<String> basket, int iterations) {
		if (x == goal_x && y == goal_y) {
			basket.add(path);
			return;
		}
		if (iterations > 10) {
			return;
		}
		iterations += 1;
		jump(path + "E", x + dist, y, dist * 2, goal_x, goal_y, basket,
				iterations);
		jump(path + "W", x - dist, y, dist * 2, goal_x, goal_y, basket,
				iterations);
		jump(path + "N", x, y + dist, dist * 2, goal_x, goal_y, basket,
				iterations);
		jump(path + "S", x, y - dist, dist * 2, goal_x, goal_y, basket,
				iterations);
	}
}
