
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Google Code Jam 2020 Round 1A
 */
public class Solution {

	private static class Node {

		int value;
		Node left, right, top, bottom;

		Node(int value) {
			this.value = value;
		}

		public void eliminate() {
			if (this.left != null) {
				this.left.right = this.right;
			}
			if (this.right != null) {
				this.right.left = this.left;
			}
			if (this.top != null) {
				this.top.bottom = this.bottom;
			}
			if (this.bottom != null) {
				this.bottom.top = this.top;
			}
			this.value = 0;
			this.left = null;
			this.right = null;
			this.top = null;
			this.bottom = null;
		}

		public boolean shouldBeEliminated() {
			if (this.value == 0) {
				return false;
			}
			int count = 0;
			int sum = 0;
			if (this.left != null) {
				count++;
				sum += this.left.value;
			}
			if (this.right != null) {
				count++;
				sum += this.right.value;
			}
			if (this.top != null) {
				count++;
				sum += this.top.value;
			}
			if (this.bottom != null) {
				count++;
				sum += this.bottom.value;
			}

			return this.value * count < sum;
		}
	}

	final int numRows;
	final int numCols;

	final Node[][] nodes;

	public Solution(Scanner scanner) {
		this.numRows = scanner.nextInt();
		this.numCols = scanner.nextInt();

		this.nodes = new Node[this.numRows][this.numCols];
		for (int i = 0; i < this.numRows; i++) {
			for (int j = 0; j < this.numCols; j++) {
				this.nodes[i][j] = new Node(scanner.nextInt());
			}
		}

		for (int i = 0; i < this.numRows; i++) {
			for (int j = 0; j < this.numCols; j++) {
				if (i > 0) {
					this.nodes[i][j].top = this.nodes[i - 1][j];
				}
				if (i < this.numRows - 1) {
					this.nodes[i][j].bottom = this.nodes[i + 1][j];
				}
				if (j > 0) {
					this.nodes[i][j].left = this.nodes[i][j - 1];
				}
				if (j < this.numCols - 1) {
					this.nodes[i][j].right = this.nodes[i][j + 1];
				}
			}
		}
	}

	private long getCurrentSum() {
		long sum = 0;
		for (int i = 0; i < this.numRows; i++) {
			for (int j = 0; j < this.numCols; j++) {
				sum += this.nodes[i][j].value;
			}
		}
		return sum;
	}

	private boolean doElimination() {
		List<Node> toEliminate = new LinkedList<>();
		for (int i = 0; i < this.numRows; i++) {
			for (int j = 0; j < this.numCols; j++) {
				Node node = this.nodes[i][j];
				if (node.shouldBeEliminated()) {
					toEliminate.add(node);
				}
			}
		}

		if (toEliminate.isEmpty()) {
			return false;
		}

		for (Node node : toEliminate) {
			node.eliminate();
		}
		return true;
	}

	public String solve() {
		long sum = 0;
		do {
			sum += this.getCurrentSum();
		} while (this.doElimination());

		return Long.toString(sum);
	}

	public static void main(String args[]) {
		try (Scanner scanner = new Scanner(System.in);) {
			int T = scanner.nextInt();
			for (int i = 1; i <= T; i++) {
				String solution = new Solution(scanner).solve();
				System.out.println("Case #" + i + ": " + solution);
			}
		}
		System.exit(0);
	}

}
