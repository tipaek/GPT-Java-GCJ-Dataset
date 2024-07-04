import java.util.Scanner;

class Matrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        
        while (testcase > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = sc.nextInt();
                }
            }

            int duplicateColumns = 0;
            int duplicateRows = 0;
            int trace = 0;

            // Calculate the trace of the matrix
            for (int i = 0; i < n; i++) {
                trace += a[i][i];
            }

            // Check for duplicate elements in rows and columns
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();
                boolean duplicateRow = false;
                boolean duplicateCol = false;

                for (int j = 0; j < n; j++) {
                    // Check for duplicate in row
                    if (!rowSet.add(a[i][j])) {
                        duplicateRow = true;
                    }
                    // Check for duplicate in column
                    if (!colSet.add(a[j][i])) {
                        duplicateCol = true;
                    }
                }

                if (duplicateRow) {
                    duplicateRows++;
                }
                if (duplicateCol) {
                    duplicateColumns++;
                }
            }

            System.out.println("case #" + testcase + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
            testcase--;
        }
        
        sc.close();
    }
}