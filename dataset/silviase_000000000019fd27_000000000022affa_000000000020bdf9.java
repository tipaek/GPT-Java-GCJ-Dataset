import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
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
        ParentingPartneringReturns solver = new ParentingPartneringReturns();
        solver.solve(1, in, out);
        out.close();
    }

    static class ParentingPartneringReturns {
        public void solve(int testNumber, Scanner in, PrintWriter out) {

            int numOfTestCase = in.nextInt();
            for (int i = 1; i <= numOfTestCase; i++) {
                int numOfAction = in.nextInt();
                char[] ans = new char[numOfAction];
                int[] acc = new int[1441];
                boolean[] c = new boolean[1441];
                int[] l = new int[numOfAction];
                int[] r = new int[numOfAction];
                boolean flag = true;
                Arrays.fill(c, false);
                for (int j = 0; j < numOfAction; j++) {
                    l[j] = in.nextInt();
                    r[j] = in.nextInt();
                    boolean cdo = true;
                    for (int k = l[j]; k < r[j]; k++) {
                        if (c[k]) {
                            cdo = false;
                            break;
                        }
                    }

                    if (cdo) {
                        for (int k = l[j]; k < r[j]; k++) {
                            c[k] = true;
                        }
                        ans[j] = 'C';
                    } else {
                        acc[l[j]]++;
                        acc[r[j]]--;
                        ans[j] = 'J';
                    }
                }

                for (int j = 1; j < 1441; j++) {
                    acc[j] = acc[j] + acc[j - 1];
                    if (acc[j] >= 2) {
                        flag = false;
                    }
                }

                if (flag) {
                    out.printf("Case #%d: %s\n", i, new String(ans));
                } else {
                    out.printf("Case #%d: IMPOSSIBLE\n", i);
                }
            }


        }

    }
}

