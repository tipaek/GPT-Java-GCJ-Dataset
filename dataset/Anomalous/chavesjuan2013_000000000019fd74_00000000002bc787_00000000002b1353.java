import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {

    // Calculate the base-2 logarithm of a number
    static int log2(int N) {
        return (int) (Math.log(N) / Math.log(2));
    }

    // Calculate binomial coefficient n choose k
    static int choose(int n, int k) {
        if (k == 0 || k == n)
            return 1;
        return choose(n - 1, k - 1) + choose(n - 1, k);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int iter = 0;

        while (iter < T) {
            System.out.println("Case #" + (iter + 1) + ":");
            int N = Integer.parseInt(br.readLine());
            int total = 0;
            int steps = 0;

            int rowsToTraverse = log2(N + 1);

            for (int i = 1; i <= rowsToTraverse; ++i) {
                if (i % 2 == 0) {
                    for (int j = 1; j <= i; ++j) {
                        System.out.println(i + " " + j);
                        total += choose(i, j);
                        steps++;
                    }
                } else {
                    for (int j = i; j >= 1; --j) {
                        System.out.println(i + " " + j);
                        total += choose(i, j);
                        steps++;
                    }
                }
            }

            if (N < 962) {
                int diff = (int) Math.pow(2, rowsToTraverse) - 1;
                diff = N - diff;

                for (int k = 0; k < diff; ++k) {
                    if (rowsToTraverse % 2 == 1) {
                        System.out.println((rowsToTraverse + k + 1) + " " + 1);
                        total += choose((rowsToTraverse + k + 1), 1);
                        steps++;
                    } else {
                        System.out.println((rowsToTraverse + k + 1) + " " + (rowsToTraverse + k + 1));
                        total += choose((rowsToTraverse + k + 1), (rowsToTraverse + k + 1));
                        steps++;
                    }
                }
            } else {
                for (int i = 9; i <= 38; ++i) {
                    System.out.println(i + " " + 2);
                }

                int diff = N - 960;
                for (int k = 39; k < diff + 39; ++k) {
                    System.out.println(k + " " + 1);
                    total += choose((rowsToTraverse + k + 1), (rowsToTraverse + k + 1));
                    steps++;
                }
            }
            iter++;
        }
    }
}