import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int caseNum = 1; caseNum <= T; caseNum++) {
            int N = sc.nextInt();
            int[][] mat = new int[N][N];

            // Read the matrix
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    mat[r][c] = sc.nextInt();
                }
            }

            // Calculate the trace
            int trace = 0;
            for (int r = 0; r < N; r++) {
                trace += mat[r][r];
            }

            // Count rows with repeated values
            int rowCount = 0;
            for (int r = 0; r < N; r++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int c = 0; c < N; c++) {
                    if (!rowSet.add(mat[r][c])) {
                        rowCount++;
                        break;
                    }
                }
            }

            // Count columns with repeated values
            int colCount = 0;
            for (int c = 0; c < N; c++) {
                Set<Integer> colSet = new HashSet<>();
                for (int r = 0; r < N; r++) {
                    if (!colSet.add(mat[r][c])) {
                        colCount++;
                        break;
                    }
                }
            }

            // Output the results
            System.out.println("Case #" + caseNum + ": " + trace + " " + rowCount + " " + colCount);
        }
    }
}