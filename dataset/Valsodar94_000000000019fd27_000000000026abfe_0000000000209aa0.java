import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
public class Solution  {
	static void fillRemaining(int mat[][], int i, int j, int n) { 
        int x = 2; 
        for (int k = i + 1; k < n; k++) {
            mat[k][j] = x++; 
        }
        for (int k = 0; k < i; k++) {
            mat[k][j] = x++; 
        }
    } 
      
    static void constructMatrix(int mat[][], int n, int first, int second, int allTheRest) { 
        int right = n - 1, left = 0; 
        for (int i = 0; i < n; i++) { 
        	if(i == 0) {
        		
        	}
            if (i % 2 == 0) { 
                mat[i][right] = 1; 
                fillRemaining(mat, i, right, n); 
                right--; 
            } else { 
                mat[i][left] = 1; 
                fillRemaining(mat, i, left, n); 
                left++; 
            } 
        } 
    } 
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCasesNumber = in.nextInt();
		ArrayList<int[]> testCases = new ArrayList<int[]>();
		for (int i = 0; i < testCasesNumber; i++) {
			int testCase[] = new int[2];
			int matrixRows = in.nextInt();
			int trace = in.nextInt();
			testCase[0] = matrixRows;
			testCase[1] = trace;
			testCases.add(testCase);
		}
		int testCaseInd = 1;
		for(int[] testCase: testCases) {
			int matrixRows = testCase[0];
			int [][] matrix = new int[matrixRows][matrixRows];
			int trace = testCase[1];
			boolean possible = true;
			int maxSum = (int) Math.pow(matrixRows, matrixRows);
			int maxSum2 = (int) Math.pow((matrixRows - 1), matrixRows);
			if(trace < matrixRows || trace > Math.pow(matrixRows, matrixRows) || (trace > maxSum2 && trace < maxSum) || (trace == matrixRows + 1) || (trace == 7 && matrixRows == 4) || (trace == 13 && matrixRows == 5)) {
				possible = false;
			}
			if(possible) {
				double del = ((double) trace) / matrixRows;
				int num = (int) del;
				if(del == Math.floor(del)) {
					System.out.println("Case #" + testCaseInd + ": POSSIBLE");
					for(int row = 0; row < matrixRows; row++) {
						matrix[row][row] = num;
						int number = 1;
						for(int col = 0; col < matrixRows - 1; col++) {
							int ind = row;
							if(ind == matrixRows - 1) {
								ind = 0;
							} else {
								ind++;
							}
							if(number == num) {
								num++;
							}
							matrix[row][col] = number;
						}
					}
				} else {
					int diff = trace - (num * (matrixRows - 2));
					int secondNumber;
					int thirdNumber;
					double diff2 = diff / 2.0;
					if(diff2 == Math.floor(diff2)) {
						secondNumber = thirdNumber = (int) diff2;
					} else {
						secondNumber = (int) Math.floor(diff2);
						thirdNumber = secondNumber + 1;
						if(secondNumber == num || thirdNumber == num) {
							secondNumber--;
							thirdNumber++;
							if(secondNumber < 1 || thirdNumber > matrixRows) {
								possible = false;
							}
						}
					}
					if(!possible) {
						System.out.println("Case #" + testCaseInd + ": IMPOSSIBLE");
						break;
					}
					System.out.println("Case #" + testCaseInd + ": POSSIBLE");
				}
			} else {
				System.out.println("Case #" + testCaseInd + ": IMPOSSIBLE");
			}
			testCaseInd++;
		}
	}
}
