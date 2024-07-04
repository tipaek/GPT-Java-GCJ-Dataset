import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }
            
            int repeatedRows = countRepeatedRows(matrix, n);
            int repeatedCols = countRepeatedCols(matrix, n);
            int diagonalSum = calculateDiagonalSum(matrix, n);
            
            System.out.println("Case #" + caseNumber + ": " + diagonalSum + " " + repeatedRows + " " + repeatedCols);
        }
        
        scanner.close();
    }

    private static int countRepeatedRows(int[][] matrix, int n) {
        int repeatedRows = 0;
        
        for (int row = 0; row < n; row++) {
            if (hasDuplicates(matrix[row])) {
                repeatedRows++;
            }
        }
        
        return repeatedRows;
    }

    private static int countRepeatedCols(int[][] matrix, int n) {
        int repeatedCols = 0;
        
        for (int col = 0; col < n; col++) {
            int[] columnData = new int[n];
            for (int row = 0; row < n; row++) {
                columnData[row] = matrix[row][col];
            }
            if (hasDuplicates(columnData)) {
                repeatedCols++;
            }
        }
        
        return repeatedCols;
    }

    private static int calculateDiagonalSum(int[][] matrix, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    private static boolean hasDuplicates(int[] array) {
        Set<Integer> uniqueElements = new HashSet<>();
        for (int value : array) {
            if (!uniqueElements.add(value)) {
                return true;
            }
        }
        return false;
    }
}