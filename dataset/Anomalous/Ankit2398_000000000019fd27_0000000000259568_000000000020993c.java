import java.util.Scanner;

class Trace {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int t = 1; t <= T; t++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;
            
            // Read matrix and calculate trace
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }
            
            // Calculate number of rows with duplicate elements
            int duplicateRows = 0;
            for (int i = 0; i < n; i++) {
                if (hasDuplicate(matrix[i])) {
                    duplicateRows++;
                }
            }
            
            // Calculate number of columns with duplicate elements
            int duplicateColumns = 0;
            for (int j = 0; j < n; j++) {
                int[] column = new int[n];
                for (int i = 0; i < n; i++) {
                    column[i] = matrix[i][j];
                }
                if (hasDuplicate(column)) {
                    duplicateColumns++;
                }
            }
            
            System.out.println("Case #" + t + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }
        
        sc.close();
    }
    
    // Helper method to check for duplicates in an array
    private static boolean hasDuplicate(int[] array) {
        boolean[] seen = new boolean[array.length + 1];
        for (int value : array) {
            if (seen[value]) {
                return true;
            }
            seen[value] = true;
        }
        return false;
    }
}