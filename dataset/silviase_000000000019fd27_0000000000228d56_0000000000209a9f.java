import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author silviase
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        NestingDepth solver = new NestingDepth();
        solver.solve(1, in, out);
        out.close();
    }

    static class NestingDepth {
        public void solve(int testNumber, Scanner in, PrintWriter out) {

            int numOfTestCase = in.nextInt();
            for (int i = 1; i <= numOfTestCase; i++) {
                StringBuilder sb = new StringBuilder();
                String s = in.next();
                for (int j = 0; j < s.length(); j++) {
                    int dif;
                    if (j == 0) {
                        dif = s.charAt(j) - '0';
                        for (int k = 0; k < dif; k++) {
                            sb.append('(');
                        }
                    } else {
                        dif = s.charAt(j) - s.charAt(j - 1);
                        if (dif > 0) {
                            for (int k = 0; k < dif; k++) {
                                sb.append('(');
                            }
                        } else {
                            for (int k = 0; k < -dif; k++) {
                                sb.append(')');
                            }
                        }
                    }
                    sb.append(s.charAt(j));
                }
                for (int k = 0; k < s.charAt(s.length() - 1) - '0'; k++) {
                    sb.append(')');
                }

                out.printf("Case #%d: %s\n", i, new String(sb));
            }

        }

    }
}

