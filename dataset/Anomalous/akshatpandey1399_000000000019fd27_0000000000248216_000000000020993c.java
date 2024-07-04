import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        String[] results = new String[T];

        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int[][] matrix = new int[N][N];
            int[][] rowTracker = new int[N][N + 1];
            int[][] colTracker = new int[N][N + 1];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            int trace = 0;
            int rowCount = 0;
            int colCount = 0;

            for (int i = 0; i < N; i++) {
                boolean rowDuplicate = false;
                boolean colDuplicate = false;

                trace += matrix[i][i];

                for (int j = 0; j < N; j++) {
                    if (rowTracker[i][matrix[i][j]] == 1) {
                        rowDuplicate = true;
                    } else {
                        rowTracker[i][matrix[i][j]] = 1;
                    }

                    if (colTracker[i][matrix[j][i]] == 1) {
                        colDuplicate = true;
                    } else {
                        colTracker[i][matrix[j][i]] = 1;
                    }
                }

                if (rowDuplicate) {
                    rowCount++;
                }

                if (colDuplicate) {
                    colCount++;
                }
            }

            results[t] = "Case #" + (t + 1) + ": " + trace + " " + rowCount + " " + colCount;
        }

        for (String result : results) {
            System.out.println(result);
        }

        sc.close();
    }
}