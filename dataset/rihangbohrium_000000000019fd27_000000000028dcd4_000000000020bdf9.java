import java.io.*;
import java.util.*;


public class Solution {
    static String solve(int[][] a) {
        String r = "";
        boolean[] c = new boolean[1441];
        boolean[] j = new boolean[1441];

        for (int[] act : a) {
            boolean needJ = false;
            int s = act[0]; int e = act[1];
            for (int i = s; i < e; i++) 
                if (c[i]) needJ = true;
            if (!needJ) {
                for (int i = s; i < e; i++) 
                    c[i] = true;
                r += "C";
            } else {
                for (int i = s; i < e; i++) {
                    if (j[i]) return "IMPOSSIBLE";
                    j[i] = true;
                }
                r += "J";
            }
        }
        return r;
    }

    public static void main(String [] args) throws Exception {
        BufferedReader in = new BufferedReader( new InputStreamReader(System.in) );
        int T = Integer.parseInt( in.readLine() );
        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(in.readLine());
            int[][] a = new int[N][2];

            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(in.readLine());
                a[j][0] = Integer.parseInt(st.nextToken());
                a[j][1] = Integer.parseInt(st.nextToken());
            }

            System.out.println("Case #" + i + ": " + solve(a));
        }
    }
}