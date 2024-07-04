
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    static int[][] arr = new int[50][50];
    static long[] rows = new long[51];
    static long[] cols = new long[51];
    static int N;
    static int K;
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for (int t = 1; t <= T; ++t) {
            int n = in.nextInt();
            int k = in.nextInt();
            System.out.print("Case #" + t + ": ");
            solve(n, k);
        }
    }

    public static void solve(int n, int k) {
        N = n;
        K = k;
        Arrays.fill(rows, 0);
        Arrays.fill(cols, 0);
        if (!next(0)) {
            System.out.println("IMPOSSIBLE");
        }
    }
    static boolean next(int cur) {
        if (cur == N*N) {
            if (isValid()) {
                print();
                return true;
            } else {
//                print();
                return false;
            }
        }
        int r = cur / N;
        int c = cur % N;
        for (int i=1; i<=N; i++) {
            if (((rows[r] >> i) & 1) == 0
                && ((cols[c] >> i) & 1) == 0) {
                rows[r] |= (1<<i);
                cols[c] |= (1<<i);
                arr[r][c] = i;
                if (next(cur+1)) {
                    return true;
                }
                rows[r] &= ~(1<<i);
                cols[c] &= ~(1<<i);
            }
        }
        return false;
    }

    static boolean isValid() {
        int sum = 0;
        for (int i=0; i<N && sum<K; i++) {
            sum += arr[i][i];
        }
        return sum == K;
    }
    static void print() {
        System.out.println("POSSIBLE");
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}

