import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());

        for (int caseNum = 1; caseNum <= T; caseNum++) {
            int N = Integer.parseInt(scanner.nextLine());
            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;

            int[][] matrix = new int[N][N];

            // Read the matrix and calculate the trace and row repeats
            for (int i = 0; i < N; i++) {
                String[] row = scanner.nextLine().split(" ");
                boolean[] rowCheck = new boolean[N + 1]; // To check for duplicates in a row

                for (int j = 0; j < N; j++) {
                    int value = Integer.parseInt(row[j]);
                    matrix[i][j] = value;

                    if (rowCheck[value]) {
                        rowRepeats++;
                        rowCheck = new boolean[N + 1]; // Reset to avoid double counting
                        break;
                    }
                    rowCheck[value] = true;

                    if (i == j) {
                        trace += value;
                    }
                }
            }

            // Calculate column repeats
            for (int j = 0; j < N; j++) {
                boolean[] colCheck = new boolean[N + 1]; // To check for duplicates in a column

                for (int i = 0; i < N; i++) {
                    int value = matrix[i][j];

                    if (colCheck[value]) {
                        colRepeats++;
                        break;
                    }
                    colCheck[value] = true;
                }
            }

            System.out.println("Case #" + caseNum + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }

        scanner.close();
    }
}