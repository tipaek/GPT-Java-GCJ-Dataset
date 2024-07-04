import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Solution {

    private void appendC(StringBuilder res, int n, char c) {
        for(char i = 0; i < n; ++i) {
            res.append(c);
        }
    }

    public String solve(String in, int nest) {
        if (in.equals("")) {
            return in;
        }
        char c = findMin(in);
        int newNest = c - '0';
        StringBuilder res = new StringBuilder();
        appendC(res, newNest - nest, '(');
        StringBuilder next = new StringBuilder();
        for(char cr : in.toCharArray()) {
            if (cr != c) {
                next.append(cr);
            }
            else {
                res.append(solve(next.toString(), newNest));
                res.append(c);
                next = new StringBuilder();
            }
        }
        res.append(solve(next.toString(), newNest));
        appendC(res, newNest - nest, ')');
        return res.toString();
    }

    private char findMin(String in) {
        char m = '9';
        for(char c : in.toCharArray()) {
            if (c < m) {
                m = c;
            }
        }
        return m;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        Solution sol = new Solution();
        for (int i = 1; i <= t; ++i) {
            System.out.println("Case #" + i + ": " + sol.solve(in.next(), 0));
        }
    }
}

