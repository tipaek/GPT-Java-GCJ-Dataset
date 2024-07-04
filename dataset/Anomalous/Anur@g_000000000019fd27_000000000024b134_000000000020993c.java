import java.util.*;

class Natural {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        
        for (int m = 1; m <= T; m++) {
            int n = scan.nextInt();
            int[][] matrix = new int[n][n];
            int[] row = new int[n];
            int[] col = new int[n];
            
            int trace = fillMatrixAndGetTrace(scan, matrix, n);
            int maxRowDup = 0, maxColDup = 0;
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    row[j] = matrix[i][j];
                    col[j] = matrix[j][i];
                }
                
                Arrays.sort(row);
                Arrays.sort(col);
                
                maxRowDup = Math.max(maxRowDup, countDuplicates(row, n));
                maxColDup = Math.max(maxColDup, countDuplicates(col, n));
            }
            
            System.out.println("Case #" + m + ": " + trace + " " + maxRowDup + " " + maxColDup);
        }
    }
    
    private static int fillMatrixAndGetTrace(Scanner scan, int[][] matrix, int n) {
        int trace = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scan.nextInt();
                if (i == j) {
                    trace += matrix[i][j];
                }
            }
        }
        
        return trace;
    }
    
    private static int countDuplicates(int[] array, int n) {
        int duplicates = 0;
        boolean foundDuplicate = false;
        
        for (int i = 0; i < n - 1; i++) {
            if (array[i] == array[i + 1]) {
                if (!foundDuplicate) {
                    duplicates++;
                    foundDuplicate = true;
                }
                duplicates++;
            } else {
                foundDuplicate = false;
            }
        }
        
        return duplicates;
    }
}