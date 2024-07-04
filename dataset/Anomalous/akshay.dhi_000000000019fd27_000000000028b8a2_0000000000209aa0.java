import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int level = 1;

        while (t-- > 0) {
            boolean found = false;
            StringTokenizer str = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(str.nextToken());
            int k = Integer.parseInt(str.nextToken());

            for (int i = 1; i <= N; i++) {
                if (i * N == k) {
                    System.out.println("Case #" + level + ": POSSIBLE");
                    printMatrix(N, i);
                    found = true;
                    break;
                }
            }

            if (!found) {
                for (int j = 1; j <= N; j++) {
                    int sum = 0;
                    for (int i = 0; i < N; i++) {
                        int x = (i + i + j) % N;
                        if (x == 0) x = N;
                        sum += x;
                    }
                    if (sum == k) {
                        System.out.println("Case #" + level + ": POSSIBLE");
                        printShiftedMatrix(N, j);
                        found = true;
                        break;
                    }
                }
            }

            if (!found) {
                System.out.println("Case #" + level + ": IMPOSSIBLE");
            }

            level++;
        }
    }

    private static void printMatrix(int N, int start) {
        int xx = start;
        for (int ci = 0; ci < N; ci++) {
            for (int cj = 0; cj < N; cj++) {
                int ans = xx % N;
                if (ans == 0) {
                    xx = N;
                } else {
                    xx = ans;
                }
                System.out.print(xx + " ");
                xx++;
            }
            xx = xx - N;
            System.out.println();
        }
    }

    private static void printShiftedMatrix(int N, int shift) {
        for (int ci = 0; ci < N; ci++) {
            for (int cj = 0; cj < N; cj++) {
                int x = (ci + cj + shift) % N;
                if (x == 0) x = N;
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}