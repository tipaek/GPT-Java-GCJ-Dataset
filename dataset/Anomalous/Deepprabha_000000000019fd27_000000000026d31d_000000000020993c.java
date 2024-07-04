import java.util.Scanner;

class Matrix {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int t = kb.nextInt();
        int r = kb.nextInt();
        int c = kb.nextInt();
        int[][] arr = new int[r][c];

        // Reading the matrix elements
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                arr[i][j] = kb.nextInt();
            }
        }

        // Printing the matrix elements
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        // Calculating the sum of the diagonal elements
        for (int k = 1; k <= t; k++) {
            int sum = 0;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (i == j) {
                        sum += arr[i][j];
                    }
                }
            }
            System.out.println("Case #" + k + ": " + sum);
        }
    }
}