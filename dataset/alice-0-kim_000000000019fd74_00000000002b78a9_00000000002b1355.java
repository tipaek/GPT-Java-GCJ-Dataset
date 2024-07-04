import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            int R = in.nextInt();
            int C = in.nextInt();
            int[][] floor = new int[R][C];
            int sum = 0;
            int eliminated = 0;
            List<int[]> toEliminate = new ArrayList();
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    floor[i][j] = in.nextInt();
                }
            }
            do {
                for (int[] e : toEliminate) {
                    floor[e[0]][e[1]] = -1;
                }
                toEliminate = new ArrayList();
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (floor[i][j] != -1) {
                            sum += floor[i][j];
                            int n = i - 1, s = i + 1, w = j - 1, e = j + 1, c = 0;
                            double avg = 0;
                            while (0 <= n && floor[n][j] == -1) n--;
                            while (R > s && floor[s][j] == -1) s++;
                            while (0 <= w && floor[i][w] == -1) w--;
                            while (C > e && floor[i][e] == -1) e++;
                            if (0 <= n && floor[n][j] != -1) {avg += floor[n][j]; c++;}
                            if (R > s && floor[s][j] != -1) {avg += floor[s][j]; c++;}
                            if (0 <= w && floor[i][w] != -1) {avg += floor[i][w]; c++;}
                            if (C > e && floor[i][e] != -1) {avg += floor[i][e]; c++;}
                            if (c > 0) {
                                avg /= c;
                                if (avg > floor[i][j]) toEliminate.add(new int[]{i, j});
                            }
                        }
                    }
                }
            } while (!toEliminate.isEmpty());
            System.out.printf("Case #%d: %d\n", t, sum);
        }
    }
}