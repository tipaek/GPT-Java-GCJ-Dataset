import java.util.Scanner;

class Matrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        
        while (testcase > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            
            // Reading the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = sc.nextInt();
                }
            }
            
            // Check for duplicate elements in columns
            int duplicateColumns = 0;
            for (int i = 0; i < n; i++) {
                Set<Integer> columnSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!columnSet.add(a[j][i])) {
                        duplicateColumns++;
                        break;
                    }
                }
            }
            
            // Check for duplicate elements in rows
            int duplicateRows = 0;
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(a[i][j])) {
                        duplicateRows++;
                        break;
                    }
                }
            }
            
            // Calculate the sum of the diagonal elements
            int diagonalSum = 0;
            for (int i = 0; i < n; i++) {
                diagonalSum += a[i][i];
            }
            
            // Output the result
            System.out.println("case #" + testcase + ": " + diagonalSum + " " + duplicateColumns + " " + duplicateRows);
            testcase--;
        }
        
        sc.close();
    }
}