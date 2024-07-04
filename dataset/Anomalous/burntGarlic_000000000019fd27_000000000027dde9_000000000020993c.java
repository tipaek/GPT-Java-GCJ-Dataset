import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Vestigium {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();

        if (t < 1 || t > 100) {
            sc.close();
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
                    int value = sc.nextInt();
                    if (value < 1 || value > n) {
                        validInput = false;
                        System.out.println("invalid");
                        break;
                    }
                    matrix[i][j] = value;
                }
                if (!validInput) break;
            }

            if (validInput) {
                isLatinSquare(matrix, n, k);
            }
        }

        sc.close();
    }

    public static void isLatinSquare(int[][] matrix, int size, int testCaseNumber) {
        int trace = 0;
        int rowCount = 0;
        int colCount = 0;

        for (int i = 0; i < size; i++) {
            boolean[] rowCheck = new boolean[size + 1];
            boolean[] colCheck = new boolean[size + 1];
            boolean rowDuplicate = false;
            boolean colDuplicate = false;

            for (int j = 0; j < size; j++) {
                // Check for row duplicates
                if (rowCheck[matrix[i][j]]) {
                    rowDuplicate = true;
                } else {
                    rowCheck[matrix[i][j]] = true;
                }

                // Check for column duplicates
                if (colCheck[matrix[j][i]]) {
                    colDuplicate = true;
                } else {
                    colCheck[matrix[j][i]] = true;
                }
            }

            if (rowDuplicate) rowCount++;
            if (colDuplicate) colCount++;
            trace += matrix[i][i];
        }

        System.out.println("Case #" + testCaseNumber + ": " + trace + " " + rowCount + " " + colCount);
    }
}