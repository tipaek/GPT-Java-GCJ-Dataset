import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        int[] M;
        boolean[] visited;
        int k, r, c;

        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            k = in.nextInt();
            M = new int[n];
            for (int j = 0; j < n; j++) M[j] = j + 1;
            int d;
            if (k % n == 0) {
                d = k / n - 1;
                System.out.println("Case #" + i + ": " + "POSSIBLE");
                for (int x = 0; x < n; x++) {
                    int temp = d + n-x;
                    for (int j = 0; j < n; j++) {
                        System.out.print(M[(temp + j) % n]);
                        if (j != n - 1) {
                            System.out.print(" ");
                        }
                    }
                    System.out.println();
                }

            } else if (n > 2 && k == (n * (n + 1) >> 1)) {
                d = 0;
                System.out.println("Case #" + i + ": " + "POSSIBLE");
                for (int x = 0; x < n; x++) {
                    int temp = d + x;
                    for (int j = 0; j < n; j++) {
                        System.out.print(M[(temp + j) % n]);
                        if (j != n - 1) {
                            System.out.print(" ");
                        }
                    }
                    System.out.println();
                }
            } else {
                System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
            }


        }
    }
}
