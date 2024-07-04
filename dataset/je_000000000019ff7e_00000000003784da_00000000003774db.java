import java.math.*;
import java.util.*;
import java.io.*;
import static java.lang.Math.*;
import static java.lang.Integer.*;
import static java.lang.Long.*;
import static java.lang.System.*;


public class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int T = parseInt(br.readLine());

        for (int z=0;z<T;z++) {
            String[] ss = br.readLine().trim().split("\\s+");
            char[] C = ss[0].toCharArray();
            char[] J = ss[1].toCharArray();

            int[][] dp = new int[C.length+1][J.length+1];
            for (int i=0;i<=C.length;i++) {
                for (int j=0;j<=J.length;j++) {
                    dp[i][j] = 999999;
                }
            }
            
            int[][] dir = new int[C.length+1][J.length+1];
            
            for (int i=0;i<=C.length;i++) {
                dp[i][0] = i;
                dir[i][0] = 3;
            }
            for (int j=0;j<=J.length;j++) {
                dp[0][j] = j;
                dir[0][j] = 4;
            }
            dir[0][0] = -1;
            for (int i=0;i<C.length;i++) {
                for (int j=0;j<J.length;j++) {
                    if (C[i] == J[j]) {
                        dp[i+1][j+1] = dp[i][j];
                        dir[i+1][j+1] = 1;
                    } else {
                        dp[i+1][j+1] = dp[i][j] + 1;
                        dir[i+1][j+1] = 2;

                        if (dp[i][j+1] + 1 < dp[i+1][j+1]) {
                            dp[i+1][j+1] = dp[i][j+1] + 1;
                            dir[i+1][j+1] = 3;
                        } else if (dp[i+1][j] + 1 < dp[i+1][j+1]) {
                            dp[i+1][j+1] = dp[i+1][j] + 1;
                            dir[i+1][j+1] = 4;
                        }
                    }
                }
            }
            int r = dp[C.length][J.length] + 1 >> 1;
            out.println("Case #" + (z+1)+": " + go(C.length, J.length, dp, dir, C, J, r));
            // for (int i=0;i<=C.length;i++) {
            //     out.println(Arrays.toString(dp[i]));
            // }
            // out.println();
            // for (int i=0;i<=C.length;i++) {
            //     out.println(Arrays.toString(dir[i]));
            // }
            // out.println("Case #" + (z+1) + ": " + (k-1) + " " + L + " " + R);
        }
    }

    static String go(int x, int y, int[][] dp, int[][] dir, char[] C, char[] J, int r) {
        ArrayList<Character> list = new ArrayList<Character>();
        for (char c : J) list.add(c);
        int acts = 0;
        while(x > 0 || y > 0) {
            int h = dir[x][y];
            if (h == 1) {
                x--;
                y--;
            } else if (h == 2) {
                x--;
                y--;
                list.set(y, C[x]);
                // J[y] = C[x];
                acts++;
            } else if (h == 3) {
                x--;
                list.add(y, C[x]);
                acts++;
            } else if (h == 4) {
                y--;
                // J[y] = ' ';
                list.remove(y);
                acts++;
            }
            if (acts >= r) break;
        }

        StringBuilder sb = new StringBuilder();
        for (char c : list) {
            sb.append(c);
        }
        return sb.toString();
    }
}
