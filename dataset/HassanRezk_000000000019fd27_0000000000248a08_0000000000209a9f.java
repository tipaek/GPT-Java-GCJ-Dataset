import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import static java.lang.String.format;

public class Solution {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String... args) throws IOException {
        int cases = Integer.parseInt(in.readLine());
        for(int caseI = 1; caseI <= cases; ++caseI) {
            char[] chrs = in.readLine().toCharArray();
            String t = solve(chrs);
            out.write(format("Case #%d: %s\n", caseI, t));
        }
        in.close();
        out.close();
    }

    private static String solve(char[] chrs) {
        int i = 0;
        int currentDepth = 0;
        StringBuilder t = new StringBuilder();
        while(i < chrs.length) {
            int digitDepth = (int) chrs[i] - (int) '0';
            while(digitDepth > currentDepth) {
                t.append("(");
                ++currentDepth;
            }
            while(digitDepth < currentDepth) {
                t.append(")");
                --currentDepth;
            }
            char c = chrs[i];
            while(i < chrs.length && chrs[i] == c) {
                t.append(c);
                ++i;
            }
        }
        while(currentDepth > 0) {
            t.append(")");
            --currentDepth;
        }
        return t.toString();
    }

}
