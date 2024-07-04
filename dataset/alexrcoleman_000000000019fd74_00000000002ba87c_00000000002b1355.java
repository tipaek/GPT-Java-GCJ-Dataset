import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int t = 1; t <= T; t++) {
			int r = in.nextInt(), c = in.nextInt();
			ArrayList<Dancer> changed = new ArrayList();
			Dancer[][] grid = new Dancer[r][c];
			long skillSum = 0;
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					grid[i][j] = new Dancer(i, j, in.nextInt());
					changed.add(grid[i][j]);
					skillSum += grid[i][j].skill;
				}
			}

			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if (i != 0)
						grid[i][j].up = grid[i - 1][j];
					if (i != r - 1)
						grid[i][j].down = grid[i + 1][j];
					if (j != 0)
						grid[i][j].left = grid[i][j - 1];
					if (j != c - 1)
						grid[i][j].right = grid[i][j + 1];
				}
			}

			long ans = 0;
			while (true) {
				ans += skillSum;
				ArrayList<Dancer> kill = new ArrayList<>();

				ArrayList<Dancer> nextChanging = new ArrayList<>();
				for (Dancer d : changed) {
					Iterable<Dancer> adj = getAdj(d);
					if (!isOk(d, adj)) {
						kill.add(d);
						for (Dancer o : adj)
							nextChanging.add(o);
					}
				}

				if (kill.isEmpty())
					break;

				for (Dancer d : kill) {
					skillSum -= d.skill;
					if (d.left != null) {
						d.left.right = d.right;
					}
					if (d.right != null) {
						d.right.left = d.left;
					}
					if (d.up != null) {
						d.up.down = d.down;
					}
					if (d.down != null) {
						d.down.up = d.up;
					}
				}

				changed = nextChanging;
			}
			System.out.printf("Case #%d: %d\n", t, ans);
		}
	}

	static boolean isOk(Dancer d, Iterable<Dancer> adj) {
		long sum = 0;
		long me = 0;
		for (Dancer o : adj) {
			me += d.skill;
			sum += o.skill;
		}
		return me >= sum;
	}

	static Iterable<Dancer> getAdj(Dancer d) {
		return Arrays.stream(new Dancer[] { d.left, d.right, d.up, d.down }).filter(Objects::nonNull).collect(Collectors.toList());
	}

	static class Dancer {
		int row, col, skill;

		Dancer left, right, up, down;

		public Dancer(int row, int col, int skill) {
			this.row = row;
			this.col = col;
			this.skill = skill;
		}
	}
}
