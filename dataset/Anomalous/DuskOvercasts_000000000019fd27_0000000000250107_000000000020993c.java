import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            for (int q = 0; q < t; q++) {
                int n = sc.nextInt();
                int[][] matrix = new int[n][n];
                
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        matrix[i][j] = sc.nextInt();
                    }
                }
                
                int trace = 0;
                for (int i = 0; i < n; i++) {
                    trace += matrix[i][i];
                }
                
                int rowRepeats = 0;
                int colRepeats = 0;
                
                for (int i = 0; i < n; i++) {
                    boolean[] rowCheck = new boolean[n];
                    boolean[] colCheck = new boolean[n];
                    
                    for (int j = 0; j < n; j++) {
                        if (rowCheck[matrix[i][j] - 1]) {
                            rowRepeats++;
                            break;
                        }
                        rowCheck[matrix[i][j] - 1] = true;
                    }
                    
                    for (int j = 0; j < n; j++) {
                        if (colCheck[matrix[j][i] - 1]) {
                            colRepeats++;
                            break;
                        }
                        colCheck[matrix[j][i] - 1] = true;
                    }
                }
                
                System.out.printf("Case #%d: %d %d %d%n", q + 1, trace, rowRepeats, colRepeats);
            }
        } catch (Exception e) {
            // Handle exceptions if needed
        }
    }
}