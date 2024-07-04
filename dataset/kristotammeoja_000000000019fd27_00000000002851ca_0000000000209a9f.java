import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(in.readLine());
        for (int i = 0; i < t; ++i) {
            solve(i+1, in);
        }
    }

    private static void solve(int test_nr, BufferedReader in) throws IOException {
        String row = in.readLine();
        int n = row.length();
        int[] a = new int[n];
        for (int i = 0; i < n; ++i)
            a[i] = Integer.parseInt(row.substring(i, i+1));

        String res = solve(a);

        System.out.println(String.format("Case #%d: %s", test_nr, res));
    }

    static int[][][] x;
    static int[][][] how;
    private static String solve(int[] a) {
        int n = a.length;
        x = new int[n][n+1][10];
        how = new int[n][n+1][10];
        int best_len = solve(a, 0, n, 0);
        //System.out.println(">>> " + best_len);
        StringBuffer sb = new StringBuffer();
        build(sb, 0, n, 0);
        return sb.toString();
    }

    private static void build(StringBuffer sb, int start, int len, int depth) {
        int command = how[start][len][depth];
        //System.out.println(String.format("Command %d %d %d %d", start, len, depth, command));
        if (command == 0) {
            sb.append("" + depth);
        } else if (command < 0) {
            sb.append("(");
            build(sb, start, len, depth +1);
            sb.append(")");
        } else {
            int half_len = command;
            build(sb, start, half_len, depth);
            build(sb, start + half_len, len - half_len, depth);
        }
    }

    private static int solve(int[] a, int start, int len, int depth) {
        if (depth > a[start]) return -1;
        if (x[start][len][depth] != 0) return x[start][len][depth];
        if (len == 1 && depth == a[start]) {
            int res = 1;
            x[start][len][depth] = res;
            return res;
        }

        int best_len = Integer.MAX_VALUE;
        int best = 0;

        // add parenthesis now
        {
            int option = solve(a, start, len, depth+1);
            //System.out.println(String.format("try %d %d %d -> %d", start, len, depth+1, option));
            if (option > 0) {
                int option_len = 2 + option;
                if (option_len < best_len) {
                    best_len = option_len;
                    best = -1;
                }
            }
        }

        // concat
        if (len > 1) {
            for (int half_len = 1; half_len < len; ++half_len) {
                int option_1 = solve(a, start, half_len, depth);
                int option_2 = solve(a, start + half_len, len - half_len, depth);
                if (option_1 > 0 && option_2 > 0) {
                    //System.out.println(String.format("try H %d %d %d -> %d", start, len, half_len, option_1 + option_2));
                    int option_len = option_1 + option_2;
                    if (option_len < best_len) {
                        best_len = option_len;
                        best = half_len;
                    }
                }
            }
        }

        if (best_len == Integer.MAX_VALUE) best_len = -1;
        x[start][len][depth] = best_len;
        how[start][len][depth] = best;
        //System.out.println(String.format("Best %d %d %d %d", start, len, depth, best));
        return best_len;
    }
}
