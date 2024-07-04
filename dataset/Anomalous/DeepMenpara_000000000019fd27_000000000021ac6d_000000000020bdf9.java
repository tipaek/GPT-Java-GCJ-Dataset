import java.io.*;
import java.util.*;

class Solution implements Runnable {

    static void processTestCase(FastReader sc, PrintWriter out, int testCaseNumber) {
        int[] cSchedule = new int[1450];
        int[] jSchedule = new int[1450];

        int n = sc.nextInt();
        Timings[] activities = new Timings[n];

        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            activities[i] = new Timings(start, end, i);
        }

        char[] result = new char[n];
        Arrays.sort(activities, new TimingsComparator());

        for (Timings activity : activities) {
            int start = activity.start;
            int end = activity.end;

            if (isAvailable(cSchedule, start, end)) {
                markSchedule(cSchedule, start, end);
                result[activity.index] = 'C';
            } else if (isAvailable(jSchedule, start, end)) {
                markSchedule(jSchedule, start, end);
                result[activity.index] = 'J';
            } else {
                out.println("Case #" + testCaseNumber + ": IMPOSSIBLE");
                return;
            }
        }

        out.println("Case #" + testCaseNumber + ": " + new String(result));
    }

    public void run() {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);

        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            processTestCase(sc, out, i);
        }

        out.close();
    }

    static class TimingsComparator implements Comparator<Timings> {
        public int compare(Timings a, Timings b) {
            if (a.start != b.start) {
                return a.start - b.start;
            }
            return a.end - b.end;
        }
    }

    static void markSchedule(int[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            schedule[i] = 1;
        }
    }

    static boolean isAvailable(int[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule[i] == 1) {
                return false;
            }
        }
        return true;
    }

    static class Timings {
        int start, end, index;

        Timings(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        public String toString() {
            return "[" + start + " " + end + "]";
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args) throws Exception {
        new Thread(null, new Solution(), "Main", 1 << 27).start();
    }
}