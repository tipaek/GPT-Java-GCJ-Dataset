import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        for (int i = 0; i < T; i++) {
            processTestCase(reader, i + 1);
        }
    }

    private static void processTestCase(BufferedReader reader, int caseNumber) throws Exception {
        int N = Integer.parseInt(reader.readLine());
        Event[] events = new Event[N];
        
        for (int i = 0; i < N; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int start = Integer.parseInt(tokenizer.nextToken());
            int end = Integer.parseInt(tokenizer.nextToken());
            events[i] = new Event(start, end, i);
        }
        
        Arrays.sort(events);
        int endC = -1, endJ = -1;
        boolean isPossible = true;
        
        for (Event event : events) {
            if (event.start >= endC && event.start >= endJ) {
                if (endC <= endJ) {
                    endC = event.end;
                    event.assignment = 'C';
                } else {
                    endJ = event.end;
                    event.assignment = 'J';
                }
            } else if (event.start >= endC) {
                endC = event.end;
                event.assignment = 'C';
            } else if (event.start >= endJ) {
                endJ = event.end;
                event.assignment = 'J';
            } else {
                isPossible = false;
                break;
            }
        }
        
        String result = isPossible ? getAssignments(events) : "IMPOSSIBLE";
        System.out.printf("Case #%d: %s%n", caseNumber, result);
    }

    private static String getAssignments(Event[] events) {
        char[] assignments = new char[events.length];
        for (Event event : events) {
            assignments[event.index] = event.assignment;
        }
        return new String(assignments);
    }

    static class Event implements Comparable<Event> {
        int start, end, index;
        char assignment;

        Event(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        @Override
        public int compareTo(Event other) {
            int cmp = Integer.compare(this.end, other.end);
            if (cmp != 0) return cmp;
            cmp = Integer.compare(this.start, other.start);
            return (cmp != 0) ? cmp : Integer.compare(this.index, other.index);
        }
    }
}