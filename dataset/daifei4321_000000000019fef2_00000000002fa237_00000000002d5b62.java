import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int t = 0; t < T; t++) {
			int X = in.nextInt();
			int Y = in.nextInt();
			int MAX = 8;
			int[] dir = new int[MAX];
			int doneCount = 1;
			boolean found = false;
			loopAll:
			for (;;) {
				int dx = 0;
				int dy = 0;
				for (int i = 0, step = 1; i < doneCount; i++, step *= 2) {
					if (dir[i] == 0) {
						dy -= step;
					} else if (dir[i] == 1) {
						dx += step;
					} else if (dir[i] == 2) {
						dy += step;
					} else {
						dx -= step;
					}
				}
//				System.err.println(Arrays.toString(dir) + "[" + doneCount + "] " + dx + " " + dy);
				if (dx == X && dy == Y) {
					found = true;
					break;
				}
				int flushAt = 0;
				while (dir[flushAt] == 3) {
					flushAt++;
					if (flushAt == MAX) {
						break loopAll;
					}
				}
				for (int i = 0; i < flushAt; i++) {
					dir[i] = 0;
				}
				if (flushAt == doneCount) {
					doneCount++;
				} else {
					dir[flushAt]++;
				}
			}
			if (!found) {
				System.out.println("CASE #" + (t + 1) + ": IMPOSSIBLE");
			} else {
				String[] dirS = new String[] { "S", "E", "N", "W" };
				System.out.print("CASE #" + (t + 1) + ": ");
				for (int i = 0; i < doneCount; i++) {
					System.out.print(dirS[dir[i]]);
				}
				System.out.println();
			}
		}
	}
}
