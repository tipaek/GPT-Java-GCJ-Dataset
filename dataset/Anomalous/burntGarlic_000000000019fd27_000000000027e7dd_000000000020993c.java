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

        long startTime = System.currentTimeMillis();

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
                        System.out.println("invalid");
                        value = sc.nextInt();
                    }
                    matrix[i][j] = value;
                }
            }

            if (validInput) {
                evaluateMatrix(matrix, n, k);
            }
        }

        sc.close();
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println(elapsedTime / 1000);
    }

    public static void evaluateMatrix(int[][] matrix, int n, int caseNumber) {
        int trace = 0;
        int rowDuplicates = 0;
        int colDuplicates = 0;

        for (int i = 0; i < n; i++) {
            boolean[] rowCheck = new boolean[n + 1];
            boolean[] colCheck = new boolean[n + 1];

            for (int j = 0; j < n; j++) {
                if (i == j) {
                    trace += matrix[i][j];
                }

                if (rowCheck[matrix[i][j]]) {
                    rowDuplicates++;
                    break;
                }
                rowCheck[matrix[i][j]] = true;

                if (colCheck[matrix[j][i]]) {
                    colDuplicates++;
                    break;
                }
                colCheck[matrix[j][i]] = true;
            }
        }

        System.out.println("Case #" + caseNumber + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
    }
}