import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskA solver = new TaskA();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class TaskA {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int n = in.nextInt();
            String[] pattern = new String[n];
            for (int i = 0; i < n; i++) {
                pattern[i] = in.next();
            }
            Arrays.sort(pattern, (s1, s2) -> s2.length() - s1.length());
            String biggest = pattern[0].replace('*', '\0');
            boolean flag = true;
            for (int i = 1; i < n; ++i) {
                if (!match(biggest, pattern[i])) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                out.println(String.format("Case #%d: %s", testNumber, "*"));
            } else {
                out.println(String.format("Case #%d: %s", testNumber, biggest));
            }
        }

        private boolean match(String word, String pattern) {
            // assuming only one *
            int index = pattern.indexOf('*');
            return word.startsWith(pattern.substring(0, index)) &&
                    word.endsWith(pattern.substring(index + 1));
        }

    }
}

