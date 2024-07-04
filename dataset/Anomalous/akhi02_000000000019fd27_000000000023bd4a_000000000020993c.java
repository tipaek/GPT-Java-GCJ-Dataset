import java.util.HashSet;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        
        for (int t = 1; t <= T; t++) {
            int N = scanner.nextInt();
            int[][] matrix = new int[N][N];
            
            // Read the matrix
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            
            int trace = 0, rowDuplicates = 0, colDuplicates = 0;
            
            // Calculate trace and row duplicates
            for (int i = 0; i < N; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                boolean rowHasDuplicate = false;
                
                for (int j = 0; j < N; j++) {
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    
                    if (!rowHasDuplicate) {
                        if (rowSet.contains(matrix[i][j])) {
                            rowDuplicates++;
                            rowHasDuplicate = true;
                        } else {
                            rowSet.add(matrix[i][j]);
                        }
                    }
                }
            }
            
            // Calculate column duplicates
            for (int j = 0; j < N; j++) {
                HashSet<Integer> colSet = new HashSet<>();
                
                for (int i = 0; i < N; i++) {
                    if (colSet.contains(matrix[i][j])) {
                        colDuplicates++;
                        break;
                    } else {
                        colSet.add(matrix[i][j]);
                    }
                }
            }
            
            // Print the result for the current test case
            System.out.println("Case #" + t + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
        
        scanner.close();
    }
}