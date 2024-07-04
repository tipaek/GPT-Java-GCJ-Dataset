import java.util.Scanner;

class Vestigium {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        if (t < 1 || t > 100) {
            return;
        }

        for (int k = 1; k <= t; k++) {
            int n = sc.nextInt();
            if (n < 2 || n > 100) {
                break;
            }

            int[][] matrix = new int[n][n];
            boolean validInput = true;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int temp = sc.nextInt();
                    if (temp < 1 || temp > n) {
                        validInput = false;
                    }
                    matrix[i][j] = validInput ? temp : 0;
                }
            }

            if (validInput) {
                analyzeLatinSquare(matrix, n, k);
            }
        }
    }

    public static void analyzeLatinSquare(int[][] matrix, int size, int caseNumber) {
        int trace = 0;
        int rowRepeats = 0;
        int colRepeats = 0;

        for (int i = 0; i < size; i++) {
            boolean[] rowCheck = new boolean[size + 1];
            boolean[] colCheck = new boolean[size + 1];
            boolean rowHasDuplicate = false;
            boolean colHasDuplicate = false;

            for (int j = 0; j < size; j++) {
                if (i == j) {
                    trace += matrix[i][j];
                }

                if (rowCheck[matrix[i][j]]) {
                    rowHasDuplicate = true;
                } else {
                    rowCheck[matrix[i][j]] = true;
                }

                if (colCheck[matrix[j][i]]) {
                    colHasDuplicate = true;
                } else {
                    colCheck[matrix[j][i]] = true;
                }
            }

            if (rowHasDuplicate) {
                rowRepeats++;
            }

            if (colHasDuplicate) {
                colRepeats++;
            }
        }

        System.out.println("Case #" + caseNumber + ": " + trace + " " + rowRepeats + " " + colRepeats);
    }
}