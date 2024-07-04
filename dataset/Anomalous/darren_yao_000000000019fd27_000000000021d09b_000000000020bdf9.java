import java.io.*;
import java.util.*;

public class Solution {

    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    static InputReader input = new InputReader(System.in);
    static PrintWriter output = new PrintWriter(System.out);

    public static void main(String[] args) {
        int testCases = input.nextInt();
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int eventCount = input.nextInt();
            List<Event> events = new ArrayList<>();
            for (int i = 0; i < eventCount; i++) {
                int start = input.nextInt();
                int end = input.nextInt();
                events.add(new Event(start, end, i));
            }
            Collections.sort(events);

            int cAvailableAt = 0;
            int jAvailableAt = 0;
            boolean isPossible = true;

            for (Event event : events) {
                if (cAvailableAt <= event.start) {
                    cAvailableAt = event.end;
                    event.assignment = 'C';
                } else if (jAvailableAt <= event.start) {
                    jAvailableAt = event.end;
                    event.assignment = 'J';
                } else {
                    isPossible = false;
                    break;
                }
            }

            output.print("Case #" + caseNum + ": ");
            if (!isPossible) {
                output.print("IMPOSSIBLE");
            } else {
                events.sort(Comparator.comparingInt(e -> e.id));
                for (Event event : events) {
                    output.print(event.assignment);
                }
            }
            output.println();
        }

        output.close();
    }

    static class Event implements Comparable<Event> {
        int start;
        int end;
        int id;
        char assignment;

        public Event(int start, int end, int id) {
            this.start = start;
            this.end = end;
            this.id = id;
            this.assignment = ' ';
        }

        @Override
        public int compareTo(Event other) {
            return Integer.compare(this.start, other.start);
        }
    }
}