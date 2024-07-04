import java.util.Scanner;

public class Codejam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int[][] ar = new int[n][n];
            int trace = 0;
            int rowCount = 0;
            int colCount = 0;
            
            // Read the matrix and calculate the trace
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    ar[j][k] = sc.nextInt();
                    if (j == k) {
                        trace += ar[j][k];
                    }
                }
            }
            
            // Check for duplicate elements in rows
            for (int j = 0; j < n; j++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int k = 0; k < n; k++) {
                    if (!rowSet.add(ar[j][k])) {
                        rowCount++;
                        break;
                    }
                }
            }
            
            // Check for duplicate elements in columns
            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int k = 0; k < n; k++) {
                    if (!colSet.add(ar[k][j])) {
                        colCount++;
                        break;
                    }
                }
            }
            
            System.out.println("Case #" + i + ": " + trace + " " + rowCount + " " + colCount);
        }
        
        sc.close();
    }
}