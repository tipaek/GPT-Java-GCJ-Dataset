import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception {
        FastScanner scanner = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int N = scanner.nextInt();
            Event[] events = new Event[N * 2];
            char[] schedule = new char[N];
            boolean[] isOccupied = new boolean[2];
            char[] assign = {'C', 'J'};
            
            for (int i = 0; i < N; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                events[i * 2] = new Event(start, i, false);
                events[i * 2 + 1] = new Event(end - 1, i, true);
            }
            
            Arrays.sort(events);
            boolean possible = true;
            
            for (int i = 0; i < events.length && possible; i++) {
                Event event = events[i];
                int index = event.index;
                
                if (event.isEnd) {
                    if (schedule[index] == 'J') {
                        isOccupied[1] = false;
                    } else {
                        isOccupied[0] = false;
                    }
                } else {
                    if (!isOccupied[0]) {
                        isOccupied[0] = true;
                        schedule[index] = assign[0];
                    } else if (!isOccupied[1]) {
                        isOccupied[1] = true;
                        schedule[index] = assign[1];
                    } else {
                        possible = false;
                    }
                }
            }
            
            if (possible) {
                out.printf("Case #%d: %s\n", t, new String(schedule));
            } else {
                out.printf("Case #%d: IMPOSSIBLE\n", t);
            }
        }
        
        out.flush();
        out.close();
    }

    static class Event implements Comparable<Event> {
        int time;
        boolean isEnd;
        int index;

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