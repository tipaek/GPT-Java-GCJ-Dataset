import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int testCaseCount = sc.nextInt();

        for (int caseNumber = 1; caseNumber <= testCaseCount; caseNumber++) {
            boolean[] isTaken = new boolean[2];
            char[] output = {'C', 'J'};
            int eventCount = sc.nextInt();
            char[] schedule = new char[eventCount];
            Event[] events = new Event[eventCount * 2];

            for (int i = 0; i < eventCount; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                events[i * 2] = new Event(start, i, 1);
                events[i * 2 + 1] = new Event(end, i, -1);
            }

            Arrays.sort(events);
            boolean isPossible = true;

            for (int i = 0; i < events.length && isPossible; i++) {
                int index = events[i].index;
                if (events[i].type == -1) {
                    isTaken[schedule[index] == 'J' ? 1 : 0] = false;
                } else {
                    if (!isTaken[0]) {
                        isTaken[0] = true;
                        schedule[index] = output[0];
                    } else if (!isTaken[1]) {
                        isTaken[1] = true;
                        schedule[index] = output[1];
                    } else {
                        isPossible = false;
                    }
                }
            }

            if (isPossible) {
                out.printf("Case #%d: %s\n", caseNumber, new String(schedule));
            } else {
                out.printf("Case #%d: IMPOSSIBLE\n", caseNumber);
            }
        }

        out.flush();
        out.close();
    }

    static class Event implements Comparable<Event> {
        int time;
        int type;
        int index;

        Event(int time, int index, int type) {
            this.time = time;
            this.index = index;
            this.type = type;
        }

        @Override
        public int compareTo(Event other) {
            if (this.time != other.time) {
                return this.time - other.time;
            }
            return this.type - other.type;
        }
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String next() throws Exception {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        int nextInt() throws Exception {
            return Integer.parseInt(next());
        }

        long nextLong() throws Exception {
            return Long.parseLong(next());
        }

        double nextDouble() throws Exception {
            return Double.parseDouble(next());
        }
    }
}