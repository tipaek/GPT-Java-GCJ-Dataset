import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(stdin.readLine());

            for (int j = 1; j <= T; j++) {
                int N = Integer.parseInt(stdin.readLine());
                int[][] matrix = new int[N][N];
                int V = 0, rc = 0, rr = 0;

                for (int r = 0; r < N; r++) {
                    String[] rowValues = stdin.readLine().split(" ");
                    int max = 0, min = N, product = 1, sum = 0;

                    for (int c = 0; c < N; c++) {
                        int current = Integer.parseInt(rowValues[c]);
                        max = Math.max(current, max);
                        min = Math.min(current, min);
                        product *= current;
                        sum += current;
                        if (r == c) V += current;
                        matrix[r][c] = current;
                    }

                    int expectedProduct = factorial(N);
                    int expectedSum = sumOfFirstNNumbers(N);

                    if (product != expectedProduct || sum != expectedSum || max != N || min > 1) {
                        rr++;
                    }
                }

                for (int c = 0; c < N; c++) {
                    int max = 0, min = N, product = 1, sum = 0;
                    for (int r = 0; r < N; r++) {
                        int current = matrix[r][c];
                        max = Math.max(current, max);
                        min = Math.min(current, min);
                        product *= current;
                        sum += current;
                    }

                    int expectedProduct = factorial(N);
                    int expectedSum = sumOfFirstNNumbers(N);

                    if (product != expectedProduct || sum != expectedSum || max != N || min > 1) {
                        rc++;
                    }
                }

                System.out.println("Case #" + j + ": " + V + " " + rr + " " + rc);
            }
        } catch (Exception e) {
            System.out.println("I'll be back! ;)");
        }
    }

    private static int factorial(int n) {
        int fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    private static int sumOfFirstNNumbers(int n) {
        return n * (n + 1) / 2;
    }
}