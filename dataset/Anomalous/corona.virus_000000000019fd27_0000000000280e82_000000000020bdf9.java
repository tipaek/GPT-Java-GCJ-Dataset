import java.io.*;
import java.util.*;

public class Solution {

    static class Event implements Comparable<Event> {
        int id;
        int start;
        int end;

        public Event(int id, int start, int end) {
            this.id = id;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Event other) {
            if (this.start != other.start) {
                return Integer.compare(this.start, other.start);
            }
            if (this.end != other.end) {
                return Integer.compare(this.end, other.end);
            }
            return Integer.compare(this.id, other.id);
        }

        @Override
        public String toString() {
            return this.start + " : " + this.end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCases = Integer.parseInt(reader.readLine());
        int caseNumber = 1;

        while (testCases-- > 0) {
            int n = Integer.parseInt(reader.readLine());
            Event[] events = new Event[n];

            for (int i = 0; i < n; i++) {
                String[] input = reader.readLine().split(" ");
                events[i] = new Event(i, Integer.parseInt(input[0]), Integer.parseInt(input[1]));
            }

            writer.append("Case #").append(String.valueOf(caseNumber++)).append(": ").append(solve(events));
            if (testCases > 0) {
                writer.append("\n");
            }
        }

        writer.close();
    }

    private static String solve(Event[] events) {
        Arrays.sort(events);
        int[] buffer = {-1, -1};
        int pointer = 0;
        List<String[]> output = new ArrayList<>();

        while (pointer < events.length) {
            if (buffer[0] == -1) {
                buffer[0] = pointer++;
            }
            if (pointer == events.length) {
                break;
            }
            if (buffer[1] == -1) {
                buffer[1] = pointer++;
            }

            Event event;
            if (events[buffer[0]].end <= events[buffer[1]].end) {
                event = events[buffer[0]];
                buffer[0] = -1;
                output.add(new String[]{String.valueOf(event.id), "C"});
            } else {
                event = events[buffer[1]];
                buffer[1] = -1;
                output.add(new String[]{String.valueOf(event.id), "J"});
            }

            if (pointer < events.length && event.end > events[pointer].start) {
                return "IMPOSSIBLE";
            }
        }

        if (buffer[0] != -1) {
            output.add(new String[]{String.valueOf(events[buffer[0]].id), "C"});
        }
        if (buffer[1] != -1) {
            output.add(new String[]{String.valueOf(events[buffer[1]].id), "J"});
        }

        StringBuilder result = new StringBuilder();
        output.sort(Comparator.comparingInt(a -> Integer.parseInt(a[0])));
        for (String[] entry : output) {
            result.append(entry[1]);
        }

        return result.toString();
    }
}