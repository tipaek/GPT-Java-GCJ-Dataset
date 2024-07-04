import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
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
        Task solver = new Task();
        int ntests = in.nextInt();
        int b = in.nextInt();
        for (int i=1;i<=ntests;i++)
        solver.solve(b, in, out);
        out.close();
    }

    static class Task {
        public void solve(int B, Scanner in, PrintWriter out) {

            int[] a = new int[B];
            int L = 0, R = B - 1;

            int num = 0;
            int eq = -1, diff = -1;
            while (L < R) {
                if (num % 10 == 9) {
                    num++;
                    out.println(1);
                    out.flush();
                    in.nextInt();
                }
                if (num != 0 && num % 10 == 0) {
                    if (eq >= 0) {
                        num++;
                        out.println(eq + 1);
                        out.flush();
                        int x = in.nextInt();
                        if (x != a[eq]) {
                            for (int i = 0; i < B; i++) {
                                a[i] = 1 - a[i];
                            }
                        }
                    }
                    if (diff >= 0) {
                        num++;
                        out.println(diff + 1);
                        out.flush();
                        int x = in.nextInt();
                        if (x != a[diff]) {
                            for (int i = 0; i < B - i - 1; i++) {
                                int t = a[i];
                                a[i] = a[B - i - 1];
                                a[B - i - 1] = t;
                            }
                        }
                    }
                }
                num++;
                out.println(L+1);
                out.flush();
                a[L++] = in.nextInt();
                if (L < R) {
                    num++;
                    out.println(R+1);
                    a[R--] = in.nextInt();

                    if (a[L - 1] == a[R + 1]) {
                        eq = L - 1;
                    } else {
                        diff = L - 1;
                    }
                }
            }

            String s = "";
            for (int i = 0; i < B; i++) {
                s += a[i] + "";
            }
            out.println(s);
            out.flush();
            in.next();
        }

    }
}

