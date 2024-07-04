import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= t; ++i) {
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            int[][] matrix = new int[N][N];
            String result;

            if (K % N == 0) {
                result = "POSSIBLE";
                int shift = K / N;

                for (int r = 0; r < N; r++) {
                    for (int c = 0; c < N; c++) {
                        matrix[r][c] = (c + shift * r) % N + 1;
                    }
                }
            } else {
                result = "IMPOSSIBLE";
            }

            System.out.println("Case #" + i + ": " + result);
            if ("POSSIBLE".equals(result)) {
                for (int[] row : matrix) {
                    for (int val : row) {
                        System.out.print(val + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
}