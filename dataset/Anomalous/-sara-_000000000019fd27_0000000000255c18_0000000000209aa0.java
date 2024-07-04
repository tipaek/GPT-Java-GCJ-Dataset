import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int k = in.nextInt();
            int[][] matrix = new int[n][n];
            
            if (k % n == 0) {
                fillMatrixForDivisibleCase(matrix, n, k);
                printResult(i, "POSSIBLE", matrix);
            } else if (isImpossibleCase(n, k)) {
                printResult(i, "IMPOSSIBLE", null);
            } else {
                if (solveCase(matrix, n, k)) {
                    printResult(i, "POSSIBLE", matrix);
                } else {
                    printResult(i, "IMPOSSIBLE", null);
                }
            }
        }
        
        in.close();
    }
    
    private static void fillMatrixForDivisibleCase(int[][] matrix, int n, int k) {
        int diagonalElement = k / n;
        for (int j = 0; j < n; j++) {
            matrix[j][j] = diagonalElement;
            for (int m = 1; m < n; m++) {
                matrix[j][(m + j) % n] = (diagonalElement - 1 + m) % n + 1;
            }
        }
    }
    
    private static boolean isImpossibleCase(int n, int k) {
        return k == Math.pow(n, 2) - 1 || k == n + 1 || (n == 3 && (k == 5 || k == 7));
    }
    
    private static boolean solveCase(int[][] matrix, int n, int k) {
        for (int j = 1; j <= n; j++) {
            int remainder = k - (n - 2) * j;
            if (isValidRemainder(remainder, n, j)) {
                fillMatrixForValidRemainder(matrix, n, j, remainder);
                return true;
            }
        }
        
        for (int j = 1; j <= n; j++) {
            int remainder = k - (n - 2) * j;
            if (isValidRemainderForAlternative(matrix, n, j, remainder)) {
                fillMatrixForAlternativeRemainder(matrix, n, j, remainder);
                return true;
            }
        }
        
        return false;
    }
    
    private static boolean isValidRemainder(int remainder, int n, int j) {
        return remainder % 2 == 0 && remainder < 2 * n && remainder / 2 != j;
    }
    
    private static void fillMatrixForValidRemainder(int[][] matrix, int n, int j, int remainder) {
        for (int m = 0; m < n - 2; m++) {
            matrix[m][m] = j;
            matrix[m][(m + 1) % (n - 2)] = remainder / 2;
        }
        for (int m = n - 2; m < n; m++) {
            matrix[m][m] = remainder / 2;
        }
        matrix[n - 2][n - 1] = j;
        matrix[n - 1][n - 2] = j;
        
        List<Integer> remainingNumbers = getRemainingNumbers(n, j, remainder / 2);
        
        for (int m = 0; m < n - 2; m++) {
            matrix[m][n - 1] = remainingNumbers.get(m);
            matrix[(m + 1) % (n - 2)][n - 2] = remainingNumbers.get(m);
        }
        if (n > 4) {
            for (int m = 0; m < n - 2; m++) {
                matrix[m][(m + 2) % (n - 2)] = remainingNumbers.get((m + 1) % (n - 2));
            }
        }
        for (int m = 0; m < n - 2; m++) {
            matrix[n - 2][m] = remainingNumbers.get(m);
            matrix[n - 1][m] = remainingNumbers.get((m + 1) % (n - 2));
        }
    }
    
    private static boolean isValidRemainderForAlternative(int[][] matrix, int n, int j, int remainder) {
        return remainder < 2 * n && remainder / 2 != j && remainder / 2 != j - 1;
    }
    
    private static void fillMatrixForAlternativeRemainder(int[][] matrix, int n, int j, int remainder) {
        for (int m = 0; m < n - 2; m++) {
            matrix[m][m] = j;
        }
        matrix[n - 1][n - 1] = remainder / 2 + 1;
        matrix[n - 2][n - 2] = remainder / 2;
        matrix[n - 2][n - 1] = j;
        matrix[n - 1][n - 2] = j;
        
        List<Integer> remainingNumbers = getRemainingNumbers(n, j, remainder / 2, remainder / 2 + 1);
        
        matrix[0][n - 1] = remainder / 2;
        matrix[1][n - 2] = remainder / 2 + 1;
        matrix[0][1] = remainder / 2 + 1;
        matrix[1][0] = remainder / 2;
        matrix[n - 2][0] = remainder / 2 + 1;
        matrix[n - 1][1] = remainder / 2;
        
        for (int m = 0; m < n - 3; m++) {
            matrix[m + 1][n - 1] = remainingNumbers.get(m);
            matrix[n - 2][m + 1] = remainingNumbers.get(m);
        }
        matrix[0][n - 2] = remainingNumbers.get(0);
        matrix[n - 1][0] = remainingNumbers.get(0);
        for (int m = 2; m < n - 3; m++) {
            matrix[m][n - 2] = remainingNumbers.get(m - 1);
            matrix[n - 1][m] = remainingNumbers.get(m - 1);
        }
    }
    
    private static List<Integer> getRemainingNumbers(int n, int... exclude) {
        List<Integer> remainingNumbers = new ArrayList<>();
        outer:
        for (int x = 1; x <= n; x++) {
            for (int ex : exclude) {
                if (x == ex) {
                    continue outer;
                }
            }
            remainingNumbers.add(x);
        }
        return remainingNumbers;
    }
    
    private static void printResult(int caseNumber, String result, int[][] matrix) {
        System.out.println("Case #" + caseNumber + ": " + result);
        if (matrix != null) {
            for (int[] row : matrix) {
                System.out.println(Arrays.toString(row).replace("[", "").replace(",", "").replace("]", ""));
            }
        }
    }
}