import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= t; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);
            int center = k / n;
            int[][] matrix = new int[n][n];
            int trace = 0;

            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    int value = ((n - row + col) % n) + center;
                    if (value > n) {
                        value -= n;
                    }
                    matrix[row][col] = value;
                    if (row == col) {
                        trace += value;
                    }
                }
            }

            if (trace == k) {
                System.out.println("Case #" + i + ": POSSIBLE");
                for (int[] row : matrix) {
                    for (int val : row) {
                        System.out.print(val + " ");
                    }
                    System.out.println();
                }
            } else {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }
        }
    }
}