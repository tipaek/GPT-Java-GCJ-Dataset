import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int testCase = input.nextInt();

        for (int testNumber = 1; testNumber <= testCase; testNumber++) {
            pw.print("Case #" + testNumber + ": ");
            solve(input, pw);
            pw.println();
        }
        pw.close();
    }

    public static void solve(Scanner input, PrintWriter pw) throws IOException {
        int n = input.nextInt();
        Schedule[] schedules = new Schedule[n];
        char[] ans = new char[n];
        for (int i = 0; i < n; i++) {
            schedules[i] = new Schedule(input.nextInt(), input.nextInt(), i);
        }
        Arrays.sort(schedules);
        Schedule c = schedules[0];
        ans[schedules[0].idx] = 'C';
        Schedule d = null;
        for (int i = 1; i < n; i++) {
            if (isOverlap(c, schedules[i])) {
                if (d == null) {
                    d = schedules[i];
                    ans[schedules[i].idx] = 'J';
                } else if (isOverlap(d, schedules[i])) {
                    pw.print("IMPOSSIBLE");
                    return;
                } else {
                    d = schedules[i];
                    ans[schedules[i].idx] = 'J';
                }
            } else {
                c = schedules[i];
                ans[c.idx] = 'C';
            }
        }
        pw.print(new String(ans));
    }

    public static boolean isOverlap(Schedule a, Schedule b) {
        return a.end > b.start && a.start < b.end;
    }

    public static class Schedule implements Comparable<Schedule> {
        int start, end, idx;

        public Schedule(int start, int end, int idx) {
            this.start = start;
            this.end = end;
            this.idx = idx;
        }

        @Override
        public int compareTo(Schedule o) {
            if (o.start == start) return end - o.end;
            return start - o.start;
        }
    }

    public static class Scanner {
        private BufferedReader bufferedReader;
        private StringTokenizer stk;

        public Scanner(InputStream inputStream) {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        }

        public int nextInt() throws IOException {
            nullOrGet();
            return Integer.parseInt(stk.nextToken());
        }

        public long nextLong() throws IOException {
            nullOrGet();
            return Long.parseLong(stk.nextToken());
        }

        public String next() throws IOException {
            nullOrGet();
            return stk.nextToken();
        }

        private StringTokenizer nullOrGet() throws IOException {
            if (stk == null || !stk.hasMoreTokens()) {
                stk = new StringTokenizer(bufferedReader.readLine());
            }
            return stk;
        }
    }

}
