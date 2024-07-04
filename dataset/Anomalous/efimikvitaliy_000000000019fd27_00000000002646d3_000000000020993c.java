import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int[][] matrix = new int[100][100];
        boolean[] seen = new boolean[101];

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            int numRowsWithDuplicates = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j <= N; j++) {
                    seen[j] = false;
                }
                for (int j = 0; j < N; j++) {
                    if (seen[matrix[i][j]]) {
                        numRowsWithDuplicates++;
                        break;
                    } else {
                        seen[matrix[i][j]] = true;
                    }
                }
            }

            int numColsWithDuplicates = 0;
            for (int j = 0; j < N; j++) {
                for (int i = 0; i <= N; i++) {
                    seen[i] = false;
                }
                for (int i = 0; i < N; i++) {
                    if (seen[matrix[i][j]]) {
                        numColsWithDuplicates++;
                        break;
                    } else {
                        seen[matrix[i][j]] = true;
                    }
                }
            }

            int trace = 0;
            for (int i = 0; i < N; i++) {
                trace += matrix[i][i];
            }

            System.out.println(String.format("Case #%d: %d %d %d", t, trace, numRowsWithDuplicates, numColsWithDuplicates));
        }
    }
}