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
                    Scanner sc = new Scanner(stdin.readLine());
                    int max = 0, min = N, ones = 0, product = 1, sum = 0;

                    for (int c = 0; c < N; c++) {
                        int current = sc.nextInt();
                        max = Math.max(current, max);
                        min = Math.min(current, min);
                        product *= current;
                        sum += current;
                        V += (r == c) ? current : 0;
                        matrix[r][c] = current;
                        if (current == 1) ones++;
                    }
                    sc.close();

                    if (!isValidRowOrCol(N, max, min, ones, product, sum)) {
                        rr++;
                    }
                }

                for (int c = 0; c < N; c++) {
                    int max = 0, min = N, ones = 0, product = 1, sum = 0;

                    for (int r = 0; r < N; r++) {
                        int current = matrix[r][c];
                        max = Math.max(current, max);
                        min = Math.min(current, min);
                        product *= current;
                        sum += current;
                        if (current == 1) ones++;
                    }

                    if (!isValidRowOrCol(N, max, min, ones, product, sum)) {
                        rc++;
                    }
                }

                System.out.println("Case #" + j + ": " + V + " " + rr + " " + rc);
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("I'll be back! ;)");
        }
    }

    private static boolean isValidRowOrCol(int N, int max, int min, int ones, int product, int sum) {
        int fact = 1, tot = 0;
        for (int i = 2; i <= N; i++) fact *= i;
        for (int i = 1; i <= N; i++) tot += i;

        return product == fact && sum == tot && max == N && min > 1 && ones == 1;
    }
}