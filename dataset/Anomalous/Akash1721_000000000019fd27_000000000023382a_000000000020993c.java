import java.util.*;

class Solution {
    static int calculateTrace(int[][] matrix, int size) {
        int traceSum = 0;
        for (int i = 0; i < size; i++) {
            traceSum += matrix[i][i];
        }
        return traceSum;
    }

    static boolean hasDuplicatesWithinRange(int[] array, int range) {
        Set<Integer> uniqueElements = new HashSet<>();
        
        for (int i = 0; i < array.length; i++) {
            if (uniqueElements.contains(array[i])) {
                return true;
            }
            
            uniqueElements.add(array[i]);
            
            if (i >= range) {
                uniqueElements.remove(array[i - range]);
            }
        }
        return false;
    }

    static int countRowsWithDuplicates(int[][] matrix, int size) {
        int[] rowArray = new int[size];
        int duplicateCount = 0;
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                rowArray[j] = matrix[i][j];
            }
            
            if (hasDuplicatesWithinRange(rowArray, size)) {
                duplicateCount++;
            }
        }
        return duplicateCount;
    }

    static int countColsWithDuplicates(int[][] matrix, int size) {
        int[] colArray = new int[size];
        int duplicateCount = 0;
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                colArray[j] = matrix[j][i];
            }
            
            if (hasDuplicatesWithinRange(colArray, size)) {
                duplicateCount++;
            }
        }
        return duplicateCount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            
            int trace = calculateTrace(matrix, matrixSize);
            int rowsWithDuplicates = countRowsWithDuplicates(matrix, matrixSize);
            int colsWithDuplicates = countColsWithDuplicates(matrix, matrixSize);
            
            System.out.println("Case #" + t + ": " + trace + " " + rowsWithDuplicates + " " + colsWithDuplicates);
        }
        
        scanner.close();
    }
}