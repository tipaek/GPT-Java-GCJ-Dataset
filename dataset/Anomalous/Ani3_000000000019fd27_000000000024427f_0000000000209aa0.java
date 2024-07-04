import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= t; i++) {
            int trace = 0;
            String[] inputs = scanner.nextLine().split("\\s+");
            int n = Integer.parseInt(inputs[0]);
            int k = Integer.parseInt(inputs[1]);
            int center = k / n;
            int[][] matrix = new int[n][n];

            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    int p = n - row;
                    int value = ((p + col) % n) + center;
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