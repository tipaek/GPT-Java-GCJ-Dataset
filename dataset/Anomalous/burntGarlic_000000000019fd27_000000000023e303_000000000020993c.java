import java.util.Scanner;

public class Vestigium {
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

            int[][] arr = new int[n][n];
            boolean validInput = true;

            for (int i = 0; i < n && validInput; i++) {
                for (int j = 0; j < n && validInput; j++) {
                    int temp = sc.nextInt();
                    if (temp < 1 || temp > n) {
                        validInput = false;
                    } else {
                        arr[i][j] = temp;
                    }
                }
            }

            if (validInput) {
                analyzeLatinSquare(arr, n, k);
            }
        }
    }

    public static void analyzeLatinSquare(int[][] matrix, int size, int testCase) {
        int trace = 0, rowCount = 0, colCount = 0;

        for (int i = 0; i < size; i++) {
            boolean[] rowCheck = new boolean[size + 1];
            boolean[] colCheck = new boolean[size + 1];
            boolean rowDuplicate = false, colDuplicate = false;

            for (int j = 0; j < size; j++) {
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

        System.out.println("Case #" + testCase + ": " + trace + " " + rowCount + " " + colCount);
    }
}