import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = sc.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int t = 1; t <= T; ++t) {
            int N = sc.nextInt();
            int[][] square = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    square[i][j] = sc.nextInt();
                }
            }
            int trace = 0;
            for (int i = 0; i < N; i++) {
                trace += square[i][i];
            }
            int repeatRows = 0;
            for (int i = 0; i < N; i++) {
                boolean[] seen = new boolean[N+1];
                for (int j = 0; j < N; j++) {
                    if (seen[square[i][j]]) {
                        repeatRows++;
                        break;
                    } else {
                        seen[square[i][j]] = true;
                    }
                }
            }
            int repeatCols = 0;
            for (int j = 0; j < N; j++) {
                boolean[] seen = new boolean[N+1];
                for (int i = 0; i < N; i++) {
                    if (seen[square[i][j]]) {
                        repeatCols++;
                        break;
                    } else {
                        seen[square[i][j]] = true;
                    }
                }
            }
            System.out.printf("Case # %d: %d %d %d\n", t, trace, repeatRows, repeatCols);
        }
    }
}