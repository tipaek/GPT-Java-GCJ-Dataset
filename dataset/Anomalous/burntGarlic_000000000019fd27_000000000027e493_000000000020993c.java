import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Vestigium {
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
            boolean valid = true;

            for (int i = 0; i < n && valid; i++) {
                for (int j = 0; j < n && valid; j++) {
                    int temp = sc.nextInt();
                    if (temp < 1 || temp > n) {
                        valid = false;
                        System.out.println("invalid");
                        sc.nextInt(); // Read the next input to continue
                    } else {
                        matrix[i][j] = temp;
                    }
                }
            }

            if (valid) {
                checkLatinSquare(matrix, n, k);
            }
        }

        sc.close();
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println(elapsedTime / 1000);
    }

    private static void checkLatinSquare(int[][] matrix, int size, int caseNumber) {
        int trace = 0;
        int rowDuplicates = 0;
        int colDuplicates = 0;

        for (int i = 0; i < size; i++) {
            boolean[] rowCheck = new boolean[size + 1];
            boolean[] colCheck = new boolean[size + 1];
            boolean rowFlag = false;
            boolean colFlag = false;

            for (int j = 0; j < size; j++) {
                if (i == j) {
                    trace += matrix[i][j];
                }

                if (rowCheck[matrix[i][j]]) {
                    rowFlag = true;
                } else {
                    rowCheck[matrix[i][j]] = true;
                }

                if (colCheck[matrix[j][i]]) {
                    colFlag = true;
                } else {
                    colCheck[matrix[j][i]] = true;
                }
            }

            if (rowFlag) {
                rowDuplicates++;
            }
            if (colFlag) {
                colDuplicates++;
            }
        }

        System.out.println("Case #" + caseNumber + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
    }
}