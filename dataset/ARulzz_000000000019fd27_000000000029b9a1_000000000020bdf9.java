/*
https://codingcompetitions.withgoogle.com/codejam/round/000000000019fd27/000000000020bdf9

4
3
360 480
420 540
600 660
3
0 1440
1 3
2 4
5
99 150
1 100
100 301
2 5
150 250
2
0 720
720 1440

out:
Case #1: CJC
Case #2: IMPOSSIBLE
Case #3: JCCJJ
Case #4: CC
*/

import java.util.*;
import java.io.*;

class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        
        for (int a0 = 1; a0 <= t; a0++) {
            int n = in.nextInt();
            int times[][] = new int[n][2];

            for (int i = 0; i < n; i++) {
                times[i][0] = in.nextInt();
                times[i][1] = in.nextInt();
            }
            
            System.out.println("Case #" + a0 + ": " + getResult(times));
        }
    }

    private static String getResult(int[][] times) {
        Arrays.sort(times, (r1, r2) -> Integer.compare(r1[0], r2[0]));
        
        StringBuilder sb = new StringBuilder(times.length);
        int c = -1;
        int j = -1;

        for (int i = 0; i < times.length; i++) {
            int start = times[i][0];
            int end = times[i][1];

            if (start >= c) {
                c = end;
                sb.append("C");
            }
            else if (start >= j) {
                j = end;
                sb.append("J");
            }
            else return "IMPOSSIBLE";
        }

        return sb.toString();
    }
}
