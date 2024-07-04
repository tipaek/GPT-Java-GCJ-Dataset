import java.util.Scanner;

public class Vestigium {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter T");
        int t = sc.nextInt();

        while (t-- > 0) {
            System.out.println("Enter N");
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            int k = 0, r = 0, c = 0;

            // Reading the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            // Calculating the trace
            for (int i = 0; i < n; i++) {
                k += arr[i][i];
            }

            // Checking for duplicate values in rows
            for (int i = 0; i < n; i++) {
                boolean[] rowCheck = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    if (rowCheck[arr[i][j]]) {
                        r++;
                        break;
                    }
                    rowCheck[arr[i][j]] = true;
                }
            }

            // Checking for duplicate values in columns
            for (int j = 0; j < n; j++) {
                boolean[] colCheck = new boolean[n + 1];
                for (int i = 0; i < n; i++) {
                    if (colCheck[arr[i][j]]) {
                        c++;
                        break;
                    }
                    colCheck[arr[i][j]] = true;
                }
            }

            System.out.println("Trace: " + k);
            System.out.println("Rows with duplicates: " + r);
            System.out.println("Columns with duplicates: " + c);
        }

        sc.close();
    }
}