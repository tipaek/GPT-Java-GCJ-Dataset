import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader in;
    public static void main(String[] args) throws Exception {
        in = new BufferedReader(
                new InputStreamReader(System.in)
        );
        int T = Integer.parseInt(in.readLine());
        for (int x = 0; x++ < T;) {
            int N = Integer.parseInt(in.readLine());
            String[] P = new String[N];
            for (int i = 0; i < N; i++) {
                P[i] = in.readLine();
            }
            String y = solve(N, P);
            System.out.printf("Case #%d: %s\n", x, y);
        }
    }

    static String solve(int N, String[] P) {
        String prefix = "", suffix = "";
        for (String p : P) {
            String[] tok = (p+"*$").split("\\*");
            if (!prefix.startsWith(tok[0]) && !tok[0].startsWith(prefix))
                return "*";
            if (!suffix.endsWith(tok[1]) && !tok[1].endsWith(suffix))
                return "*";
            if (tok[0].length() > prefix.length())
                prefix = tok[0];
            if (tok[1].length() > suffix.length())
                suffix = tok[1];
        }
        if (prefix.length() + suffix.length() > 10000)
            return "*";
        return prefix + suffix;
    }
}
