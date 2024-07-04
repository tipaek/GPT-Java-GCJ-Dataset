import java.util.*;

class Node {
	int val;
	Node left;
	Node right;
	Node top;
	Node bot;
	boolean isEliminated = false;

	Node(int val) {

	}
}

public class Solution {
	private static Node[] createGrid(int m, int n) {
		Node[] row = new Node[m];

		for (int i = 0; i < m; ++i) {
			row[i] = new Node(0);
			Node p = row[i];
			for (int j = 1; j < n; ++j) {
				Node newNode = new Node(0);
				p.right = newNode;
				newNode.left = p;
				p = newNode;
			}
		}

		Node[] p = new Node[m];
		for (int i = 0; i < m; ++i)
			p[i] = row[i];

		for (int j = 0; j < n; ++j) {
			for (int i = 1; i < m; ++i) {
				int tmp = i - 1;
				p[tmp].bot = p[i];
				p[i].top = p[tmp];
				p[tmp] = p[tmp].right;
			}
			p[m - 1] = p[m - 1].right;
		}

		return row;
	}

	private static void eliminate(Node[] row, Node p, int i) {
		if (p == row[i]) {
			row[i] = p.right;
		}

		if (p.left != null) {
			p.left.right = p.right;
		}
		if (p.right != null) {
			p.right.left = p.left;
		}
		if (p.top != null) {
			p.top.bot = p.bot;
		}
		if (p.bot != null) {
			p.bot.top = p.top;
		}

		p.left = null;
		p.right = null;
		p.top = null;
		p.bot = null;
	}

	private static long process(Node[] row, int m, int n, long sum) {
		long res = 0;

		boolean hasEliminated;
		do {
			hasEliminated = false;
			for (int i = 0; i < m; ++i) {
				Node p = row[i];
				while (p != null) {
					int avg = 0, count = 0;

					if (p.left != null) {
						avg += p.left.val;
						++count;
					}
					if (p.right != null) {
						avg += p.right.val;
						++count;
					}
					if (p.top != null) {
						avg += p.top.val;
						++count;
					}
					if (p.bot != null) {
						avg += p.bot.val;
						++count;
					}

					if (p.val * count < avg) {
						p.isEliminated = true;
						hasEliminated = true;
					}

					p = p.right;
				}
			}

			long sumEliminated = 0;
			if (hasEliminated)
				for (int i = 0; i < m; ++i) {
					Node p = row[i];
					while (p != null) {
						if (p.isEliminated) {
							sumEliminated += p.val;
							Node tmp = p.right;
							eliminate(row, p, i);
							p = tmp;
						} else {
							p = p.right;
						}
					}
				}

			res += sum;
			sum -= sumEliminated;
		} while (hasEliminated == true);

		return res;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt(), tmp;
		for (int k = 1; k <= t; ++k) {
			int m = scanner.nextInt();
			int n = scanner.nextInt();

			Node[] row = createGrid(m, n);

			long sum = 0;
			for (int i = 0; i < m; ++i) {
				Node p = row[i];
				for (int j = 0; j < n; ++j) {
					tmp = scanner.nextInt();
					sum += tmp;
					p.val = tmp;
					p = p.right;
				}
			}

			System.out.println("Case #" + k + ": " + process(row, m, n, sum));
		}
		scanner.close();
	}
}