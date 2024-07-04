import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {

    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solveCases();
        solution.close();
    }

    private void solveCases() {
        int t = readInt();
        for (int i = 1; i <= t; i++) {
            pw.println("Case #" + i + ": " + solve());
        }
    }

    private String solve() {
        int[] arr = readIntArr();
        long x = arr[0];
        long y = arr[1];

        boolean xf = x < 0;
        boolean yf = y < 0;
        x = Math.abs(x);
        y = Math.abs(y);

        StringBuilder s = new StringBuilder();
        int prv = -1;

        while (x > 0 && y > 0) {
            if (x % 2 + y % 2 != 1) return "IMPOSSIBLE";
            if (x % 2 == 1) {
                if (prv == 1) s.append("-");
                prv = 0;
                s.append('E');
                x ^= 1;
                y /= 2;
            } else if (y % 2 == 1) {
                if (prv == 0) s.append("-");
                prv = 1;
                s.append('N');
                y ^= 1;
                x /= 2;
            } else {
                return "IMPOSSIBLE";
            }
        }

        int ln = s.length() - 1;
        StringBuilder sn = new StringBuilder();
        for (int i = 0; i < ln; i++) {
            if (s.charAt(i) == '-') continue;
            if (s.charAt(i + 1) == '-') {
                sn.append(s.charAt(i) == 'E' ? 'W' : 'S');
            } else {
                sn.append(s.charAt(i));
            }
        }
        if (ln > -1 && s.charAt(ln) != '-') {
            sn.append(s.charAt(ln));
        }
        s = sn;

        while (x > 0) {
            if (x % 2 == 0) return "IMPOSSIBLE";
            s.append('E');
            x /= 2;
        }

        while (y > 0) {
            if (y % 2 == 0) return "IMPOSSIBLE";
            s.append('N');
            y /= 2;
        }

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (xf) {
                if (s.charAt(i) == 'E') {
                    ret.append('W');
                    continue;
                } else if (s.charAt(i) == 'W') {
                    ret.append('E');
                    continue;
                }
            }
            if (yf) {
                if (s.charAt(i) == 'N') {
                    ret.append('S');
                    continue;
                } else if (s.charAt(i) == 'S') {
                    ret.append('N');
                    continue;
                }
            }
            ret.append(s.charAt(i));
        }
        return ret.toString();
    }

    private void close() {
        pw.close();
    }

    private String readLine() {
        try {
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private int readInt() {
        return Integer.parseInt(readLine());
    }

    private int[] readIntArr() {
        StringTokenizer st = new StringTokenizer(readLine());
        int n = st.countTokens();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        return arr;
    }
}