import java.util.*;
import java.io.*;

public class Solution {
	static int[][] square;
	static int size;
	static boolean[][] columns;
	static HashSet<Integer> currentRow;

	public static void main(String[] args) throws IOException {
		BufferedReader bufread = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bufread.readLine());
		for (int counter = 0; counter < t; counter++) {
			StringTokenizer st = new StringTokenizer(bufread.readLine());
			size = Integer.parseInt(st.nextToken());
			square = new int[size][size];
			columns = new boolean[size][size];
			int trace = Integer.parseInt(st.nextToken());
			double diagVal = trace / size;
			if (diagVal < 1 || diagVal > size) {
				System.out.println("Case #" + (counter + 1) + ": IMPOSSIBLE");
				continue;
			}
			for (int i = 0; i < size; i++) {
				square[i][i] = (int) Math.round(diagVal) - 1;
				if (i != 0) {
					columns[i][(int) Math.round(diagVal) - 1] = true;
				}
			}
			int currentTrace = (int) Math.round(diagVal) * size;
			square[0][0] += trace - currentTrace;
			columns[0][square[0][0]] = true;
			currentRow = new HashSet<>();
			for (int i = 0; i < size; i++) {
				currentRow.add(i);
			}
			if (solveLatinSquare(0, 0) == true) {
				System.out.println("Case #" + (counter + 1) + ": POSSIBLE");
				for (int i = 0; i < size; i++) {
					System.out.print(square[i][0] + 1);
					for (int j = 1; j < size; j++) {
						System.out.print(" " + (square[i][j] + 1));
					}
					System.out.println();
				}
			} else {
				System.out.println("Case #" + (counter + 1) + ": IMPOSSIBLE");
			}
		}
		bufread.close();
	}

	static boolean solveLatinSquare(int x, int y) {
		if (x == size - 1 && y == size - 1) {
			return true;
		}
		if (y == 0) {
			for (int i = 0; i < size; i++) {
				currentRow.add(i);
			}
			currentRow.remove(square[x][x]);
		}
		if (x == y) {
			return solveLatinSquare(x, y + 1);
		}
		int tx = x;
		int ty = y + 1;
		if (ty == size) {
			ty = 0;
			tx++;
		}
		for (int i = 0; i < size; i++) {
			if (columns[y][i] == false && currentRow.contains(i)) {
				columns[y][i] = true;
				currentRow.remove(i);
				square[x][y] = i;
				boolean solved = solveLatinSquare(tx, ty);
				if (solved == true) {
					return true;
				}
			}
			columns[y][i] = false;
			currentRow.add(i);
		}
		if (y == 0) {
			currentRow = new HashSet<>();
		}
		return false;
	}
}
