import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int N = scanner.nextInt();
            int K = scanner.nextInt();

            if (K % N == 0) {
                System.out.println("Case #" + testCase + ": POSSIBLE");
                int[][] matrix = new int[N][N];
                int[] otherNumbers = new int[N - 1];
                int currentNum = 1;

                for (int j = 0; j < N - 1; j++) {
                    if (currentNum == K / N) {
                        currentNum++;
                    }
                    otherNumbers[j] = currentNum++;
                }

                for (int row = 0; row < N; row++) {
                    for (int col = row; col < row + N; col++) {
                        if (row == col) {
                            matrix[row][col % N] = K / N;
                        } else {
                            matrix[row][col % N] = otherNumbers[col - row - 1];
                        }
                    }
                }

                for (int[] row : matrix) {
                    for (int value : row) {
                        System.out.print(value + " ");
                    }
                    System.out.println();
                }
            } else {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            }
        }

        scanner.close();
    }
}