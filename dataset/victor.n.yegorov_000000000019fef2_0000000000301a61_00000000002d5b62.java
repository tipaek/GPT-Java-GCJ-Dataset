import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= t; ++i) {
            String output = solve(sc);
            sb.append("Case #").append(i).append(": ").append(output).append("\n");
        }
        System.out.print(sb);
    }

    private static String solve(Scanner sc) {
        final int x = sc.nextInt(), y = sc.nextInt();
        return solve(x, y);
    }

    private static final String U = "IMPOSSIBLE", S = "S", E = "E", N = "N", W = "W";

    private static String solve(int x, int y) {
        if ((x == 0) && (y == 0)) {
            return "";
        }
        if (x == 0 && y == 1) {
            return N;
        }
        if (x == 0 && y == -1) {
            return S;
        }
        if (x == 1 && y == 0) {
            return E;
        }
        if (x == -1 && y == 0) {
            return W;
        }
        int a = x & 1, b = y & 1;
        if (a == b) {
            return U;
        }

        if (a == 1) {
            String w = solve((x + 1) >> 1, y >> 1);
            String e = solve((x - 1) >> 1, y >> 1);
            return w.equals(U) ? E + e : W + w;
        } else {
            String s = solve(x >> 1, (y + 1) >> 1);
            String n = solve(x >> 1, (y - 1) >> 1);
            return s.equals(U) ? N + n : S + s;
        }
    }
}