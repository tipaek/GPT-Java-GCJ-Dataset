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
        Thermometer solver = new Thermometer();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class Thermometer {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int K = in.nextInt();
            int N = in.nextInt();
            int[] X = new int[N];
            int[] T = new int[N];
            for (int i = 0; i < N; i++) {
                X[i] = in.nextInt();
            }
            for (int i = 0; i < N; i++) {
                T[i] = in.nextInt();
            }

            int iMin = N - 1;
            int min = X[0] + K - X[N - 1];
            for (int i = 0; i < N - 1; ++i) {
                int cur = X[i + 1] - X[i];
                if (cur < min) {
                    min = cur;
                    iMin = i;
                }
            }

            int res = 1;
            double lastPoint = X[iMin] + min / 2.0;
            for (int step = 1, j = (iMin + 1) % N; step < N; ++step, j = (j + 1) % N) {
                double dis = X[j] - lastPoint;
                if (dis < 0) dis += K;

                int nextLen = X[(j + 1) % N] - X[j];
                if (nextLen < 0) nextLen += K;

                if (dis > nextLen) {
                    res += 2;
                    lastPoint = X[j] + nextLen / 2.0;
                } else {
                    res++;
                    lastPoint = X[j] + dis;
                }
            }
            double dis = X[iMin] - lastPoint;
            if (dis < 0) dis += K;
            if (Math.abs(2.0 * dis - min) > 0.001) {
                ++res;
            }

            out.println("Case #" + testNumber + ": " + res);
        }

    }
}

