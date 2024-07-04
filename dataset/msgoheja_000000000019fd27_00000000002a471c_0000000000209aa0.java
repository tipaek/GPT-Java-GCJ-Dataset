import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution {
	static boolean isPossible;
	
	static int[][] solveMultiples(int[][] output, int N, int K) {
		int diagonalValues = K/N;
		for(int i = 0; i < N; i++) {
			output[i][i] = diagonalValues;
			int no = diagonalValues;
			for(int j = i+1; j < N; j++) {
				if(no >= N) {
					no = 1;
				} else {
					no++;
				}
				output[i][j] = no;
			}
			for(int k = 0; k < i; k++) {
				if(no >= N) {
					no = 1;
				} else {
					no++;
				}
				output[i][k] = no;
			}
		}
		return output;
	}
	
	static int[][] solve(int N, int K) {
		int[][] output = new int[N][N];
		if(K%N == 0) {
			output = solveMultiples(output, N, K);
			isPossible = true;
		} else {
			if(N == 3 || N == 2) {
				isPossible = false;
			} else if(N == 4 && (K == 5 || K == 15)) {
				isPossible = false;
			} else if(N == 5 && (K == 6 || K == 24)) {
				isPossible = false;
			} else {
				output = getHardCodedSolutions(N, K);
				isPossible = (output == null) ? false : true;
			}
		}
		return output;
	}
	
	static void printMatrix(int[][] matrix) {
		for(int[] i: matrix) {
			for(int j: i) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) throws Exception{
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int N, K;
		int[][] matrix;
		int T = in.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			N = in.nextInt();
			K = in.nextInt();
			
			isPossible = false;
			matrix = solve(N, K);
			
			String condition = isPossible ? "POSSIBLE" : "IMPOSSIBLE";
			System.out.println("Case #" + tc + ": " + condition);
			if(isPossible) {
				printMatrix(matrix);
			}
		}
		in.close();
	}

	static int[][] getHardCodedSolutions(int N, int K) {
		if(N == 4) {
			if(K == 6) {
				int[][] output = {{1,2,3,4},{2,1,4,3},{3,4,2,1},{4,3,1,2}};
				return output;
			} else if(K == 7) {
				int[][] output = {{1,2,3,4},{3,1,4,2},{4,3,2,1},{2,4,1,3}};
				return output;
			} else if(K == 9) {
				int[][] output = {{1,3,4,2},{4,2,1,3},{3,4,2,1},{2,1,3,4}};
				return output;
			} else if(K == 10) {
				int[][] output = {{3,2,1,4},{2,3,4,1},{4,1,2,3},{1,4,3,2}};
				return output;
			} else if(K == 11) {
				int[][] output = {{1,4,3,2},{4,2,1,3},{2,3,4,1},{3,1,2,4}};
				return output;
			} else if(K == 13) {
				int[][] output = {{2,4,1,3},{4,3,2,1},{3,1,4,2},{1,2,3,4}};
				return output;
			} else if(K == 14) {
				int[][] output = {{3,4,1,2},{4,3,2,1},{1,2,4,3},{2,1,3,4}};
				return output;
			}
		} else if(N == 5) {
			if(K == 7) {
				int[][] output = {{1,3,2,4,5},{2,1,5,3,4},{4,2,1,5,3},{5,4,3,2,1},{3,5,4,1,2}};
				return output;
			} else if(K == 8) {
				int[][] output = {{1,2,3,5,4},{2,1,5,4,3},{3,4,2,1,5},{5,3,4,2,1},{4,5,1,3,2}};
				return output;
			} else if(K == 9) {
				int[][] output = {{1,3,5,4,2},{2,1,3,5,4},{3,4,1,2,5},{4,5,2,3,1},{5,2,4,1,3}};
				return output;
			} else if(K == 11) {
				int[][] output = {{1,3,2,4,5},{3,1,4,5,2},{2,5,3,1,4},{4,2,5,3,1},{5,4,1,2,3}};
				return output;
			} else if(K == 12) {
				int[][] output = {{1,4,5,2,3},{3,1,2,4,5},{4,5,3,1,2},{5,2,4,3,1},{2,3,1,5,4}};
				return output;
			} else if(K == 13) {
				int[][] output = {{2,3,5,4,1},{4,2,3,1,5},{1,4,2,5,3},{5,1,4,3,2},{3,5,1,2,4}};
				return output;
			} else if(K == 14) {
				int[][] output = {{2,5,4,3,1},{4,2,3,1,5},{1,4,2,5,3},{3,1,5,4,2},{5,3,1,2,4}};
				return output;
			} else if(K == 16) {
				int[][] output = {{2,4,5,1,3},{4,2,1,3,5},{3,1,4,5,2},{5,3,2,4,1},{1,5,3,2,4}};
				return output;
			} else if(K == 17) {
				int[][] output = {{3,4,2,1,5},{1,3,4,5,2},{4,5,3,2,1},{2,1,5,4,3},{5,2,1,3,4}};
				return output;
			} else if(K == 18) {
				int[][] output = {{3,4,1,2,5},{4,3,5,1,2},{2,1,4,5,3},{5,2,3,4,1},{1,5,2,3,4}};
				return output;
			} else if(K == 19) {
				int[][] output = {{3,2,5,4,1},{5,3,4,1,2},{1,5,3,2,4},{2,4,1,5,3},{4,1,2,3,5}};
				return output;
			} else if(K == 21) {
				int[][] output = {{3,5,2,1,4},{1,4,5,3,2},{5,3,4,2,1},{4,2,1,5,3},{2,1,3,4,5}};
				return output;
			} else if(K == 22) {
				int[][] output = {{4,5,1,2,3},{3,4,5,1,2},{5,2,4,3,1},{1,3,2,5,4},{2,1,3,4,5}};
				return output;
			} else if(K == 23) {
				int[][] output = {{4,5,1,2,3},{5,4,2,3,1},{1,3,5,4,2},{2,1,3,5,4},{3,2,4,1,5}};
				return output;
			}
		}
		return null;
	}
}
