import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int caseNum = 1; caseNum <= T; caseNum++) {
            int N = sc.nextInt();
            int[][] mat = new int[N][N];
            int trace = 0, repeatedRows = 0, repeatedCols = 0;

            // Read the matrix
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    mat[r][c] = sc.nextInt();
                }
            }

            // Calculate the trace
            for (int r = 0; r < N; r++) {
                trace += mat[r][r];
            }

            // Count rows with repeated values
            for (int r = 0; r < N; r++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int c = 0; c < N; c++) {
                    if (!rowSet.add(mat[r][c])) {
                        repeatedRows++;
                        break;
                    }
                }
            }

            // Count columns with repeated values
            for (int c = 0; c < N; c++) {
                Set<Integer> colSet = new HashSet<>();
                for (int r = 0; r < N; r++) {
                    if (!colSet.add(mat[r][c])) {
                        repeatedCols++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + caseNum + ": " + trace + " " + repeatedRows + " " + repeatedCols);
        }
        sc.close();
    }
}