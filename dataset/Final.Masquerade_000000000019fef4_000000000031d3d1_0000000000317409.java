

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(in.readLine());
        Solver s = new Solver();
        for (int i = 1; i <= testCount; i++) {
            s.solve(i, in);
        }
    }

    static class Solver {

        int[] coors = {1, 1, -1, -1};
        public void solve(int k, BufferedReader in) throws IOException {
            String inp[] = in.readLine().split(" ");

            int x = Integer.parseInt(inp[0]);
            int y = Integer.parseInt(inp[1]);
            String[] path = inp[2].split("");
            int xy = x + y;
            int n = path.length;

            for (int i = 0; i <= n; i++) {
                if (i >= xy) {
                    System.out.println("Case #" + k + ": " + i);
                    return;
                } else {
                    if (i < path.length)
                    if (path[i].equals("S") || path[i].equals("W")) {
                        --xy;
                    } else {
                        ++xy;
                    }
                }
            }

            System.out.println("Case #" + k + ": IMPOSSIBLE");
        }
    }
}


/*

5
4 4 SSSS
3 0 SNSS
2 10 NSNNSN
0 1 S
2 7 SSSSSSSS


 */