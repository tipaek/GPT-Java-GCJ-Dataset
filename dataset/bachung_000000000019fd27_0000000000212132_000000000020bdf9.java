import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(reader.readLine());

        for (int i = 0; i < T; i++) solve(reader, i + 1);
    }

    static void solve(BufferedReader reader, int num) throws Exception {
        int N = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer;

        Event[] events = new Event[N];

        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(reader.readLine());

            int start = Integer.parseInt(tokenizer.nextToken());
            int end = Integer.parseInt(tokenizer.nextToken());
            events[i] = new Event(start, end, i);
        }
        Arrays.sort(events);
        int C = -1, J = -1;
        boolean possible = true;
        for (Event event : events) {
            if (event.start >= C && event.start >= J) {
                if (C > J) {
                    C = event.end;
                    event.assignment = 'C';
                } else {
                    J = event.end;
                    event.assignment = 'J';
                }
            } else if (event.start >= C) {
                C = event.end;
                event.assignment = 'C';
            } else if (event.start >= J) {
                J = event.end;
                event.assignment = 'J';
            } else {
                possible = false;
            }
        }
        String str = null;
        if (!possible) {
            str = "IMPOSSIBLE";
        } else {
            char[] chars = new char[events.length];
            for (Event e : events) {
                chars[e.idx] = e.assignment;
            }
            str = new String(chars);
        }
        
        System.out.printf("Case #%d: %s%n", num, str);
    }

    static class Event implements Comparable<Event> {
        int start, end, idx;
        char assignment;

        Event(int start, int end, int idx) {
            this.start = start;
            this.end = end;
            this.idx = idx;
        }

        public int compareTo(Event o) {
            int cmp = Integer.compare(end, o.end);
            if (cmp != 0) return cmp;
            cmp = Integer.compare(start, o.start);
            if (cmp != 0) return cmp;
            return Integer.compare(idx, o.idx);
        }
    }
}