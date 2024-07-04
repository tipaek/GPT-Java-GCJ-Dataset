import java.io.*;
import java.util.*;
import java.math.*;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int x = 1; x <= t; ++x) {
            int N = in.nextInt();
            int K = in.nextInt();
            String res = solve(N, K);
            System.out.println("Case #" + x + ": " + res);
        }
    }

    public static String solve(int N, int K) {
        if(K % N == 0) {

            StringBuilder sb = new StringBuilder("POSSIBLE");

            int x = K / N;
            int matrix[][] = new int[N][N];

            for(int i = 0, offset = 0; i < N; i++) {
                matrix[i][i] = x;
                if(i + 1 == x) {
                    continue;
                }

                offset++;
                for(int j = 0; j < N; j++) {
                    matrix[j][(j + offset) % N] = i + 1;
                }
            }

            // print matrix
            for(int i = 0; i < N; i++) {
                sb.append('\n');
                for(int j = 0; j < N; j++) {
                    sb.append(matrix[i][j]);
                }
            }

            return sb.toString();
        } else {
            return "IMPOSSIBLE";
        }
    }
}