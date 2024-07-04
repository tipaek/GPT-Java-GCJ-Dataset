import java.io.*;
import java.util.*;
class Solution {
    static Scanner sc;
    static void testcase(int no) {

        String s = sc.next();

        StringBuilder outp = new StringBuilder();
        int cur_depth = 0;

        char prev = s.charAt(0);
        for (int i = 0; i < prev - '0'; i++) {
            outp.append('(');
        }
        outp.append(s.charAt(0));
        cur_depth = prev;

        for (int i = 1; i < s.length(); i++) {
            char cur = s.charAt(i);

            if (cur == cur_depth) { outp.append(cur); }
            else if (cur > cur_depth) {
                for (; cur_depth < cur; cur_depth++) {
                    outp.append('(');
                }
                outp.append(cur);
            }
            else {
                for (; cur_depth > cur; cur_depth--) {
                    outp.append(')');
                }
                outp.append(cur);
            }
        }

        for (; cur_depth > '0'; cur_depth--) {
            outp.append(')');
        }
        System.out.format("Case #%d: %s\n", no, outp.toString());

    }
    public static void main(String args[]) {
        sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            testcase(i + 1);
        }
    }
}