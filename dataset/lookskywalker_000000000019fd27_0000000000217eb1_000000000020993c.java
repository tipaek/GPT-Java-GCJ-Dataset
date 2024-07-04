import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        int T = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int t = 1; t <= T; ++t) {
            int N = in.nextInt();

            int[][] M = new int[N][N];
            for (int rowMatrix = 0; rowMatrix < N; ++rowMatrix) {
                for (int cMatrix = 0; cMatrix < N; ++cMatrix) {
                    M[rowMatrix][cMatrix] = 0;
                }
            }

            int k = 0;
            int r = 0;
            int c = 0;

            for (int rMatrix = 0; rMatrix < N; rMatrix++) {
                List<Integer> row = new ArrayList<>(N);
                for (int cMatrix = 0; cMatrix < N; cMatrix++) {
                    int m = in.nextInt();
                    if (cMatrix == rMatrix) {
                        k += m;
                    }

                    if (m < 1 || m > N) {
                        r++;
                        c++;
                    }

                    M[rMatrix][cMatrix] = m;

                    row.add(m);

                    if (rMatrix == N-1) {
                        List<Integer> column = new ArrayList<>(N);
                        for (int i = 0; i < N; i++) {
                            column.add(M[i][cMatrix]);
                        }
                        List<Integer> columnx = column.stream().distinct().collect(Collectors.toList());
                        if (columnx.size() != column.size()) {
                            c++;
                        }
                    }
                }
                List<Integer> rowx = row.stream().distinct().collect(Collectors.toList());
                if (rowx.size() != row.size()) {
                    r++;
                }
            }

            String res = "Case #" + t + ": " + k + " " + r + " " + c;
            System.out.println(res);
        }
    }
}