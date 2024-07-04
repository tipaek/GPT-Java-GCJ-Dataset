import java.util.Scanner;

class Matrix {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int t = kb.nextInt();
        int r = kb.nextInt();
        int c = kb.nextInt();
        int[][] arr = new int[r][c];

        // Read matrix elements
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                arr[i][j] = kb.nextInt();
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        // Calculate and print sum of diagonal elements
        for (int i = 0; i < r; i++) {
            int sum = 0;
            for (int j = 0; j < c; j++) {
                if (i == j) {
                    sum += arr[i][j];
                    System.out.print("Case #" + j + ": ");
                    System.out.println(sum + " " + arr[i][j]);
                    System.out.println();
                }
            }
        }
    }
}