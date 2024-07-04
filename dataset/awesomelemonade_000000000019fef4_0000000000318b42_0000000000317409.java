import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = new PrintWriter(System.out);

		int t = Integer.parseInt(reader.readLine());
		for (int tt = 0; tt < t; tt++) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			int x = Integer.parseInt(tokenizer.nextToken());
			int y = Integer.parseInt(tokenizer.nextToken());
			String m = tokenizer.nextToken();

			if (x == 0 && y == 0) {
				writer.printf("Case #%d: %d\n", tt + 1, 0);
				continue;
			}

			char[] dirs = {'N', 'S', 'E', 'W'};
			int[] dx = {0, 0, 1, -1};
			int[] dy = {1, -1, 0, 0};

			int answer = -1;
			for (int i = 0; i < m.length(); i++) {
				char c = m.charAt(i);
				int index = -1;
				for (int j = 0; j < dirs.length; j++) {
					if (dirs[j] == c) {
						index = j;
						break;
					}
				}
				x += dx[index];
				y += dy[index];
				if (Math.abs(x) + Math.abs(y) <= i + 1) {
					answer = i + 1;
					break;
				}
			}
			if (answer == -1) {
				writer.printf("Case #%d: IMPOSSIBLE\n", tt + 1);
			} else {
				writer.printf("Case #%d: %d\n", tt + 1, answer);
			}
		}

		reader.close();
		writer.close();
	}
}
