import java.util.*;

class NaturalNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            
            // Read matrix data and calculate trace
            int trace = readMatrixAndCalculateTrace(scanner, matrix, n);
            
            int maxRowDuplicates = 0;
            int maxColDuplicates = 0;
            
            for (int i = 0; i < n; i++) {
                int[] row = matrix[i];
                int[] col = new int[n];
                
                for (int j = 0; j < n; j++) {
                    col[j] = matrix[j][i];
                }
                
                Arrays.sort(row);
                Arrays.sort(col);
                
                int rowDuplicates = countDuplicates(row);
                int colDuplicates = countDuplicates(col);
                
                maxRowDuplicates = Math.max(maxRowDuplicates, rowDuplicates);
                maxColDuplicates = Math.max(maxColDuplicates, colDuplicates);
            }
            
            System.out.println("Case #" + t + ": " + trace + " " + maxRowDuplicates + " " + maxColDuplicates);
        }
        
        scanner.close();
    }

    private static int readMatrixAndCalculateTrace(Scanner scanner, int[][] matrix, int n) {
        int trace = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
                if (i == j) {
                    trace += matrix[i][j];
                }
            }
        }
        
        return trace;
    }

    private static int countDuplicates(int[] array) {
        int duplicates = 0;
        boolean foundDuplicate = false;
        
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == array[i + 1]) {
                if (!foundDuplicate) {
                    duplicates++;
                }
                foundDuplicate = true;
            } else {
                foundDuplicate = false;
            }
        }
        
        return duplicates;
    }
}