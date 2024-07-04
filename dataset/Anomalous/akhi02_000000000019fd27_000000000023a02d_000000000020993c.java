import java.util.HashSet;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int[][] matrix = new int[N][N];
            
            // Read the matrix
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = sc.nextInt();
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
            
            System.out.println("Case #" + t + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
        
        sc.close();
    }
}