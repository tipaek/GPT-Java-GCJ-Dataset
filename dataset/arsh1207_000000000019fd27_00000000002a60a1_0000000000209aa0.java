
import java.io.*;
import java.util.*;

class Solution {

	public static void main(String args[]) {
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);

			int test = Integer.parseInt(br.readLine());
			for (int t = 0; t < test; t++) {
				String line = br.readLine();
				int n = Integer.parseInt(line.split(" ")[0]);
				int k = Integer.parseInt(line.split(" ")[1]);
				int mat[][] = new int[n][n];
				int arr[] = new int[n];
				for (int i = 0; i < n; i++) {
					arr[i] = i + 1;
				}
				Boolean found = false;
				Solution obj = new Solution();
				ArrayList<ArrayList<Integer>> diff_permutation = obj.permute(arr);

				ArrayList<ArrayList<Integer>> data = new ArrayList<ArrayList<Integer>>();
				ArrayList<ArrayList<ArrayList<Integer>>> result = new ArrayList<ArrayList<ArrayList<Integer>>>();
				ArrayList<ArrayList<ArrayList<Integer>>> combi = obj.combinationUtil(diff_permutation,
						diff_permutation.size(), n, 0, data, 0, result);

				for (ArrayList<ArrayList<Integer>> combination : result) {
					int[][] matrix = new int[n][n];
					// mat = obj.latinSquare(combination, n);
					for (int i = 0; i < n; i++) {
						for (int j = 0; j < n; j++) {
							matrix[i][j] = combination.get(i).get(j);
						}
					}
					Boolean flag = obj.latinSquare(matrix, n);
					if (!flag) {
						int trace = 0;
						for (int p = 0; p < n; p++) {
							trace += matrix[p][p];
						}
						if (trace == k) {
							mat = matrix;
							found = true;
							break;
						}
					}
				}

				if (found) {
					System.out.println("Case #" + (t + 1) + ": " + "POSSIBLE");
					for (int i = 0; i < n; i++) {
						for (int j = 0; j < n; j++) {
							System.out.print(mat[i][j] + " ");
						}
						System.out.println();
					}
				} else
					System.out.println("Case #" + (t + 1) + ": " + "IMPOSSIBLE");
			}

		} catch (

		Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public ArrayList<ArrayList<ArrayList<Integer>>> combinationUtil(ArrayList<ArrayList<Integer>> arr, int n, int r,
			int index, ArrayList<ArrayList<Integer>> data, int i, ArrayList<ArrayList<ArrayList<Integer>>> result) {

		if (index == r) {
			ArrayList<ArrayList<Integer>> result2 = new ArrayList<ArrayList<Integer>>();
			for (int j = 0; j < r; j++)
				result2.add(data.get(j));
			// System.out.print(data.get(j) + " ");
			// System.out.println("");
			result.add(result2);
			return result;
		}

		if (i >= n)
			return result;

		data.add(index, arr.get(i));
		combinationUtil(arr, n, r, index + 1, data, i + 1, result);
		combinationUtil(arr, n, r, index, data, i + 1, result);
		return null;
	}

	public Boolean latinSquare(int[][] matrix, int n) {
		// int[][] matrix = new int[n][n];
		boolean flag = false;
		for (int i = 0; i < n; i++) {
			int k = 0;
			int value = matrix[i][k];
			for (int j = 0; j < n; j++) {
				if (matrix[j][i] == value) {
					flag = true;
				}
			}
		}

		return flag;

	}

	public ArrayList<ArrayList<Integer>> permute(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		result.add(new ArrayList<Integer>());

		for (int i = 0; i < num.length; i++) {
			ArrayList<ArrayList<Integer>> current = new ArrayList<ArrayList<Integer>>();

			for (ArrayList<Integer> l : result) {
				for (int j = 0; j < l.size() + 1; j++) {
					l.add(j, num[i]);

					ArrayList<Integer> temp = new ArrayList<Integer>(l);
					current.add(temp);

					// System.out.println(temp);
					l.remove(j);
				}
			}
			result = new ArrayList<ArrayList<Integer>>(current);
		}

		return result;
	}
}