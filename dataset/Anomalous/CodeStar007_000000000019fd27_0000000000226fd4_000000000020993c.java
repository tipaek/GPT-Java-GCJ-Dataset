import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caseNumber = 1;
        int testCases = scanner.nextInt();
        
        while (testCases-- > 0) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            
            processTestCase(size, matrix, caseNumber++);
        }
        
        scanner.close();
    }

    private static void processTestCase(int size, int[][] matrix, int caseNumber) {
        int trace = 0, rowCount = 0, colCount = 0;
        
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        
        for (int i = 0; i < size; i++) {
            if (hasDuplicates(matrix[i])) {
                rowCount++;
            }
        }
        
        for (int j = 0; j < size; j++) {
            if (hasDuplicates(getColumn(matrix, j))) {
                colCount++;
            }
        }

        System.out.printf("Case #%d: %d %d %d%n", caseNumber, trace, rowCount, colCount);
    }

    private static boolean hasDuplicates(int[] array) {
        HashSet<Integer> set = new HashSet<>();
        for (int value : array) {
            if (!set.add(value)) {
                return true;
            }
        }
        return false;
    }

    private static int[] getColumn(int[][] matrix, int columnIndex) {
        int[] column = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            column[i] = matrix[i][columnIndex];
        }
        return column;
    }
}