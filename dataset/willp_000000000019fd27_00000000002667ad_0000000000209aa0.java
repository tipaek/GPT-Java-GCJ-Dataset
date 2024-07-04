import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int _t = 1; _t <= t; ++_t) {
            System.out.println("Case #" + _t + ": " + solve(in));
        }
    }

    static String solve(Scanner in) {
        int n = in.nextInt();
        int k = in.nextInt();
        int val = -1;
        for (int i = 1; i <= n && val == -1; i++) {
            if (i*n == k) {
                val = i;
            }
        }
        if (val == -1) return "IMPOSSIBLE";
        StringBuilder s = new StringBuilder("POSSIBLE\n");

        int[] firstRow = new int[n];
        firstRow[0] = val;
        int num = 1;
        for (int i = 1; i < n; i++) {
            if (num == val) num++;
            firstRow[i] = num++;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
               s.append(firstRow[(j-i+n)%n] + " ");
            }
            if (i != n-1) s.append("\n");
        }

        return s.toString();
    }
}
