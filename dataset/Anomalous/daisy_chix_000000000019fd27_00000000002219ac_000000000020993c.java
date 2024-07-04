import java.util.Scanner;
import java.util.HashSet;

class Solution {
    
    static int countDuplicateColumns(int[][] matrix, int size) {
        int columnCount = 0;
        for (int col = 0; col < size; col++) {
            HashSet<Integer> uniqueElements = new HashSet<>();
            for (int row = 0; row < size; row++) {
                uniqueElements.add(matrix[row][col]);
            }
            if (uniqueElements.size() < size) {
                columnCount++;
            }
        }
        return columnCount;
    }

    static int countDuplicateRows(int[][] matrix, int size) {
        int rowCount = 0;
        for (int[] row : matrix) {
            if (hasDuplicates(row, size)) {
                rowCount++;
            }
        }
        return rowCount;
    }

    static boolean hasDuplicates(int[] array, int size) {
        HashSet<Integer> uniqueElements = new HashSet<>();
        for (int num : array) {
            if (!uniqueElements.add(num)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            int trace = 0;
            
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }
            
            int duplicateRows = countDuplicateRows(matrix, size);
            int duplicateColumns = countDuplicateColumns(matrix, size);
            
            System.out.println("Case #" + testCase + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }
        
        scanner.close();
    }
}