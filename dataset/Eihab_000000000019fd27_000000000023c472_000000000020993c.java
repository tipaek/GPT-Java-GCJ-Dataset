import java.util.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br;
	static StringTokenizer sc;
	static PrintWriter out;

	public static void main(String[] args) throws IOException {
		//br = new BufferedReader(new FileReader("input.in"));
		br = new BufferedReader(new InputStreamReader(System.in));
		//out = new PrintWriter("output.out");
		out = new PrintWriter(System.out);
		sc = new StringTokenizer("");

		TaskD solver = new TaskD();
		solver.solve();

		br.close();
		out.close();
		//System.out.println("Finished");
	}

	static class TaskD {
		public void solve() throws IOException {
			int t = nxtInt();

			for (int ii = 0; ii < t; ii++) {
				int n = nxtInt();

				int[][] arr = new int[n][n];

				for (int i = 0; i < n; i++)
					for (int j = 0; j < n; j++)
						arr[i][j] = nxtInt();

				int sum = 0;

				for (int i = 0; i < n; i++)
					sum += arr[i][i];

				int repeatRow = 0;

				rows: for (int row = 0; row < n; row++) {
					for (int i = 0; i < n - 1; i++) {
						for (int j = i + 1; j < n; j++) {
							if (arr[row][i] == arr[row][j]) {
								repeatRow++;
								continue rows;
							}
						}
					}
				}

				int repeatCol = 0;

				cols: for (int col = 0; col < n; col++) {
					for (int i = 0; i < n - 1; i++) {
						for (int j = i + 1; j < n; j++) {
							if (arr[i][col] == arr[j][col]) {
								repeatCol++;
								continue cols;
							}
						}
					}
				}
				
				out.println("Case #" + (ii + 1) + ": " + sum + " " + repeatRow + " " + repeatCol);
			}
		}

		class Trie {
			Node root;

			Trie() {
				root = new Node();
			}

			void add(long x) {

				Node cur = root;
				// int depth = 0;
				while (x > 0) {
					int ls = (int) (x % 10);
					x /= 10;
					cur.cnt[ls]++;
					if (cur.nodes[ls] == null)
						cur.nodes[ls] = new Node();
					cur = cur.nodes[ls];
				}
			}

			void sub(long x) {

				Node cur = root;
				while (x > 0) {
					int ls = (int) (x % 10);
					x /= 10;
					cur.cnt[ls]--;
					cur = cur.nodes[ls];
				}
			}

			long[] getcnt(long x) {

				int res = 0;
				int prev = 0;
				int depth = 0;
				Node cur = root;

				while (x > 0 && depth < 10) {
					int ls = (int) (x % 10);
					x /= 10;
					res = cur.cnt[9 - ls];
					if (res != 0) {
						depth++;
						prev = res;
						cur = cur.nodes[9 - ls];
					} else
						break;
				}

				return new long[] { depth, prev };
			}

		}

		class Node {
			Node[] nodes;
			int[] cnt;

			Node() {
				nodes = new Node[10];
				cnt = new int[10];
			}

		}

	}

	static String nxtTok() throws IOException {
		while (!sc.hasMoreTokens()) {
			String s = br.readLine();

			if (s == null) {
				return null;
			}
			sc = new StringTokenizer(s.trim());
		}
		return sc.nextToken();
	}

	static int nxtInt() throws IOException {
		return Integer.parseInt(nxtTok());
	}

	static long nxtLng() throws IOException {
		return Long.parseLong(nxtTok());
	}

	static double nxtDbl() throws IOException {
		return Double.parseDouble(nxtTok());
	}

	static int[] nxtIntArr(int n) throws IOException {
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = nxtInt();
		}
		return a;
	}

	static long[] nxtLngArr(int n) throws IOException {
		long[] a = new long[n];
		for (int i = 0; i < n; i++) {
			a[i] = nxtLng();
		}
		return a;
	}

	static char[] nxtCharArr() throws IOException {
		return nxtTok().toCharArray();
	}

	static int getMin(int arr[], int count) {
		int min = arr[0];
		for (int i = 1; i < count; i++)
			if (arr[i] < min)
				min = arr[i];

		return min;
	}

	static int getMax(int arr[], int count) {
		int max = arr[0];
		for (int i = 1; i < count; i++)
			if (arr[i] > max)
				max = arr[i];

		return max;
	}

	static void sortAsc(int arr[], int count) {
		int temp;

		for (int i = 0; i < count - 1; i++) {
			for (int j = i + 1; j < count; j++) {
				if (arr[i] > arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}

	static void sortDesc(int arr[], int count) {
		int temp;

		for (int i = 0; i < count - 1; i++) {
			for (int j = i + 1; j < count; j++) {
				if (arr[i] < arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
}