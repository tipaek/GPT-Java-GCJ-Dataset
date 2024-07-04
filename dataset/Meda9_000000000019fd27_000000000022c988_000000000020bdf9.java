import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        String[] res = new String[t];

        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            Event[] events = new Event[n];

            for (int j = 0; j < n; j++) {
                Event event = new Event(in.nextInt(),in.nextInt(),j);
                events[j] = event;
            }
            res[i - 1] = helper(events);
        }
        for (int i = 1; i <= res.length; i++) {
            System.out.println("Case #" + i + ": " + res[i - 1]);
        }
    }

    private static String helper(Event[] events) {
        char[] order = new char[events.length];
        Arrays.sort(events);
        int jTime = 0;
        int cTime = 0;

        for (Event event : events) {
            if (event.start >= cTime) {
                cTime = event.end;
                order[event.order] = 'C';
            } else if (event.start >= jTime) {
                jTime = event.end;
                order[event.order] ='J';
            } else {
                return "IMPOSSIBLE";
            }
        }
        StringBuilder sb = new StringBuilder(events.length);
        for (char c:order){
            sb.append(c);
        }
        return sb.toString();
    }

    static class Event implements Comparable<Event> {
        int start;
        int end;
        int order;

        Event(int start, int end, int order) {
            this.start = start;
            this.end = end;
            this.order = order;
        }

        @Override
        public int compareTo(Event that) {
            if (this.start == that.start) {
                return Integer.compare(this.end, that.end);
            }
            return Integer.compare(this.start, that.start);
        }
    }
}