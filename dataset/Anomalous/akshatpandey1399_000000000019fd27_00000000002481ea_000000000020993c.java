import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        String[] solutions = new String[T];
        
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int[][] arr = new int[N][N];
            int[][] row = new int[N][N + 1];
            int[][] col = new int[N][N + 1];
            int trace = 0;
            int rowCount = 0;
            int colCount = 0;

            // Read the matrix
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            // Calculate trace, rowCount and colCount
            for (int i = 0; i < N; i++) {
                boolean isRowDuplicate = false;
                boolean isColDuplicate = false;
                trace += arr[i][i];
                
                for (int j = 0; j < N; j++) {
                    // Check for row duplicates
                    if (row[i][arr[i][j]] == 1) {
                        if (!isRowDuplicate) {
                            rowCount++;
                            isRowDuplicate = true;
                        }
                    } else {
                        row[i][arr[i][j]] = 1;
                    }

                    // Check for column duplicates
                    if (col[j][arr[j][i]] == 1) {
                        if (!isColDuplicate) {
                            colCount++;
                            isColDuplicate = true;
                        }
                    } else {
                        col[j][arr[j][i]] = 1;
                    }
                    
                    if (isRowDuplicate && isColDuplicate) break;
                }
            }
            solutions[t] = "Case #" + (t + 1) + ": " + trace + " " + rowCount + " " + colCount;
        }

        // Print all solutions
        for (String solution : solutions) {
            System.out.println(solution);
        }

        sc.close();
    }
}