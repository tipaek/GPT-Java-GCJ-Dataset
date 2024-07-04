

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

        public void solve(int k, BufferedReader in) throws IOException {
            String inp[] = in.readLine().split(" ");

            int x = Integer.parseInt(inp[0]);
            int y = Integer.parseInt(inp[1]);
            String[] path = inp[2].split("");
            boolean imp = true;
            int n = path.length;
            int[] vals = new int[n + 1];

            for (int i = 0; i <= n; i++) {
                int b;
                if (i == 0) {
                    b = Math.abs(x) + Math.abs(y);
                } else {
                    switch (path[i - 1]) {
                        case "E" : x = x + 1; break;
                        case "W" : x = x - 1; break;
                        case "N" : y = y + 1; break;
                        case "S" : y = y - 1; break;
                    }
                    b = Math.abs(x) + Math.abs(y);
                }
                vals[i] = b;
            }

            for (int i = 0; i <= n; i++) {
                if (i >= vals[i]) {
                    System.out.println("Case #" + k + ": " + i);
                    imp = false;
                    break;
                }
            }


                if (imp) System.out.println("Case #" + k + ": IMPOSSIBLE");


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