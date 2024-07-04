import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(reader.readLine());
        for (int q = 1; q <= t; q++) {
            int n = Integer.parseInt(reader.readLine());
            Event[] events = new Event[2 * n];
            for (int i = 0; i < n; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                int start = Integer.parseInt(tokenizer.nextToken());
                int end = Integer.parseInt(tokenizer.nextToken());
                events[i * 2] = new Event(start, 0, i * 2 + 1, i * 2);
                events[i * 2 + 1] = new Event(end, 1, i * 2, i * 2 + 1);
            }
            writer.print("Case #" + q + ": ");
            Arrays.sort(events);
            StringBuilder result = new StringBuilder();
            int cameron = -1;
            int jamie = -1;
            boolean impossible = false;

            for (Event event : events) {
                if (cameron != -1 && jamie != -1 && event.type == 0) {
                    result = new StringBuilder("IMPOSSIBLE");
                    impossible = true;
                    break;
                }
                if (event.type == 1) {
                    if (cameron == event.otherIndex) {
                        cameron = -1;
                    } else {
                        jamie = -1;
                    }
                } else {
                    if (cameron == -1) {
                        result.append("C");
                        cameron = event.index;
                    } else if (jamie == -1) {
                        result.append("J");
                        jamie = event.index;
                    }
                }
            }
            if (!impossible) {
                writer.println(result);
            } else {
                writer.println("IMPOSSIBLE");
            }
        }

        reader.close();
        writer.close();
    }
}

class Event implements Comparable<Event> {
    int time;
    int type;
    int otherIndex;
    int index;

    public Event(int time, int type, int otherIndex, int index) {
        this.time = time;
        this.type = type;
        this.otherIndex = otherIndex;
        this.index = index;
    }

    @Override
    public int compareTo(Event other) {
        if (this.time == other.time) {
            return other.type - this.type;
        }
        return this.time - other.time;
    }
}