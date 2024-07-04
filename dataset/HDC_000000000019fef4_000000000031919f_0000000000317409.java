import java.lang.*;
import java.io.*;
import java.util.*;
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nt = Integer.parseInt(br.readLine());
        for (int t = 1; t <= nt; ++t) {
            String[] data = br.readLine().split("\\s+");
            int X = Integer.parseInt(data[0]), Y = Integer.parseInt(data[1]);
            char[] path = data[2].toCharArray();
            int time = 0;
            for (char c : path) {
                if ('N' == c) Y++;
                else if ('S' == c) Y--;
                else if ('W' == c) X--;
                else if ('E' == c) X++;
                time++;
                if (time >= Math.abs(X) + Math.abs(Y)) break;
            }
            System.out.format("Case #%d: %s\n", t, time >= Math.abs(X) + Math.abs(Y) ? "" + time : "IMPOSSIBLE");
        }
        br.close();
    }
}
