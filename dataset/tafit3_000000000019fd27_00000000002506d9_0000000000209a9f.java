import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    BufferedReader rd;

    Solution() throws IOException {
        rd = new BufferedReader(new InputStreamReader(System.in));
        compute();
    }

    private void compute() throws IOException {
        int n = pint();
        for(int i=1;i<=n;i++) {
            out("Case #" + i + ": " + solve());
        }
    }

    private String solve() throws IOException {
        char[] s = rd.readLine().toCharArray();
        int level = 0;
        StringBuilder buf = new StringBuilder();
        for(char c: s) {
            int expectedLevel = c-'0';
            if(expectedLevel > level) {
                append(buf, expectedLevel - level, '(');
            } else if(expectedLevel < level) {
                append(buf, level - expectedLevel, ')');
            }
            level = expectedLevel;
            buf.append(c);
        }
        append(buf, level, ')');
        return buf.toString();
    }

    private void append(StringBuilder buf, int count, char c) {
        for(int i=0;i<count;i++) {
            buf.append(c);
        }
    }

    private int pint() throws IOException {
        return pint(rd.readLine());
    }

    private int pint(String s) {
        return Integer.parseInt(s);
    }

    private static void out(Object x) {
        System.out.println(x);
    }

    public static void main(String[] args) throws IOException {
        new Solution();
    }
}
