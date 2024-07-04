package codejam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Solution {
	public static void main(String[] args) {
		try {
			BufferedReader reader =
	                 new BufferedReader(new InputStreamReader(System.in));
			int numOfTestCases = Integer.parseInt(reader.readLine(), 10);
			for (int i = 0; i < numOfTestCases; i++) {
				String[] line = reader.readLine().split(" ");
				int n = Integer.parseInt(line[0]);
				int k = Integer.parseInt(line[1]);
				solveSingleCase(i, n, k);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static class NaturalLatinSquare {
		int n;
		int[][] matrix;
		int trace = 0;
		boolean alreadyHasDup = false;
		boolean alreadyFilled = false;
		
		public NaturalLatinSquare(int n) {
			this.n = n;
			this.matrix = new int[n][n];
		}
		
		@Override
		public boolean equals(Object o) {
			if (o == this) return true;
			if (!(o instanceof NaturalLatinSquare)) {
	            return false;
	        }
			
			NaturalLatinSquare s = (NaturalLatinSquare) o;
			
			if (s.n != n) {
				return false;
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (s.matrix[i][j] != matrix[i][j]) {
						return false;
					}
				}
			}
			
			return true;
		}
		
		@Override
		public int hashCode() {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					sb.append(matrix[i][j]);
				}
			}
			return Objects.hash(n, sb.toString());
		}
		
		public boolean hasDuplicates() {
			if (alreadyHasDup) {
				return true;
			}
			
			for (int i = 0; i < n; i++) {
				boolean[] repeated = new boolean[n+1];
				for (int j = 0; j < n; j++) {
					int n = matrix[i][j];
					if (n == 0) {
						continue;
					}
					
					if(repeated[n]) {
						alreadyHasDup = true;
						return true;
					} else {
						repeated[n] = true;
					}
				}
			}
			
			for (int i = 0; i < n; i++) {
				boolean[] repeated = new boolean[n+1];
				for (int j = 0; j < n; j++) {
					int n = matrix[j][i];
					if (n == 0) {
						continue;
					}
					
					if (repeated[n]) {
						alreadyHasDup = true;
						return true;
					} else {
						repeated[n] = true;
					}
				}
			}
			return false;
		}
		
		public int getTrace() {
			if (hasDuplicates()) {
				return 0;
			}
			
			if (trace != 0) {
				return trace;
			}
			
			for (int i = 0; i < n; i++) {
				trace += matrix[i][i];
			}
			
			return trace;
		}
		
		public boolean isFilled() {
			if (alreadyFilled) {
				return true;
			}
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (matrix[i][j] == 0) {
						return false;
					}
				}
			}
			alreadyFilled = true;
			return true;
		}
		
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (j < n-1) {
						sb.append(matrix[i][j] + " ");
					} else {
						sb.append(matrix[i][j]);
					}
				}
				if (i < n-1) {
					sb.append("\n");
				}
			}
			return sb.toString();
		}
	}
	
	public static int[] checkDuplicates(int[][] matrix) {
		int trace = 0;
		int l = matrix.length;
		for (int i = 0; i < l; i++) {
			trace += matrix[i][i];
		}
		
		int numOfRepeatedRow = 0;
		for (int i = 0; i < l; i++) {
			boolean[] repeated = new boolean[l+1];
			for (int j = 0; j < l; j++) {
				int n = matrix[i][j];
				if (repeated[n]) {
					numOfRepeatedRow++;
					break;
				} else {
					repeated[n] = true;
				}
			}
		}
		
		int numOfRepeatedCol = 0;
		for (int i = 0; i < l; i++) {
			boolean[] repeated = new boolean[l+1];
			for (int j = 0; j < l; j++) {
				int n = matrix[j][i];
				if (repeated[n]) {
					numOfRepeatedCol++;
					break;
				} else {
					repeated[n] = true;
				}
			}
		}
		
		return new int[] {trace, numOfRepeatedRow, numOfRepeatedCol};
	}
	
	public static void solveSingleCase(int c, int n, int k) {
		NaturalLatinSquare[][][] possibilities = new NaturalLatinSquare[n][n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int x = 0; x < n; x++) {
					if (possibilities[i][j][x] == null) {
						possibilities[i][j][x] = new NaturalLatinSquare(n);
					}
					
					NaturalLatinSquare cur = possibilities[i][j][x];
					if (cur.hasDuplicates()) {
						continue;
					}

					for (int ro = 0; ro < n; ro++) {
						for (int co = 0; co < n; co++) {
							cur.matrix[(i+ro)%n][(j+co)%n] = ((x + ro + co) % n) + 1;
						}
					}
				}
			}			
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int x = 0; x < n; x++) {
					NaturalLatinSquare cur = possibilities[i][j][x];
					if (cur.hasDuplicates()) {
						continue;
					}

					if (!cur.isFilled()) {
						continue;
					}
					
					if (cur.getTrace() == k) {
						System.out.println("Case #"+(c+1)+": POSSIBLE");
						System.out.print(cur.toString());
						return;
					}
				}
			}			
		}

		System.out.println("Case #"+(c+1)+": IMPOSSIBLE");
	}
}
