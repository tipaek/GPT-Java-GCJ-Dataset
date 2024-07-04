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
                    String input = stdin.readLine();
                    Scanner sc = new Scanner(input);
                    int rowProduct = 1, rowSum = 0;

                    for (int c = 0; c < N; c++) {
                        int current = sc.nextInt();
                        if (r == c) V += current;
                        matrix[r][c] = current;
                        rowProduct *= current;
                        rowSum += current;
                    }
                    sc.close();

                    if (!isValid(rowProduct, rowSum, N)) {
                        rr++;
                    }
                }

                for (int c = 0; c < N; c++) {
                    int colProduct = 1, colSum = 0;

                    for (int r = 0; r < N; r++) {
                        int current = matrix[r][c];
                        colProduct *= current;
                        colSum += current;
                    }

                    if (!isValid(colProduct, colSum, N)) {
                        rc++;
                    }
                }

                System.out.println("Case #" + j + ": " + V + " " + rr + " " + rc);
            }
        } catch (Exception e) {
            System.out.println("I'll be back! ;)");
        }
    }

    private static boolean isValid(int product, int sum, int N) {
        int factorial = 1, totalSum = 0;
        for (int i = 1; i <= N; i++) {
            factorial *= i;
            totalSum += i;
        }
        return product == factorial && sum == totalSum;
    }
}