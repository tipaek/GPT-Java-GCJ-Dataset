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
				for(int i = 0; i < diff_permutation.size(); i++) {
					ArrayList<Integer> starting = diff_permutation.get(0);
					diff_permutation.remove(0);
					diff_permutation.add(starting);
					mat = obj.latinSquare(diff_permutation, n);
					int trace = 0;
					for(int j = 0; j< n; j++) {
						trace+=mat[j][j];
					}
					if(trace==k) {
						found = true;
						break;
					}
				}
				if(found) {
					System.out.println("Case #" + (t + 1) + ": " + "POSSIBLE");
					for(int i = 0; i < n; i++) {
						for (int j = 0; j< n; j++) {
							System.out.print(mat[i][j]+" ");
						}
						System.out.println();
					}
				}
				else
					System.out.println("Case #" + (t + 1) + ": " + "IMPOSSIBLE");
			}		

		} catch (

		Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public int[][] latinSquare(ArrayList<ArrayList<Integer>> permutations, int n) {
		int[][] matrix = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (ArrayList<Integer> l : permutations) {
				boolean flag = false;
				for (int j = 0; j < i; j++) {
					for (int p = 0; p < n; p++) {
						if (matrix[j][p] == l.get(p)) {
							flag = true;
							break;
						}
					}
				}
				if (!flag) {
					for (int p = 0; p < n; p++) {
						matrix[i][p] = l.get(p);
					}
				}
			}

		}		

		return matrix;
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