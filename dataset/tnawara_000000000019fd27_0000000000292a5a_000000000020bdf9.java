
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
4
3
360 480
420 540
600 660
3
0 1440
1 3
2 4
5
99 150
1 100
100 301
2 5
150 250
2
0 720
720 1440
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(inputStream)));
        PrintWriter out = new PrintWriter(outputStream);
        int t = in.nextInt();
        for (int i = 0; i < t; ++i) {
            Task solver = new Task();
            solver.solve(i + 1, in, out);
        }
        out.close();
    }

    private static class Task {
        static class Schedule {
            int idx;
            int start, end;

            public Schedule(int idx, int start, int end) {
                this.idx = idx;
                this.start = start;
                this.end = end;
            }
        }

        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int n = in.nextInt();
            char[] assign = new char[n];
            Schedule[] schedules = new Schedule[n];
            for (int i = 0; i < n; ++i) {
                schedules[i] = new Schedule(i, in.nextInt(), in.nextInt());
            }
            Arrays.sort(schedules, Comparator.comparing(a -> a.start));
            int j = 0;
            int c = 0;
            for (int i = 0; i < n; ++i) {
                if (j <= schedules[i].start) {
                    assign[schedules[i].idx] = 'J';
                    j = schedules[i].end;
                } else if (c <= schedules[i].start) {
                    assign[schedules[i].idx] = 'C';
                    c = schedules[i].end;
                } else {
                    out.printf("Case %d: IMPOSSIBLE\n", testNumber);
                    return;
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; ++i) {
                sb.append(assign[i]);
            }
            out.printf("Case %d: %s\n", testNumber, sb.toString());
        }
    }
}