import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        String[] results = new String[T];

        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            int[][] matrix = new int[N][N];
            int[][] rowOccurrences = new int[N][N + 1];
            int[][] colOccurrences = new int[N][N + 1];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int trace = 0;
            int rowDuplicates = 0;
            int colDuplicates = 0;

            for (int i = 0; i < N; i++) {
                boolean rowHasDuplicate = false;
                boolean colHasDuplicate = false;

                trace += matrix[i][i];

                for (int j = 0; j < N; j++) {
                    if (rowOccurrences[i][matrix[i][j]] == 1 && !rowHasDuplicate) {
                        rowDuplicates++;
                        rowHasDuplicate = true;
                    } else {
                        rowOccurrences[i][matrix[i][j]] = 1;
                    }

                    if (colOccurrences[i][matrix[j][i]] == 1 && !colHasDuplicate) {
                        colDuplicates++;
                        colHasDuplicate = true;
                    } else {
                        colOccurrences[i][matrix[j][i]] = 1;
                    }

                    if (rowHasDuplicate && colHasDuplicate) {
                        break;
                    }
                }
            }

            results[t] = "Case #" + (t + 1) + ": " + trace + " " + rowDuplicates + " " + colDuplicates;
        }

        for (String result : results) {
            System.out.println(result);
        }

        scanner.close();
    }
}