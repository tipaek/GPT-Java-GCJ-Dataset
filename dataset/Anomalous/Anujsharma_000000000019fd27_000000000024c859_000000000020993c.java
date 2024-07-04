import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            
            // Read matrix input
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = sc.nextInt();
                }
            }
            
            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;
            
            // Calculate trace
            for (int j = 0; j < n; j++) {
                trace += matrix[j][j];
            }
            
            // Check for repeated elements in rows
            for (int row = 0; row < n; row++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int col = 0; col < n; col++) {
                    rowSet.add(matrix[row][col]);
                }
                if (rowSet.size() < n) {
                    rowRepeats++;
                }
            }
            
            // Check for repeated elements in columns
            for (int col = 0; col < n; col++) {
                Set<Integer> colSet = new HashSet<>();
                for (int row = 0; row < n; row++) {
                    colSet.add(matrix[row][col]);
                }
                if (colSet.size() < n) {
                    colRepeats++;
                }
            }
            
            System.out.println("Case #" + i + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
        
        sc.close();
    }
}