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

            int[][] arr = new int[n][n];
            boolean validInput = true;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int temp = sc.nextInt();
                    if (temp < 1 || temp > n) {
                        validInput = false;
                        break;
                    }
                    arr[i][j] = temp;
                }
                if (!validInput) {
                    break;
                }
            }

            if (validInput) {
                isLatinSquare(arr, n, k);
            }
        }
    }

    public static void isLatinSquare(int[][] arr, int n, int t) {
        int sum = 0;
        int rcount = 0;
        int ccount = 0;

        for (int i = 0; i < n; i++) {
            boolean[] rowCheck = new boolean[n + 1];
            boolean[] colCheck = new boolean[n + 1];
            boolean rowDuplicate = false;
            boolean colDuplicate = false;

            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0 || rowCheck[arr[i][j]]) {
                    rowDuplicate = true;
                } else {
                    rowCheck[arr[i][j]] = true;
                }

                if (arr[j][i] == 0 || colCheck[arr[j][i]]) {
                    colDuplicate = true;
                } else {
                    colCheck[arr[j][i]] = true;
                }

                if (i == j) {
                    sum += arr[i][j];
                }
            }

            if (rowDuplicate) {
                rcount++;
            }
            if (colDuplicate) {
                ccount++;
            }
        }

        System.out.println("Case #" + t + ": " + sum + " " + rcount + " " + ccount);
    }
}