import java.util.*;
import java.io.*;

public class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(next());
        for (int t = 1; t <= T; t++) {
            String s = next();
            int idx = 0;
            boolean prevOne = false;
            String out = "";
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '1') {
                    if (prevOne) {

                    } else {
                        out += "(";
                    }
                    prevOne = true;
                } else {
                    if (prevOne) {
                        out += ")";
                    } else {

                    }
                    prevOne = false;
                }
                out += c;
            }
            if (out.charAt(out.length() - 1) == '1') {
                out += ")";
            }
            System.out.println("Case #" + t + ": " + out);
        }
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }
}
