import java.util.Scanner;

public class Vestigium {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;

            // Read matrix and calculate trace
            for (int i = 0; i < n; i++) {
                boolean[] rowCheck = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    if (rowCheck[matrix[i][j]]) {
                        rowRepeats++;
                        rowCheck = new boolean[n + 1]; // Reset row check to avoid multiple counts
                        break;
                    }
                    rowCheck[matrix[i][j]] = true;
                }
            }

            // Check for column repeats
            for (int j = 0; j < n; j++) {
                boolean[] colCheck = new boolean[n + 1];
                for (int i = 0; i < n; i++) {
                    if (colCheck[matrix[i][j]]) {
                        colRepeats++;
                        break;
                    }
                    colCheck[matrix[i][j]] = true;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
    }
}