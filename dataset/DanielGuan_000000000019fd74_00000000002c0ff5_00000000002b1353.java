import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		long[][] fib = new long[41][41];
		for (int line = 0; line < 41; line++) {
			for (int i = 0; i <= line; i++) {
				if (line == i || i == 0)
					fib[line][i] = 1;
				else
					fib[line][i] = fib[line - 1][i - 1] + fib[line - 1][i];
			}
		}
		long[][] minreq = new long[41][41];
		for (int a = 0; a < 41; a++)
			minreq[a][0] = a + 1;
		for (int a = 1; a < 41; a++)
			for (int b = 1; b < 41; b++)
				minreq[a][b] = minreq[a - 1][b - 1] + fib[a][b];
		for (int a = 1; a <= T; a++) {
			System.out.print("Case #" + a + ":");
			long N = Long.parseLong(in.readLine());
			LinkedList<Point> rev = new LinkedList<Point>();
			int currrow = 40;
			int currcol = 20;
			while (minreq[currrow][currcol] > N) {
				currrow--;
				currcol = currrow / 2;
			}
			long sum = 0;
			boolean right = false;
			while (currcol >= 0 && currrow >= 0) {
				sum += fib[currrow][currcol];
				if (currrow == currcol && currrow != 0)
					right = true;
				if (currrow == currcol || sum + minreq[currrow - 1][currcol] > N) {
					rev.addFirst(new Point(currrow, currcol));
					currcol--;
					currrow--;
					continue;
				}
				rev.addFirst(new Point(currrow, currcol));
				currrow--;
			}
			if (N != sum)
				rev.add((int) (N - sum),
						right ? new Point((int) (N - sum), (int) (N - sum - 1)) : new Point((int) (N - sum), 1));
			while (!rev.isEmpty()) {
				Point temp = rev.poll();
				System.out.println((temp.r + 1) + " " + (temp.c + 1));
			}
		}
	}

	static class Point {
		int r, c;

		Point(int R, int C) {
			r = R;
			c = C;
		}
	}
}