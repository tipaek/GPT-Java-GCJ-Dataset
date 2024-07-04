import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        InputReader in = new InputReader(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        int t = in.nextInt();
        for (int z = 1; z <= t; z++) {
            int n = in.nextInt();
            List<Event> events = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int start = in.nextInt();
                int end = in.nextInt();
                events.add(new Event(start, i, true));
                events.add(new Event(end, i, false));
            }
            events.sort(Comparator.comparingInt((Event e) -> e.time).thenComparing(e -> !e.isStart));

            char[] schedule = new char[n];
            boolean cBusy = false, jBusy = false;
            boolean impossible = false;

            for (Event event : events) {
                if (event.isStart) {
                    if (!cBusy) {
                        schedule[event.index] = 'C';
                        cBusy = true;
                    } else if (!jBusy) {
                        schedule[event.index] = 'J';
                        jBusy = true;
                    } else {
                        impossible = true;
                        break;
                    }
                } else {
                    if (schedule[event.index] == 'C') {
                        cBusy = false;
                    } else {
                        jBusy = false;
                    }
                }
            }

            if (impossible) {
                pw.println("Case #" + z + ": IMPOSSIBLE");
            } else {
                pw.print("Case #" + z + ": ");
                pw.println(new String(schedule));
            }
        }
        pw.close();
    }

    static class Event {
        int time;
        int index;
        boolean isStart;

        Event(int time, int index, boolean isStart) {
            this.time = time;
            this.index = index;
            this.isStart = isStart;
        }
    }

    static class InputReader {
        BufferedReader br;
        StringTokenizer st;

        public InputReader(InputStream inputStream) {
            br = new BufferedReader(new InputStreamReader(inputStream));
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
}