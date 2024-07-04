

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

public class Solution {

	static HashMap<Integer, String> output = new HashMap<Integer, String>();

	public static void main(String[] args) {
		int T, N;
		int mat[][], matTranspose[][];
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			T = Integer.valueOf(br.readLine().trim());
			for (int t = 0; t < T; t++) {
				N = Integer.valueOf(br.readLine().trim());
				mat = new int[N][N];
				matTranspose = new int[N][N];

				int trace = 0;
				for (int i = 0; i < N; i++) {
					String[] colVals = br.readLine().split("\\s+");
					for (int j = 0; j < N; j++) {
						mat[i][j] = Integer.valueOf(colVals[j]);
						matTranspose[j][i] = mat[i][j];
						if (i == j)
							trace += mat[i][j];
					}
				}
				Solver solver = new Solver(mat, matTranspose, trace, t);
				new Thread(solver).start();
			}
			br.close();
			// wait for process
			while (output.size() != T) {

			}
			// output
			for (int i = 0; i < T; i++) {
				System.out.println("Case #" + (i + 1) + ": " + output.get(i));
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}

	static class Solver implements Runnable {
		int i;
		int[][] n;
		int[][] nTransposed;
		int trace = 0;

		public Solver(int[][] N, int[][] nTranspose, int dia, int index) {
			i = index;
			n = N;
			nTransposed = nTranspose;
			trace = dia;

		}

		@Override
		public void run() {
			output.put(i, solve(n, nTransposed, trace));
		}

		String solve(int[][] mat, int[][] matTransposed, int trace) {
			int repeatRowsCounter = 0;
			int repeatColsCounter = 0;
			HashMap<Integer, HashSet<Integer>> val_setRepeatRows;
			HashMap<Integer, HashSet<Integer>> val_setRepeatCols;

			val_setRepeatRows = new HashMap<Integer, HashSet<Integer>>();
			val_setRepeatCols = new HashMap<Integer, HashSet<Integer>>();

			for (int i = 0; i < mat.length; i++) {
				if (repeatRowsCounter < mat.length) {
					DuplicationSearchResult duplicationSearchResult = findDuplicates(mat[i],
							new DuplicationSearchResult(val_setRepeatRows, repeatRowsCounter));
					val_setRepeatRows = duplicationSearchResult.getVal_setRepeat();
					repeatRowsCounter = duplicationSearchResult.repeatCounter;
				}
				
				if (repeatColsCounter < matTransposed.length) {
					DuplicationSearchResult duplicationSearchResult = findDuplicates(matTransposed[i],
							new DuplicationSearchResult(val_setRepeatCols, repeatColsCounter));
					val_setRepeatCols = duplicationSearchResult.getVal_setRepeat();
					repeatColsCounter = duplicationSearchResult.repeatCounter;
				}

				if (repeatRowsCounter == mat.length && repeatColsCounter == matTransposed.length)
					return trace + " " + repeatRowsCounter + " " + repeatColsCounter;
			}
			return trace + " " + repeatRowsCounter + " " + repeatColsCounter;
		}

		DuplicationSearchResult findDuplicates(int[] arr, DuplicationSearchResult obj) {
			int maxDuplicationsFound = obj.getRepeatCounter();
			HashMap<Integer, HashSet<Integer>> repeatSet = obj.getVal_setRepeat();
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < i; j++) {
					if (arr[i] == arr[j]) {

						HashSet<Integer> repeatIndexes = repeatSet.get(arr[i]);
						if (repeatIndexes == null) {
							repeatIndexes = new HashSet<Integer>();
						}
						repeatIndexes.add(i);
						repeatIndexes.add(j);
						if (repeatIndexes.size() > maxDuplicationsFound) {
							maxDuplicationsFound = repeatIndexes.size();
						}
						repeatSet.put(arr[i], new HashSet<Integer>(repeatIndexes));
					}

				}
			}

			return new DuplicationSearchResult(repeatSet, maxDuplicationsFound);
		}

		class DuplicationSearchResult {
			HashMap<Integer, HashSet<Integer>> val_setRepeat;
			int repeatCounter;

			public DuplicationSearchResult(HashMap<Integer, HashSet<Integer>> val_setRepeat, int repeatCounter) {
				super();
				this.val_setRepeat = val_setRepeat;
				this.repeatCounter = repeatCounter;
			}

			public HashMap<Integer, HashSet<Integer>> getVal_setRepeat() {
				return val_setRepeat;
			}

			public void setVal_setRepeat(HashMap<Integer, HashSet<Integer>> val_setRepeat) {
				this.val_setRepeat = val_setRepeat;
			}

			public int getRepeatCounter() {
				return repeatCounter;
			}

			public void setRepeatCounter(Integer repeatCounter) {
				this.repeatCounter = repeatCounter;
			}

		}
	}

}
