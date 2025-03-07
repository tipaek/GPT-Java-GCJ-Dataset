import java.util.Scanner;

class Vestigium {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of test cases");
        int t = sc.nextInt();

        if (t < 1 || t > 100) {
            System.out.println("Invalid number of test cases");
            return;
        }

        for (int k = 1; k <= t; k++) {
            System.out.println("Enter Size of Matrix");
            int n = sc.nextInt();

            if (n < 2 || n > 100) {
                System.out.println("Invalid matrix size");
                return;
            }

            int[][] arr = new int[n][n];
            System.out.println("Enter " + (n * n) + " elements");

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int temp = sc.nextInt();
                    if (temp < 1 || temp > n) {
                        System.out.println("Invalid element");
                        return;
                    }
                    arr[i][j] = temp;
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }

            isLatinSquare(arr, n, k);
        }
    }

    public static void isLatinSquare(int[][] a, int len, int t) {
        int sum = 0, rcount = 0, ccount = 0;

        for (int i = 0; i < len; i++) {
            boolean[] rowCheck = new boolean[len + 1];
            boolean[] colCheck = new boolean[len + 1];

            for (int j = 0; j < len; j++) {
                if (rowCheck[a[i][j]]) {
                    rcount++;
                    break;
                }
                rowCheck[a[i][j]] = true;

                if (colCheck[a[j][i]]) {
                    ccount++;
                    break;
                }
                colCheck[a[j][i]] = true;

                if (i == j) {
                    sum += a[i][j];
                }
            }
        }

        System.out.println("Case #" + t + ": " + sum + " " + rcount + " " + ccount);
    }
}