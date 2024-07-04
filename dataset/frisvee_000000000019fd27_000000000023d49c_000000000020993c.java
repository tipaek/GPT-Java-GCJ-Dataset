import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();

        int[][] M = new int[100][];
        for (int i = 0; i < 100; i++) {
            M[i] = new int[100];
        }
        Set<Integer> ROW_SET = new HashSet<>();
        Set<Integer> COL_SET = new HashSet<>();

        for (int t = 1; t <= T; t++) {
            int N = in.nextInt();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    M[i][j] = in.nextInt();
                }
            }

            int trace = 0, rows = 0, cols = 0;
            for (int i = 0; i < N; i++) {
                trace += M[i][i];

                ROW_SET.clear(); COL_SET.clear();
                for (int j = 0; j < N; j++) {
                    ROW_SET.add(M[i][j]);
                    COL_SET.add(M[j][i]);
                }

                if (ROW_SET.size() != N) {
                    rows++;
                }

                if (COL_SET.size() != N) {
                    cols++;
                }
            }

            System.out.println("Case #" + t + ": " + trace + " " + rows + " " + cols);
        }

        in.close();
    }
}