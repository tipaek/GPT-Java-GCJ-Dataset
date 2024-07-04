import java.util.*;
import java.io.*;


class Solver {

	int matrix[][];
	int n;

	Solver(int matrix[][]) {
		this.matrix = matrix;
		this.n = matrix.length;
	}

	int getTrace() {
		int sum = 0;
		for(int i = 0; i < this.n; ++i) {
			sum += this.matrix[i][i];
		}
		return sum;
	}

	int getInvalidRows() {
		int invalid = 0;
		for(int row = 0; row < this.n; ++row) {
			boolean occured[] = new boolean[this.n];
			for(int col = 0; col < this.n; ++col) {
				int idx = this.matrix[row][col] - 1;
				if(occured[idx] == true){
					invalid++;
					break;
				}
				occured[idx] = true;
			}
		}
		return invalid;

	}

	int getInvalidCols() {
		int invalid = 0;
		for(int col = 0; col < this.n; ++col) {
			boolean occured[] = new boolean[this.n];
			for(int row = 0; row < this.n; ++row) {
				int idx = this.matrix[row][col] - 1;
				if(occured[idx] == true){
					invalid++;
					break;
				}
				occured[idx] = true;
			}
		}
		return invalid;
	}

}


class Vestigium {
	static BufferedReader br;
	static PrintWriter pw;

	public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		pw = new PrintWriter(System.out);
		int numTests = Integer.parseInt(br.readLine());
		for(int test = 1; test <= numTests; ++test) {
			Solver solver = new Solver(readMatrix());
			int trace = solver.getTrace();
			int invalidRows = solver.getInvalidRows();
			int invalidCols = solver.getInvalidCols();
			pw.printf("Case #%d: %d %d %d\n", test, trace, invalidRows, invalidCols);
		}
		pw.close();
	}

	public static int[][] readMatrix() throws IOException  {
		int n = Integer.parseInt(br.readLine());
		int mat[][] = new int[n][n];
		for(int row = 0; row < n; ++row) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int col = 0; col < n; ++col) {
				mat[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		return mat;
	}

}