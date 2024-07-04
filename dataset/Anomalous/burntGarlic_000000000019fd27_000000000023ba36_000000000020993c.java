import java.util.Scanner;

public class Vestigium {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of test cases:");
        int t = sc.nextInt();

        if (t < 1 || t > 100) {
            System.out.println("Invalid number of test cases");
            return;
        }

        for (int k = 1; k <= t; k++) {
            System.out.println("Enter size of matrix:");
            int n = sc.nextInt();

            if (n < 2 || n > 100) {
                System.out.println("Invalid matrix size");
                break;
            }

            int[][] arr = new int[n][n];
            System.out.println("Enter " + n * n + " elements:");

            boolean validInput = true;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int element = sc.nextInt();
                    if (element < 1 || element > n) {
                        System.out.println("Invalid element");
                        validInput = false;
                        break;
                    }
                    arr[i][j] = element;
                }
                if (!validInput) break;
            }

            if (!validInput) continue;

            System.out.println("Matrix:");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }

            isLatinSquare(arr, n, k);
        }
    }

    public static void isLatinSquare(int[][] matrix, int size, int caseNumber) {
        int trace = 0;
        int rowRepeats = 0;
        int colRepeats = 0;

        for (int i = 0; i < size; i++) {
            boolean[] rowCheck = new boolean[size + 1];
            boolean[] colCheck = new boolean[size + 1];

            for (int j = 0; j < size; j++) {
                if (i == j) {
                    trace += matrix[i][j];
                }

                if (rowCheck[matrix[i][j]]) {
                    rowRepeats++;
                    break;
                }
                rowCheck[matrix[i][j]] = true;

                if (colCheck[matrix[j][i]]) {
                    colRepeats++;
                    break;
                }
                colCheck[matrix[j][i]] = true;
            }
        }

        System.out.println("Case #" + caseNumber + ": " + trace + " " + rowRepeats + " " + colRepeats);
    }
}