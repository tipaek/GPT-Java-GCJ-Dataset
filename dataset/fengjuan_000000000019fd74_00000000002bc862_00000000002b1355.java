import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			int R = in.nextInt(), C = in.nextInt();
			Node[][] S = new Node[R][C];
			ArrayList<Node> set = new ArrayList<>();
			long sum = 0, result = 0;
			for (int j = 0; j < R; j++) {
				for (int k = 0; k < C; k++) {
					int s = in.nextInt();
					sum += s;
					set.add(S[j][k] = new Node(j, k, s));
				}
			}
			for (int j = 0; j < R; j++) {
				for (int k = 0; k < C; k++) {
					if (j != 0) {
						S[j][k].up = S[j - 1][k];
					}
					if (k != 0) {
						S[j][k].left = S[j][k - 1];
					}
					if (k != C - 1) {
						S[j][k].right = S[j][k + 1];
					}
					if (j != R - 1) {
						S[j][k].down = S[j + 1][k];
					}
				}
			}
			while (!set.isEmpty()) {
				result += sum;
				ArrayList<Node> elimited = new ArrayList<>();
				for (Node a : set) {
					if (S[a.i][a.j] != null) {
						double count = 0;
						long curr = 0;
						if (a.up != null) {
							count++;
							curr += a.up.val;
						}
						if (a.left != null) {
							count++;
							curr += a.left.val;
						}
						if (a.right != null) {
							count++;
							curr += a.right.val;
						}
						if (a.down != null) {
							count++;
							curr += a.down.val;
						}
						if (curr / count > a.val) {
							elimited.add(a);
							sum -= a.val;
							S[a.i][a.j] = null;
						}
					}
				}
				set.clear();
				for (Node a : elimited) {
					if (a.up != null) {
						set.add(a.up);
						a.up.down = a.down;
					}
					if (a.left != null) {
						set.add(a.left);
						a.left.right = a.right;
					}
					if (a.right != null) {
						set.add(a.right);
						a.right.left = a.left;
					}
					if (a.down != null) {
						set.add(a.down);
						a.down.up = a.up;
					}
				}
			}
			System.out.println("Case #" + i + ": " + result);
		}
	}

	private static class Node {
		private Node up, left, right, down;
		private int i, j, val;

		private Node(int i, int j, int val) {
			this.i = i;
			this.j = j;
			this.val = val;
		}
	}
}