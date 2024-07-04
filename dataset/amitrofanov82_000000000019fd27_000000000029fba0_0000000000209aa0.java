import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		Scanner sc = null;
		if (System.getProperties().getProperty("user.name").equals("Alexey")) {
			sc = new Scanner(new FileInputStream("input.txt"));;
			System.err.println("development mode, reading from file");
		} else {
			sc = new Scanner((System.in));
		}

		int testCases = Integer.parseInt(sc.nextLine());
		for (int i = 1; i < testCases + 1; i++) {
			String[] nk = sc.nextLine().split(" ");
			String result = readAndresolveSingleCase(Integer.parseInt(nk[0]), Integer.parseInt(nk[1]));
			System.out.println("Case #" + i + ": " + result);
			System.out.flush();
		}
		sc.close();
	}

	private static String readAndresolveSingleCase(int N, int K) {
		StringBuilder result = new StringBuilder();
		int[][] matrix = new int[N][N];
		initMinimalMatrix(matrix);
		printMatrix(matrix);
		int lastDSumm = getDiagSum(matrix);
		while (lastDSumm < K) {
			int minIncrement = N*N+N;
			int swap1 = 0, swap2 = 0;
			boolean swapcolumns = false;
			boolean swapvalues = false;
			for (int i = 0; i < N-1; i++) {
				for (int j = i+1; j < N; j++) {
					int increment = sumIncrementAfterRowSwap(matrix, i, j);
					if (increment>0 && increment < minIncrement) {
						minIncrement = increment;
						swap1 = i;
						swap2= j;
						swapcolumns = false;
					}
					increment = sumIncrementAfterColSwap(matrix, i, j);
					if (increment>0 && increment < minIncrement) {
						minIncrement = increment;
						swap1 = i;
						swap2= j;
						swapcolumns = true;
					}
				}
			}
			
			swapvalues = false;
			for (int i = 1; i <= N-1; i++) {
				for (int j = i+1; j <= N; j++) {
					int increment = sumIncrementAfterValSwap(matrix, i, j);
					if (increment>0 && increment < minIncrement) {
						minIncrement = increment;
						swap1 = i;
						swap2= j;
						swapvalues = true;
					}
				}
			}
			
			if (minIncrement == N*N+N){
				break;
			}
			//System.out.println("sum before swap " + lastDSumm);
			if (!swapcolumns && !swapvalues) {
				//System.out.println("Swapping rows " + swap1 + " with " + swap2 + "for " + minIncrement);
				swaprows(matrix, swap1, swap2);
			} else if (swapcolumns && !swapvalues) {
				//System.out.println("Swapping columns " + swap1 + " with " + swap2 + "for " + minIncrement);
				swapcols(matrix, swap1, swap2);
			} else if (swapvalues) {
				//System.out.println("Swapping values " + swap1 + " with " + swap2 + "for " + minIncrement);
				swapvals(matrix, swap1, swap2);
			}
			printMatrix(matrix);
			//System.out.println("sum after swap " + getDiagSum(matrix));
			//System.out.println("------------");
			lastDSumm = getDiagSum(matrix);
		}
		
		if (lastDSumm == K) {
			result.append("POSSIBLE" + System.lineSeparator());
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[i].length; j++) {
					result.append(matrix[i][j] + (j == matrix.length -1 ? "" : " "));
				}
				if (i!=matrix.length-1)result.append(System.lineSeparator());
			}
			
		} else if (lastDSumm > K) {
			result.append("IMPOSSIBLE");
		} else {
			//should be impossible case
			result.append("IMPOSSIBLE");
		}
		
		//ATTEMPT 2
		if (result.toString().equals("IMPOSSIBLE")) {
			result = new StringBuilder();
			initMinimalMatrix(matrix);
			lastDSumm = getDiagSum(matrix);
			while (lastDSumm < K) {
				int minIncrement = N*N+N;
				int swap1 = 0, swap2 = 0;
				boolean swapcolumns = false;
				for (int i = 0; i < N-1; i++) {
					for (int j = i+1; j < N; j++) {
						int increment = sumIncrementAfterRowSwap(matrix, i, j);
						if (increment>0 && increment <= minIncrement) {
							minIncrement = increment;
							swap1 = i;
							swap2= j;
							swapcolumns = false;
						}
					}
				}
				
				if (minIncrement == N*N+N){
					break;
				}
				//System.out.println("sum before swap " + lastDSumm);
				if (!swapcolumns) {
					//System.out.println("Swapping rows " + swap1 + " with " + swap2 + "for " + minIncrement);
					swaprows(matrix, swap1, swap2);
				} else if (swapcolumns) {
					//System.out.println("Swapping columns " + swap1 + " with " + swap2 + "for " + minIncrement);
					swapcols(matrix, swap1, swap2);
				}
				printMatrix(matrix);
				//System.out.println("sum after swap " + getDiagSum(matrix));
				//System.out.println("------------");
				lastDSumm = getDiagSum(matrix);
			}
			
			if (lastDSumm == K) {
				result.append("POSSIBLE" + System.lineSeparator());
				for (int i = 0; i < matrix.length; i++) {
					for (int j = 0; j < matrix[i].length; j++) {
						result.append(matrix[i][j] + (j == matrix.length -1 ? "" : " "));
					}
					if (i!=matrix.length-1)result.append(System.lineSeparator());
				}
				
			} else if (lastDSumm > K) {
				result.append("IMPOSSIBLE");
			} else {
				//should be impossible case
				result.append("IMPOSSIBLE");
			}
		}
		
		return result.toString();
	}
	
	private static void swapvals(int[][] matrix, int swap1, int swap2) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if (matrix[i][j] == swap1){
					matrix[i][j] = swap2;
				} else if (matrix[i][j] == swap2) {
					matrix[i][j] = swap1;
				}
			}
		}
	}

	private static int sumIncrementAfterValSwap(int[][] matrix, int val1, int val2) {
		int sum1 = getDiagSum(matrix);
				
		int sum2 = 0;
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][i] == val1) {
				sum2+= val2;
			} else if (matrix[i][i] == val2) {
				sum2+= val1;
			} else {
				sum2+= matrix[i][i];
			}
			
		}
		return sum2-sum1;		
	}

	private static void swapcols(int[][] matrix, int swap1, int swap2) {
		int N = matrix.length;
		int[] temp = new int[N];
		for (int i = 0; i < temp.length; i++) {
			temp[i] = matrix[i][swap1];
		}
		for (int i = 0; i < temp.length; i++) {
			matrix[i][swap1] = matrix[i][swap2];
		}
		for (int i = 0; i < temp.length; i++) {
			matrix[i][swap2] = temp[i];
		}
	}

	private static void swaprows(int[][] matrix, int minr1, int minr2) {
		int[] temp = matrix[minr1];
		matrix[minr1] = matrix[minr2];
		matrix[minr2] = temp;
	}

	private static int getDiagSum(int[][] matrix) {
		int result = 0;
		for (int i = 0; i < matrix.length; i++) {
			result+= matrix[i][i];
		}
		return result;
	}

	private static int sumIncrementAfterRowSwap(int[][] matrix, int row1, int row2) {
		int oldr1d = matrix[row1][row1];
		int oldr2d = matrix[row2][row2];
		int newr1d = matrix[row2][row1];
		int newr2d = matrix[row1][row2];
		
		return (newr1d + newr2d) - (oldr1d + oldr2d);
	}
	
	private static int sumIncrementAfterColSwap(int[][] matrix, int col1, int col2) {
		int oldc1d = matrix[col1][col1];
		int oldc2d = matrix[col2][col2];
		int newc1d = matrix[col1][col2];
		int newc2d = matrix[col2][col1];
		
		return (newc1d + newc2d) - (oldc1d + oldc2d);
	}
	
	private static void initMinimalMatrix(int[][] matrix) {
		int N = matrix.length;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][N-1 - j] = N - ((j+i) % N);
			}
		}

	}
	
	private static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
		System.out.println("------------------");
	}

}



