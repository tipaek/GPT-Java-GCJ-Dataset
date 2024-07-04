import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String[] input = scanner.nextLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int K = Integer.parseInt(input[1]);

            int[][] matrix = new int[N][N];
            boolean[][] filled = new boolean[N][N];
            boolean possible = false;

            for (int i = 1; i <= N; i++) {
                int diagonalSum = 0;

                for (int j = 0; j < N; j++) {
                    matrix[j][j] = i;
                    diagonalSum += matrix[j][j];
                    filled[j][i - 1] = true;
                }

                if (diagonalSum == K) {
                    possible = true;

                    for (int row = 0; row < N; row++) {
                        for (int col = 0; col < N; col++) {
                            if (!filled[row][col]) {
                                matrix[row][col] = Math.abs(row + col - i);
                                filled[row][col] = true;
                            }
                        }
                    }
                    break;
                }
            }

            if (possible) {
                System.out.println("Case #" + caseNumber + ": POSSIBLE");
            } else {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }
        }
    }
}