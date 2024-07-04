import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        runCodeJam();
    }

    private static void runCodeJam() {
        Scanner scanner = new Scanner(System.in);
        int numCases = Integer.parseInt(scanner.nextLine());
        
        for (int caseNum = 1; caseNum <= numCases; caseNum++) {
            int size = Integer.parseInt(scanner.nextLine());
            int[][] matrix = new int[size][size];
            
            for (int row = 0; row < size; row++) {
                String[] elements = scanner.nextLine().split(" ");
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = Integer.parseInt(elements[col]);
                }
            }
            
            processMatrix(matrix, caseNum);
        }
        
        scanner.close();
    }

    private static void processMatrix(int[][] matrix, int caseNum) {
        int[] results = analyzeMatrix(matrix);
        System.out.println("Case #" + caseNum + ": " + results[0] + " " + results[1] + " " + results[2]);
    }

    private static int[] analyzeMatrix(int[][] matrix) {
        int trace = 0;
        int repeatedRows = 0;
        int repeatedCols = 0;
        
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
            if (hasDuplicates(matrix[i])) {
                repeatedRows++;
            }
            if (hasDuplicates(getColumn(matrix, i))) {
                repeatedCols++;
            }
        }
        
        return new int[]{trace, repeatedRows, repeatedCols};
    }

    private static boolean hasDuplicates(int[] array) {
        boolean[] seen = new boolean[array.length + 1]; // Assuming values are 1 to n
        for (int value : array) {
            if (seen[value]) {
                return true;
            }
            seen[value] = true;
        }
        return false;
    }

    private static int[] getColumn(int[][] matrix, int colIndex) {
        int[] column = new int[matrix.length];
        for (int row = 0; row < matrix.length; row++) {
            column[row] = matrix[row][colIndex];
        }
        return column;
    }
}