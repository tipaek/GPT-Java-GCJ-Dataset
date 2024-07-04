import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int t = scanner.nextInt();  // Number of test cases
        for (int caseNum = 1; caseNum <= t; caseNum++) {
            int n = scanner.nextInt();  // Size of the matrix
            int[][] matrix = new int[n][n];
            
            // Read the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            
            int r = 0;  // Count of rows with duplicate elements
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        r++;
                        break;
                    }
                }
            }
            
            int c = 0;  // Count of columns with duplicate elements
            for (int i = 0; i < n; i++) {
                Set<Integer> colSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!colSet.add(matrix[j][i])) {
                        c++;
                        break;
                    }
                }
            }
            
            int s = 0;  // Sum of the diagonal elements
            for (int i = 0; i < n; i++) {
                s += matrix[i][i];
            }
            
            System.out.printf("Case #%d: %d %d %d%n", caseNum, s, r, c);
        }
        
        scanner.close();
    }
}