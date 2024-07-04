import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int testCases = sc.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int n = sc.nextInt();
            Event[] events = new Event[2 * n];
            char[] result = new char[n];
            boolean[] isTaken = new boolean[2];
            char[] output = {'C', 'J'};
            
            for (int i = 0; i < n; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                events[2 * i] = new Event(start, i, false);
                events[2 * i + 1] = new Event(end, i, true);
            }
            
            Arrays.sort(events);
            boolean possible = true;
            
            for (int i = 0; i < 2 * n && possible; i++) {
                int index = events[i].index;
                if (events[i].isEnd) {
                    if (result[index] == 'J') {
                        isTaken[1] = false;
                    } else {
                        isTaken[0] = false;
                    }
                } else {
                    if (!isTaken[0]) {
                        isTaken[0] = true;
                        result[index] = output[0];
                    } else if (!isTaken[1]) {
                        isTaken[1] = true;
                        result[index] = output[1];
                    } else {
                        possible = false;
                    }
                }
            }
            
            if (possible) {
                out.printf("Case #%d: %s\n", t, new String(result));
            } else {
                out.printf("Case #%d: IMPOSSIBLE\n", t);
            }
        }
        
        out.flush();
        out.close();
    }

    static class Event implements Comparable<Event> {
        int time;
        int index;
        boolean isEnd;

        Event(int time, int index, boolean isEnd) {
            this.time = time;
            this.index = index;
            this.isEnd = isEnd;
        }

        @Override
        public int compareTo(Event other) {
            return Integer.compare(this.time, other.time);
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