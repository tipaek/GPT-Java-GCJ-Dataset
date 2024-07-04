import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Vestigium {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
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
            boolean validMatrix = true;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int temp = sc.nextInt();
                    if (temp < 1 || temp > n) {
                        validMatrix = false;
                        System.out.println("invalid");
                        temp = sc.nextInt(); // read a new value
                    }
                    matrix[i][j] = temp;
                }
            }

            if (validMatrix) {
                checkLatinSquare(matrix, n, k);
            }
        }

        sc.close();
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println(elapsedTime / 1000);
    }

    public static void checkLatinSquare(int[][] matrix, int n, int caseNumber) {
        int trace = 0;
        int rowCount = 0;
        int colCount = 0;

        for (int i = 0; i < n; i++) {
            boolean[] rowCheck = new boolean[n + 1];
            boolean[] colCheck = new boolean[n + 1];
            boolean rowDuplicate = false;
            boolean colDuplicate = false;

            for (int j = 0; j < n; j++) {
                if (i == j) {
                    trace += matrix[i][j];
                }

                if (rowCheck[matrix[i][j]]) {
                    rowDuplicate = true;
                } else {
                    rowCheck[matrix[i][j]] = true;
                }

                if (colCheck[matrix[j][i]]) {
                    colDuplicate = true;
                } else {
                    colCheck[matrix[j][i]] = true;
                }
            }

            if (rowDuplicate) {
                rowCount++;
            }
            if (colDuplicate) {
                colCount++;
            }
        }

        System.out.println("Case #" + caseNumber + ": " + trace + " " + rowCount + " " + colCount);
    }
}