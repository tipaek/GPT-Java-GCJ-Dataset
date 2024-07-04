

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private int solve(Scanner in) {
        int r = in.nextInt();
        int c = in.nextInt();
        double cmp[][] = new double[r][c];
        int elim[][] = new int[r][c];
        for(int i = 0; i < r; ++i) {
            for(int j = 0; j < c; ++j) {
                cmp[i][j] = in.nextInt();
                elim[i][j] = 1;
            }
        }
        int res = 0;
        boolean stop = false;
        int dirs [][] = {{1, 0},{0,1},{-1,0},{0,-1}};
        while (!stop) {
            stop = true;
            int ir = 0;
            for(int i = 0; i < r; ++i) {
                for(int j = 0; j < c; ++j) {
                    ir += cmp[i][j];
                    if (cmp[i][j] == 0) {
                        continue;
                    }
                    double s = 0;
                    int cnt = 0;
                    for(int d = 0; d < 4; ++d) {
                        int y = i, x = j;
                        while (y >= 0 && y < r && x >= 0 && x < c) {
                            if ((x != j || y != i) && cmp[y][x] > 0) {
                                cnt++;
                                s += cmp[y][x];
                                break;
                            }
                            x += dirs[d][0];
                            y += dirs[d][1];
                        }
                    }
                    if (cnt > 0) {
                        s /= cnt;
                        if (s > cmp[i][j]) {
                            elim[i][j] = 0;
                            stop = false;
                        }
                    }
                }
            }
            res += ir;
            for(int i = 0; i < r; ++i) {
                for (int j = 0; j < c; ++j) {
                    cmp[i][j] *= elim[i][j];
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        Solution sol = new Solution();
        for (int i = 1; i <= t; ++i) {
            System.out.println("Case #" + i + ": " + sol.solve(in));
        }
    }
}
