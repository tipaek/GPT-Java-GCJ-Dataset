import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

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
		String[] nk = reader.readLine().split(" ");
		int n = Integer.parseInt(nk[0]);
		int k = Integer.parseInt(nk[1]);
		int[] start = new int[n];
		for (int m = 0; m < n; m++) {
			start[m] = m + 1;
		}
		ArrayList<int[]> permutations = permute(start);

		int[][] solution = findSol(n, k, permutations);
		if (solution == null) {
			writer.write("Case #" + i + ": " + "IMPOSSIBLE" + "\r\n");
		} else {
			writer.write("Case #" + i + ": " + "POSSIBLE" + "\r\n");
			for (int row = 0; row < n; row++) {
				for (int col = 0; col < n; col++) {
					writer.write("" + solution[row][col]);
					if (col != n - 1) {
						writer.write(" ");
					}
				}
				writer.write("\r\n");
			}
		}
	}

	private static int trace(int[][] arr) {
		int trace = 0;
		for (int i = 0; i < arr.length; i++) {
			trace += arr[i][i];
		}
		return trace;
	}

	private static boolean colsLatin(int[][] arr) {
		for (int x = 0; x < arr.length; x++) {
			for (int y = 0; y < arr.length; y++) {
				for (int z = y + 1; z < arr.length; z++) {
					if (arr[y][x] == arr[z][x]) {
						return false;
					}
				}
			}
		}
		return true;
	}

	private static int[][] findSol(int n, int k, ArrayList<int[]> permutations) {
		int[][] arr = new int[n][n];
		return solve(arr, k, 1, permutations, n);
	}

	private static int[][] solve(int[][] arr, int k, int r,
			ArrayList<int[]> permutations, int n) {
		if (r == n + 1) {
			if ((trace(arr) == k) && colsLatin(arr)) {
				return arr;
			} else {
				return null;
			}
		}
		for (int x = 0; x < permutations.size(); x++) {
			arr[r - 1] = permutations.get(x);
			if (trace(arr) > k) {
				return null;
			}
			ArrayList<int[]> newPerm = (ArrayList<int[]>) permutations.clone();
			int[] alreadySet = newPerm.get(x);
			newPerm.remove(x);
			for (int idx = newPerm.size() - 1; idx >= 0; idx--) {
				for (int b = 0; b < alreadySet.length; b++) {
					if (newPerm.get(idx)[b] == alreadySet[b]) {
						newPerm.remove(idx);
						break;
					}
				}
			}

			int[][] possibleSol = solve(arr, k, r + 1, newPerm, n);
			if (possibleSol != null) {
				return possibleSol;
			}
		}

		return null;
	}

	private static ArrayList<int[]> permute(int[] arr) {
		ArrayList<int[]> basket = new ArrayList<int[]>();
		permute(arr, 0, arr.length - 1, basket);
		return basket;
	}

	private static void permute(int[] arr, int i, int n, ArrayList<int[]> basket) {
		if (i == n) {
			int[] result = arr.clone();
			basket.add(result);
		} else {
			for (int j = i; j <= n; j++) {
				swap(arr, i, j);
				permute(arr, i + 1, n, basket);
				swap(arr, i, j);
			}
		}
	}

	private static void swap(int[] input, int a, int b) {
		int tmp = input[a];
		input[a] = input[b];
		input[b] = tmp;
	}
}