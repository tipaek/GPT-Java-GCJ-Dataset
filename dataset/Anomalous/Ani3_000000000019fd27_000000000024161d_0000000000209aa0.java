import java.util.Scanner;

public class Indi {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine().trim());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            String[] input = scanner.nextLine().split("\\s+");
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);
            int center = k / n;
            int[][] matrix = new int[n][n];
            int trace = 0;

            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    int position = (n - row + col) % n;
                    int value = position + center;
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
                System.out.println("Case #" + testCase + ": POSSIBLE");
                for (int[] row : matrix) {
                    for (int val : row) {
                        System.out.print(val + " ");
                    }
                    System.out.println();
                }
            } else {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            }
        }
    }
}