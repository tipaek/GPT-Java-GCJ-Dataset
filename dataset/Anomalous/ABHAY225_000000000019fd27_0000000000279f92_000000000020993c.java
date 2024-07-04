import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int p = 1; p <= T; p++) {
            int n = sc.nextInt();
            int[][] mat = new int[n][n];
            
            // Read matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mat[i][j] = sc.nextInt();
                }
            }
            
            // Calculate diagonal sum
            int diagonalSum = 0;
            for (int i = 0; i < n; i++) {
                diagonalSum += mat[i][i];
            }
            
            // Calculate row duplicates
            int rowDuplicates = 0;
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(mat[i][j])) {
                        rowDuplicates++;
                        break;
                    }
                }
            }
            
            // Calculate column duplicates
            int colDuplicates = 0;
            for (int i = 0; i < n; i++) {
                Set<Integer> colSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!colSet.add(mat[j][i])) {
                        colDuplicates++;
                        break;
                    }
                }
            }
            
            // Print result for the current test case
            System.out.println("Case #" + p + ": " + diagonalSum + " " + rowDuplicates + " " + colDuplicates);
        }
        
        sc.close();
    }
}