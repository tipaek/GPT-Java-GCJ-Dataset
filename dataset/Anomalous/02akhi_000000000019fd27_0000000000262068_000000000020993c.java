import java.util.Scanner;

class Matrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int v = 0; v < t; v++) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            
            // Reading the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = sc.nextInt();
                }
            }
            
            // Calculating the sum of the main diagonal
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += a[i][i];
            }

            // Finding the maximum number of duplicate elements in any row
            int maxRowDuplicates = 0;
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                int rowDuplicates = 0;
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(a[i][j])) {
                        rowDuplicates++;
                    }
                }
                maxRowDuplicates = Math.max(maxRowDuplicates, rowDuplicates);
            }

            // Finding the maximum number of duplicate elements in any column
            int maxColDuplicates = 0;
            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                int colDuplicates = 0;
                for (int i = 0; i < n; i++) {
                    if (!colSet.add(a[i][j])) {
                        colDuplicates++;
                    }
                }
                maxColDuplicates = Math.max(maxColDuplicates, colDuplicates);
            }

            // Printing the result for this test case
            System.out.println("Case #" + (v + 1) + ": " + sum + " " + maxRowDuplicates + " " + maxColDuplicates);
        }
        
        sc.close();
    }
}