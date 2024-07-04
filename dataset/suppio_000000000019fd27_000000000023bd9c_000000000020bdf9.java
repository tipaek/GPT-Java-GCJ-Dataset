import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    private static class FastReader {
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

    public static class Event implements Comparable<Event> {
        int time;
        char type;
        int index;

        public Event(int time, char type, int index) {
            this.time = time;
            this.type = type;
            this.index = index;
        }

        @Override
        public int compareTo(Event event) {
            return this.time - event.time;
        }

        @Override
        public String toString() {
            return "[" + this.time + ", " + this.type + ", " + this.index + "]";
        }
    }

    public static final int AVAILABLE = -1;

    public static void main(final String[] args) throws IOException {
        FastReader in = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);

        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = in.nextInt();
            List<Event> events = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                events.add(new Event(in.nextInt(), 'S', j));
                events.add(new Event(in.nextInt(), 'E', j));
            }
            Collections.sort(events);

            char[] schedule = new char[n];
            int doing = 0;
            int c = AVAILABLE;
            int j = AVAILABLE;

            for (Event event : events) {
                if (event.type == 'S') {
                    if (c == AVAILABLE) {
                        c = event.index;
                        schedule[event.index] = 'C';
                    } else if (j == AVAILABLE) {
                        j = event.index;
                        schedule[event.index] = 'J';
                    } else {
                        break;
                    }
                    doing++;
                } else {
                    if (c == event.index) {
                        c = AVAILABLE;
                    } else {
                        j = AVAILABLE;
                    }
                    doing--;
                }
            }
            if (doing != 0) {
                out.printf("Case #%d: IMPOSSIBLE%n", i);
            } else {
                out.printf("Case #%d: %s%n", i, String.valueOf(schedule));
            }
        }
    }
}
